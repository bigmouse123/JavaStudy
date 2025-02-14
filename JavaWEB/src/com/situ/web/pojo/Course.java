package com.situ.web.pojo;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/14 10:45
 */
public class Course {
    Integer id;
    String name;
    Integer credit;

    public Course() {
    }

    public Course(String name, Integer credit) {
        this.credit = credit;
        this.name = name;
    }

    public Course(Integer id, String name, Integer credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
