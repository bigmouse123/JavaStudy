package com.situ.houserent.service;

import com.situ.houserent.domain.House;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/12 22:38
 */
public class HouseService {
    House[] houses;
    int houseNum = 1;
    int counter = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "李建坤", "123456", "青岛", 2000, "已出租");

    }

    public House[] list() {
        return houses;
    }

    public boolean add(House newHouse) {
        if (houseNum == houses.length) {
            System.out.println("数组已满,不能再添加!");
            return false;
        }
        houses[houseNum++] = newHouse;
        newHouse.setId(++counter);
        return true;
    }

    public boolean delete(int delId) {
        int index = -1;
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == delId) {
                index = i;
            }

        }

        if (index == -1) {
            return false;
        }

        for (int i = index; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
        return true;
    }

    public House find(int findId) {
        for (int i = 0; i < houseNum; i++) {
            if (houses[i].getId() == findId) {
                return houses[i];
            }
        }
        return null;
    }

}
