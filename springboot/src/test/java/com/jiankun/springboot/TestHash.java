package com.jiankun.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class TestHash {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSetValue(){
        redisTemplate.opsForHash().put("nameHash", "a", "唐僧");
        redisTemplate.opsForHash().put("nameHash", "b", "悟空");
        redisTemplate.opsForHash().put("nameHash", "c", "八戒");
        redisTemplate.opsForHash().put("nameHash", "d", "沙僧");
    }

    @Test
    public void testGetKeys(){
        Set keys = redisTemplate.opsForHash().keys("nameHash");
        System.out.println(keys);
    }

    @Test
    public void testGetValues(){
        List values = redisTemplate.opsForHash().values("nameHash");
        System.out.println(values);
    }

    @Test
    public void testGetValueByKey(){
        Object object = redisTemplate.opsForHash().get("nameHash", "b");
        System.out.println(object);
    }

    @Test
    public void testRemoveValueByKey(){
        redisTemplate.opsForHash().delete("nameHash", "c");
    }
}
