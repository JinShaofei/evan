package cola.redis;

import cola.utils.RedisUtils;
import redis.clients.jedis.Jedis;

public class Sub {

    public static void main(String[] args) {
        Jedis jedis = RedisUtils.getInstance();
        MyPubSub myPubSub = new MyPubSub();
        jedis.psubscribe(myPubSub, "hello_*");// 订阅消息

        jedis.publish("hello_jinshaofei", "jinshaofei");// 发布消息

    }

}
