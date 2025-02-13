package com.situ.web.pojo;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/13 10:57
 */
public class Province {
    private Integer id;
    private String name;

    public Province() {
    }

    public Province(Integer id, String name) {
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
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
