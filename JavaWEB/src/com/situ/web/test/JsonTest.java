package com.situ.web.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.web.pojo.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/11 16:38
 */
public class JsonTest {

    @Test
    public void test1() throws JsonProcessingException {
        //1、创建Person对象
        Person person = new Person();
        person.setId(2);
        person.setName("张三");
        person.setAge(23);
        person.setGender("男");
        person.setBirthday(new Date());
        //2、创建Jackson核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
    }

    @Test
    public void test2() throws JsonProcessingException {
        //1、创建map对象
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("gender", "男");
        //2、创建Jackson核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"gender":"男","name":"张三","age":23}
        System.out.println(json);
    }

    @Test
    public void test3() throws IOException {
        // 1、创建一个json字符串
        // String json = "{"id":null,"name":"张三","age":23,"gender":"男"}";
        //转义
        String json = "{\"id\":null,\"name\":\"张三\",\"age\":23,\"gender\":\"男\"}";
        String a = "{\"id\":null,\"name\":\"张三\",\"age\":23,\"gender\":\"男\"}";
        //language=JSON
        //2、创建ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //3、json字符串转换为java对象
        Person person = mapper.readValue(json, Person.class);
        //Person{id=null, name='张三', age=23, gender='男'}
        System.out.println(person);
    }

}
