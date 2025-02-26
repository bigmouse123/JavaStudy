package com.jiankun.spring.pojo;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 15:27
 */
public class Student {
    private Integer id = 1;
    private String name = "张三";
    private Integer age = 20;
    private String gender = "男";
    private Banji banji;

    public Student() {
        System.out.println("Student.Student");
    }

    public Student(Integer id, String name, Integer age, String gender, Banji banji) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.banji = banji;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("Student.setId");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Banji getBanji() {
        return banji;
    }

    public void setBanji(Banji banji) {
        this.banji = banji;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", banji=" + banji +
                '}';
    }
}
