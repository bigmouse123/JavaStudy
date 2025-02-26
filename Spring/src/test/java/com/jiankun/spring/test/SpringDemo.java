package com.jiankun.spring.test;

import com.jiankun.spring.controller.BanjiController;
import com.jiankun.spring.controller.CourseController;
import com.jiankun.spring.controller.StudentController;
import com.jiankun.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 15:51
 */
public class SpringDemo {

    @Test
    public void test1() {
        //创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从Spring容器中根据名字取出new出来的对象
        Student student = (Student) context.getBean("student");
        System.out.println(student);

    }

    @Test
    public void test2() {
        //创建Spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从Spring容器中根据名字取出new出来的对象
        Student student1 = (Student) context.getBean("student");
        Student student2 = (Student) context.getBean("student");
        System.out.println(student1 == student2);

    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentController studentController = (StudentController) context.getBean("studentController");
        studentController.selectAll();
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseController courseController = (CourseController) context.getBean("courseController");
        courseController.selectAll();
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BanjiController banjiController = (BanjiController) context.getBean("banjiController");
        banjiController.selectAll();
    }
}
