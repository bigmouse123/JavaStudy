package com.jiankun.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testValue() {
        redisTemplate.opsForValue().set("name1", "lisi");
    }
    
    @Test
    public void testGetValue() {
        String name = (String) redisTemplate.opsForValue().get("name1");
        System.out.println(name);
    }

    @Test
    public void deleteVlaue() {
        redisTemplate.delete("name1");
    }




}
