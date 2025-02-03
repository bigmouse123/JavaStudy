package com.situ.web.pojo;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/24 14:13
 */
public class Banji {
    private int id;
    private String name;
    private String address;

    public Banji() {
    }

    public Banji(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Banji{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
