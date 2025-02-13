package com.situ.web.pojo;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/13 12:05
 */
public class Area {
    private Integer id;
    private String name;

    public Area() {
    }

    public Area(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
