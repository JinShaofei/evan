package cola.redis;

import redis.clients.jedis.JedisPubSub;

/**
 * 
 * @author shaofeijin
 *
 */
public class MyPubSub extends JedisPubSub {

    /**
     * 取得按表达式的方式订阅的消息后的处理
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(pattern + "=" + channel + "=" + message);
    }

}
