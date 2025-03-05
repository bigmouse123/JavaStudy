package com.jiankun.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

@SpringBootTest
public class TestSet {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存入值
     */
    @Test
    public void setValue(){
        redisTemplate.opsForSet().add("nameSet", "操作");
        redisTemplate.opsForSet().add("nameSet", "刘备");
        redisTemplate.opsForSet().add("nameSet", "孙权");
    }

    /**
     * 提取值
     */
    @Test
    public void getValue(){
        Set members = redisTemplate.opsForSet().members("nameSet");
        System.out.println(members);
    }

    /**
     * 删除集合中的某一个值
     */
    @Test
    public void deleteValue(){
        redisTemplate.opsForSet().remove("nameSet", "孙权");
    }

    /**
     * 删除整个集合
     */
    @Test
    public void deleteAllValue(){
        redisTemplate.delete("nameSet");
    }
}