package com.jiankun.springboot.controller;

import com.jiankun.springboot.pojo.Type;
import com.jiankun.springboot.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/5 16:06
 */
@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private ITypeService typeService;
    @Autowired
    private RedisTemplate redisTemplate;

    private Map<String, List<Type>> map = new HashMap<>();

    @RequestMapping("/list1")
    public List<Type> list1() {
        List<Type> list = map.get("list");
        if (CollectionUtils.isEmpty(list)) {
            list = typeService.list();
            map.put("list", list);
        }
        return list;
    }

    @RequestMapping("/list")
    public List<Type> list() {
        List list = redisTemplate.opsForList().range("list", 0, -1);
        if (CollectionUtils.isEmpty(list)) {
            list = typeService.list();
            redisTemplate.opsForList().leftPushAll("list", list);
        }
        return list;
    }
}
