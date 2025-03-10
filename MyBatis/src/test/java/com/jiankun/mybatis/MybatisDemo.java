package com.jiankun.mybatis;

import com.jiankun.mybatis.pojo.Banji;
import com.jiankun.mybatis.pojo.Student;
import com.jiankun.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/25 10:42
 */
public class MybatisDemo {
//    @Test
//    public void testSelectById() throws IOException {
//        String resource = "mybatis.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 创建 SqlSessionFactory    Session:会话 (连接数据库后就建立了一次会话，有了会话就可以操作数据库)
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 得到SqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 执行sql语句
//        Student student = sqlSession.selectOne("student.selectById", 1);
//        System.out.println(student);
//    }

    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql语句
        Student student = sqlSession.selectOne("student.selectById", 1);
        System.out.println(student);
    }

    @Test
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql语句
        List<Student> list = sqlSession.selectList("student.selectAll");
        for (Student student : list) {
            System.out.println(student);
        }
    }

//    @Test
//    public void testSelectAll() throws IOException {
//        SqlSession sqlSession = MyBatisUtils.getSqlSession();
//        // 执行sql语句
//        List<Banji> list = sqlSession.selectList("banji.selectAll");
//        for (Banji banji : list) {
//            System.out.println(banji);
////            for (Student student : banji.getList()) {
////                System.out.println(student);
////            }
//        }
//    }

    @Test
    public void testDelete() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql语句
        sqlSession.delete("student.deleteById", 35);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql语句
        Student student = new Student(3, "李建坤", 22, "男", 1);
        int count = sqlSession.update("student.update", student);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Student student = new Student(null, "坤建立", 21, "女", 2);
        int count = sqlSession.insert("student.add", student);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByPage() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        int pageNo = 2;
        int pageSize = 3;
        int offset = (pageNo - 1) * pageSize;
        Map<String, Object> map = new HashMap<>();
        map.put("offset", offset);
        map.put("limit", pageSize);
        List<Student> list = sqlSession.selectList("student.selectByPage", map);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectTotalCount() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        int count = sqlSession.selectOne("student.selectTotalCount");
        System.out.println(count);
    }

    @Test
    public void testSelectStudentBanjiInfo() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql语句
        List<Student> list = sqlSession.selectList("student.selectStudentBanjiInfo");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testSelectBanjiStudentInfo() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行sql语句
        List<Banji> list = sqlSession.selectList("banji.selectBanjiStudentInfo");
        for (Banji banji : list) {
            System.out.println(banji);
            for (Student student : banji.getList()) {
                System.out.println(student);
            }
        }
    }

    @Test
    public void testselectByCondition() throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Student stu = new Student();
        stu.setName("d");
        stu.setGender("男");
        List<Student> list = sqlSession.selectList("student.selectByCondition", stu);
        for (Student student : list) {
            System.out.println(student);
        }
    }

    @Test
    public void testUpdateCondition() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Student student = new Student();
        student.setId(1);
        student.setName("李建坤");
        student.setAge(22);
        //student.setGender("女");
        int count = sqlSession.update("student.updateCondition", student);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testDeleteAllByArray() {
        int[] array = {34, 37};
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        int count = sqlSession.delete("student.deleteAllByArray", array);
        System.out.println("count: " + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteAllByList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(30);
        list.add(33);
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        int count = sqlSession.delete("student.deleteAllByList", list);
        System.out.println("count: " + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition1() {
        Student student = new Student();
        //student.setName("王");
        student.setAge(25);
        student.setGender("女");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        List<Student> list = sqlSession.selectList("student.selectByCondition1", student);
        for (Student s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testAddSelective() {
        Student student = new Student();
        student.setName("王");
        student.setAge(23);
        student.setGender("女");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        int count = sqlSession.insert("student.addSelective", student);
        System.out.println("count: " + count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateSelective() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        Student student = new Student();
        student.setId(31);
        student.setName("张三");
        student.setAge(35);
        //student.setGender("女");
        int count = sqlSession.update("student.updateSelective", student);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testSelectByCondition2() {
        Student student = new Student();
        //student.setName("王");
        student.setAge(25);
        student.setGender("女");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        List<Student> list = sqlSession.selectList("student.selectByCondition2", student);
        for (Student s : list) {
            System.out.println(s);
        }
    }

}
