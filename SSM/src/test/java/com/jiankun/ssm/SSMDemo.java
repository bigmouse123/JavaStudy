package com.jiankun.ssm;

import com.jiankun.ssm.mapper.StudentMapper;
import com.jiankun.ssm.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/28 8:52
 */
//帮助我们创建IOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载Spring的核心配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class SSMDemo {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void test1() {
        List<Student> list = studentMapper.selectAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
