package com.jiankun.spring.pojo;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 16:42
 */
public class Banji {
    private Integer id;
    private String name;

    public Banji() {
        System.out.println("Banji.Banji1");
    }

    public Banji(Integer id, String name) {
        System.out.println("Banji.Banji2");
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
        return "Banji{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
