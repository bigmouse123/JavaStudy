package com.jiankun.springboot;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/5 15:00
 */
public class JedisTest {

    @Test
    public void test1() {
        //1.连接Jedis
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //2.操作Jedis
        jedis.set("name", "李四");
        //3.关闭Jedis
        jedis.close();
    }

    @Test
    public void test2() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
}
