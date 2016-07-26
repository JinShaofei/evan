package cola.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

/**
 * 
 * @author shaofeijin
 *
 */
public class RedisUtils {
    private static Log logger = LogFactory.getLog(RedisUtils.class);

    static {
               pool = ApplicationContextHolder.getBeanByClazz(JedisPool.class);
    }
    // private static Jedis proxy=create();

    private static JedisPool pool;


    public static Set<String> smembers(final String key) {

        Jedis jedis = getJedis();
        Set<String>  members=jedis.smembers(key);
        jedis.close();
        return members;
    }

    /**
     * 直接在pool里取 缓存Jedis 实例时用此方法,需要手动close()
     *
     * @return
     */
    public static Jedis getInstance() {

        if (pool != null) {
            return pool.getResource();
        } else {
            return null;
        }
    }



    public static Jedis getJedis() {
        Jedis jedis = null;
        if (pool != null) {
            jedis = pool.getResource();
        }

        return jedis;
    }


    /**
     * 0.0 Description:通过key获取储存在redis中的value
     * <p>
     * 下午2:19:38
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        Jedis jedis = getJedis();
        String value = null;
        try {
            if (jedis != null) {
                value = jedis.get(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return value;

    }

    /**
     * 0.0 Description:向redis存入key和value,并释放连接资源,如果key已经存在 则覆盖
     * <p>
     * 下午2:30:19
     *
     * @param key
     * @param value
     * @return
     */
    public static String set(String key, String value) {
        Jedis jedis = getJedis();
        String result = "";
        try {
            if (jedis != null) {
                result = jedis.set(key, value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:删除指定的key,也可以传入一个包含key的数组 keys 一个key 也可以使 string 数组
     * 下午2:36:48
     *
     * @param keys
     * @return
     */
    public static Long del(String... keys) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.del(keys);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:通过key向指定的value值追加值
     * <p>
     * 下午2:42:17
     *
     * @param key
     * @param str
     * @return 成功，则返回添加后value的长度； 失败 ，则返回添加的 value 的长度 异常返回0L
     */
    public static Long append(String key, String str) {
        Jedis jedis = getJedis();
        Long res = 0L;
        try {
            if (jedis != null) {
                res = jedis.append(key, str);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * 0.0 Description:判断key是否存在
     * <p>
     * 下午2:58:12
     *
     * @param key
     * @return true OR false
     */
    public static Boolean exists(String key) {
        Jedis jedis = getJedis();
        boolean flag = false;
        try {
            if (jedis != null) {
                flag = jedis.exists(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return flag;
    }

    /**
     * 0.0 Description:设置key value,如果key已经存在则返回0
     * <p>
     * 下午3:01:58
     *
     * @param key
     * @param value
     * @return 成功返回1 如果存在 和 发生异常 返回 0
     */
    public static Long setnx(String key, String value) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.setnx(key, value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:设置key value并制定这个键值的有效期
     * <p>
     * 下午3:04:09
     *
     * @param key
     * @param value
     * @param seconds seconds 单位:秒
     * @return 成功返回OK 失败和异常返回null
     */
    public static String setex(String key,  int seconds,String value) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.setex(key, seconds, value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key 和offset 从指定的位置开始将原先value替换
     * <p>
     * 下午3:06:09
     *
     * @param key
     * @param str
     * @param offset 下标位置
     * @return 返回替换后 value 的长度
     */
    public static Long setrange(String key, String str, int offset) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.setrange(key, offset, str);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:通过批量的key获取批量的value keys string数组 也可以是一个key 下午3:08:42
     *
     * @param keys
     * @return 成功返回value的集合, 失败返回null的集合 ,异常返回空
     */
    public static List<String> mget(String... keys) {
        Jedis jedis = getJedis();
        List<String> values = null;
        try {
            if (jedis != null) {
                values = jedis.mget(keys);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return values;
    }

    /**
     * 0.0 Description:通过下标 和key 获取指定下标位置的 value
     * <p>
     * 下午3:14:21
     *
     * @param key
     * @param startOffset 开始位置 从0 开始 负数表示从右边开始截取
     * @param endOffset   如果没有返回null
     * @return
     */
    public static String getrange(String key, int startOffset, int endOffset) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.getrange(key, startOffset, endOffset);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key获取value值的长度
     * <p>
     * 下午3:16:37
     *
     * @param key
     * @return 失败返回null
     */
    public static Long serlen(String key) {
        Jedis jedis = getJedis();
        Long result = null;
        try {
            if (jedis != null) {
                result = jedis.strlen(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key向list头部添加字符串
     * <p>
     * 下午3:30:07
     *
     * @param key
     * @param strs 可以使一个string 也可以使string数组
     * @return 返回list的value个数
     */
    public static Long lpush(String key, String... strs) {
        Jedis jedis = getJedis();
        Long result = 0L;
        try {
            if (jedis != null) {
                result = jedis.lpush(key, strs);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key向list尾部添加字符串
     * <p>
     * 下午3:31:40
     *
     * @param key
     * @param strs 可以使一个string 也可以使string数组
     * @return 返回list的value个数
     */
    public static Long rpush(String key, String... strs) {
        Jedis jedis = getJedis();
        Long result = 0L;
        try {
            if (jedis != null) {
                result = jedis.rpush(key, strs);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key在list指定的位置之前或者之后 添加字符串元素
     * <p>
     * 下午3:32:50
     *
     * @param key
     * @param where LIST_POSITION枚举类型
     * @param pivot list里面的value
     * @param value 添加的value
     * @return
     */
    public static Long linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value) {
        Jedis jedis = getJedis();
        Long result = 0L;
        try {
            if (jedis != null) {
                result = jedis.linsert(key, where, pivot, value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key设置list指定下标位置的value 如果下标超过list里面value的个数则报错 下午3:35:01
     *
     * @param key
     * @param index 从0开始
     * @param value 成功返回OK
     * @return
     */
    public static String lset(String key, Long index, String value) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.lset(key, index, value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key从对应的list中删除指定的count个 和 value相同的元素
     * <p>
     * 下午3:37:34
     *
     * @param key
     * @param count 当count为0时删除全部
     * @param value
     * @return 返回被删除的个数
     */
    public static Long lrem(String key, long count, String value) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.lrem(key, count, value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return num;
    }

    /**
     * 0.0 Description:通过key保留list中从strat下标开始到end下标结束的value值
     * <p>
     * 下午3:39:33
     *
     * @param key
     * @param start
     * @param end
     * @return 成功返回OK
     */
    public static String ltrim(String key, long start, long end) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.ltrim(key, start, end);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 0.0 Description:通过key从list的头部删除一个value,并返回该value
     * <p>
     * 下午3:40:33
     *
     * @param key
     * @return
     */
    public static String lpop(String key) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.lpop(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 0.0 Description:通过key从list尾部删除一个value,并返回该元素
     * <p>
     * 下午3:41:49
     *
     * @param key
     * @return
     */
    public static String rpop(String key) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.rpop(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return result;
    }

    /**
     * 0.0 Description:通过key从一个list的尾部删除一个value并添加到另一个list的头部,并返回该value
     * 如果第一个list为空或者不存在则返回null 下午3:43:08
     *
     * @param srckey
     * @param dstkey
     * @return
     */
    public static String rpoplpush(String srckey, String dstkey) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.rpoplpush(srckey, dstkey);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key获取list中指定下标位置的value
     * <p>
     * 下午3:43:59
     *
     * @param key
     * @param index
     * @return 如果没有返回null
     */
    public static String lindex(String key, long index) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.lindex(key, index);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key返回list的长度
     * <p>
     * 下午3:44:32
     *
     * @param key
     * @return
     */
    public static Long llen(String key) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.llen(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:通过key获取list指定下标位置的value 如果start 为 0 end 为 -1
     * 则返回全部的list中的value 下午3:45:42
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static List<String> lrange(String key, long start, long end) {
        Jedis jedis = getJedis();
        List<String> result = null;
        try {
            if (jedis != null) {
                result = jedis.lrange(key, start, end);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:返回满足pattern表达式的所有key
     * <p>
     * 下午3:57:06
     *
     * @param pattern
     * @return
     */
    public static Set<String> keys(String pattern) {
        Jedis jedis = getJedis();
        Set<String> result = null;
        try {
            if (jedis != null) {
                result = jedis.keys(pattern);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 0.0 Description:通过key判断值的类型
     * <p>
     * 下午3:58:08
     *
     * @param key
     * @return
     */
    public static String type(String key) {
        Jedis jedis = getJedis();
        String result = null;
        try {
            if (jedis != null) {
                result = jedis.type(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return result;
    }

    /**
     * 有序集合（Sorted Sets）类型 0.0
     * Description:通过key向zset中添加value,score,其中score就是用来排序的
     * 如果该value已经存在则根据score更新元素 下午4:08:12
     *
     * @param key
     * @param scoreMembers
     * @return
     */
    public static Long zadd(String key, Map<String,Double> scoreMembers) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.zadd(key, scoreMembers);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return num;
    }

    /**
     * 0.0 Description:通过key向zset中添加value,score,其中score就是用来排序的
     * 如果该value已经存在则根据score更新元素
     * <p>
     * 下午4:09:22
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public static Long zadd(String key, double score, String member) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.zadd(key, score, member);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:通过key向zset中添加value,score,其中score就是用来排序的
     * 如果该value已经存在则根据score更新元素,每次score自增加1
     *
     * 下午4:09:22
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    /*
	 * public static Long zaddInc(String key,String member){ Jedis jedis =
	 * getJedis(); Long num = 0L; try { if(jedis != null) { Set<Tuple> elements
	 * = JedisUtil.zrevrangeWithScores(key, 0, 0); double score = 1; for (Tuple
	 * tuple : elements) { <span style="white-space:pre"> </span>score =
	 * tuple.getScore() + 0.1; } num = jedis.zadd(key, score, member); } } catch
	 * (Exception e) { returnBrokenResource(jedis); e.printStackTrace(); }
	 * finally { returnResource(jedis); }
	 *
	 *
	 * return num; }
	 */

    /**
     * 0.0 Description:通过key删除在zset中指定的value
     * <p>
     * 下午4:10:02
     *
     * @param key
     * @param members
     * @return
     */
    public static Long zrem(String key, String... members) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.zrem(key, members);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:通过key增加该zset中value的score的值
     * <p>
     * 下午4:11:17
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public static Double zincrby(String key, double score, String member) {
        Jedis jedis = getJedis();
        Double res = null;
        try {
            if (jedis != null) {
                res = jedis.zincrby(key, score, member);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * 0.0 Description:通过key返回zset中value的排名 下标从小到大排序 下午4:12:55
     *
     * @param key
     * @param member
     * @return
     */
    public static Long zrank(String key, String member) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.zrank(key, member);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:通过key返回zset中value的排名,下标从大到小排序
     * <p>
     * 下午4:13:49
     *
     * @param key
     * @param member
     * @return
     */
    public static Long zrevrank(String key, String member) {
        Jedis jedis = getJedis();
        Long num = 0L;
        try {
            if (jedis != null) {
                num = jedis.zrevrank(key, member);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return num;
    }

    /**
     * 0.0 Description:通过key将获取score从start到end中zset的value socre从大到小排序;当start为0
     * end为-1时返回全部 下午4:14:19
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> zrevrange(String key, long start, long end) {
        Jedis jedis = getJedis();
        Set<String> res = null;
        try {
            if (jedis != null) {
                res = jedis.zrevrange(key, start, end);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return res;
    }

    /**
     * 0.0 Description:通过key将获取score从start到end中zset的value socre从小到大排序;当start为0
     * end为-1时返回全部 下午4:14:19
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<String> zrange(String key, long start, long end) {
        Jedis jedis = getJedis();
        Set<String> res = null;
        try {
            if (jedis != null) {
                res = jedis.zrange(key, start, end);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }

        return res;
    }

    /**
     * 0.0 Description:通过key返回指定score内zset中的value
     * <p>
     * 下午4:15:34
     *
     * @param key
     * @param max
     * @param min
     * @return
     */
    public static Set<String> zrangebyscore(String key, String max, String min) {
        Jedis jedis = getJedis();
        Set<String> res = null;
        try {
            if (jedis != null) {
                res = jedis.zrevrangeByScore(key, max, min);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * 0.0 Description:通过key返回指定score内zset中的value
     * <p>
     * 下午4:15:34
     *
     * @param key
     * @param max
     * @param min
     * @return
     */
    public static Set<String> zrangeByScore(String key, double max, double min) {
        Jedis jedis = getJedis();
        Set<String> res = null;
        try {
            if (jedis != null) {
                res = jedis.zrevrangeByScore(key, max, min);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * <p>
     * 返回指定区间内zset中value的数量
     * </p>
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public static Long zcount(String key, String min, String max) {
        Jedis jedis = getJedis();
        Long res = null;
        try {
            if (jedis != null) {
                res = jedis.zcount(key, min, max);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key返回zset中的value个数
     * </p>
     *
     * @param key
     * @return
     */
    public static Long zcard(String key) {
        Jedis jedis = getJedis();
        Long res = 0L;
        try {
            if (jedis != null) {
                res = jedis.zcard(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key获取zset中value的score值
     * </p>
     *
     * @param key
     * @param member
     * @return
     */
    public static Double zscore(String key, String member) {
        Jedis jedis = getJedis();
        Double res = null;
        try {
            if (jedis != null) {
                res = jedis.zscore(key, member);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * <p>
     * 通过key删除给定区间内的元素
     * </p>
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Long zremrangeByRank(String key, long start, long end) {
        Jedis jedis = getJedis();
        Long res = 0L;
        try {
            if (jedis != null) {
                res = jedis.zremrangeByRank(key, start, end);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return res;
    }

    /**
     * 0.0 Description:
     * <p>
     * 上午11:19:47
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static Set<Tuple> zrevrangeWithScores(String key, long start, long end) {
        Jedis jedis = getJedis();
        Set<Tuple> sets = null;
        try {
            if (jedis != null) {
                sets = jedis.zrevrangeWithScores(key, start, end);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
        return sets;
    }

    /**
     * 0.0 Description:清空所有数据
     * <p>
     * 下午5:14:28
     */
    public static void flushAll() {
        Jedis jedis = getJedis();
        try {
            if (jedis != null) {
                jedis.flushAll();
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    /**
     * 0.0 Description:清空当前选择DB的所有数据
     * <p>
     * 下午5:14:28
     */
    public static void flushDB() {
        Jedis jedis = getJedis();
        try {
            if (jedis != null) {
                jedis.flushDB();
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            returnResource(jedis);
        }
    }

    public static Long sadd(final String key, final String... members){
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.sadd(key,members);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return null;
    }

    public static String srandmember(final String key) {
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.srandmember(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return null;
    }

    public static List<String> srandmember(final String key, final int count) {
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.srandmember(key,count);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return null;
    }

    public static Long expire(final String key, final int seconds) {
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.expire(key,seconds);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return 0L;
    }
    public static Long expireAt(final String key, final long unixTime) {
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.expireAt(key,unixTime);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return 0L;
    }

    public static Long hset(final String key, final String field, final String value) {
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.hset(key,field,value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return 0L;
    }

    public static Set<String> hkeys(final String key) {
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.hkeys(key);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return new HashSet<>();
    }

    public static List<String> hvals(final String value) {
        Jedis jedis = getJedis();

        try {
            if (jedis != null) {
                return jedis.hvals(value);
            }
        } catch (Exception e) {
            returnBrokenResource(jedis);
            e.printStackTrace();

        } finally {
            returnResource(jedis);
        }
        return new ArrayList<>();
    }
    /**
     * 0.0 Description:返还到连接池
     * <p>
     * 上午10:44:55
     *
     * @param jedis
     */
    public static void returnResource(Jedis jedis) {
        jedis.close();
    }

    /**
     * @see redis.clients.jedis.JedisPool#returnBrokenResource(Jedis)
     * @see {@link redis.clients.jedis.Jedis#close()}
     * @param jedis
     */
    public static void returnBrokenResource(Jedis jedis) {
//        jedis.close();
    }


}