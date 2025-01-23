package com.situ.houserent.view;

import com.situ.houserent.domain.House;
import com.situ.houserent.service.HouseService;
import com.situ.houserent.utils.Utility;

/**
 * @author 李建坤
 * @version 1.0
 * @date 2025/1/12 22:19
 */
public class HouseView {

    boolean loop = true;
    char key = ' ';
    HouseService houseService = new HouseService(10);

    public void listHouse() {
        House[] houses = houseService.list();
        System.out.println("==============房屋列表==============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
    }

    public void addHouse() {
        System.out.println("==============添加房屋==============");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(12);
        System.out.print("地址: ");
        String address = Utility.readString(16);
        System.out.print("月租: ");
        int rent = Utility.readInt(16);
        System.out.print("状态(未出租/已出租): ");
        String state = Utility.readString(16);
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("==============添加成功==============");
        } else {
            System.out.println("==============添加失败==============");
        }

    }

    public void deleteHouse() {
        System.out.println("==============删除房屋信息==============");
        System.out.print("请选择删除房屋的编号(-1删除):");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("放弃删除房屋信息");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.delete(delId)) {
                System.out.println("删除房屋信息成功");
            } else {
                System.out.println("房屋编号不存在,删除房屋信息失败");
            }
        } else {
            System.out.println("放弃删除房屋信息");
        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void findHouse() {
        System.out.println("==============查找房屋信息==============");
        System.out.print("请输入房屋编号(-1退出):");
        int findId = Utility.readInt();
        if (findId == -1) {
            return;
        }
        House house = houseService.find(findId);
        if (house == null) {
            System.out.println("房屋编号不存在");
            return;
        }

        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        System.out.println(house);
    }

    public void updateHouse() {
        System.out.println("==============修改房屋信息==============");
        System.out.print("请输入要修改的房屋编号(-1退出):");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            return;
        }
        House house = houseService.find(updateId);
        if (house == null) {
            System.out.println("房屋编号不存在");
            return;
        }
        System.out.print("姓名(" + house.getName() + "):");
        house.setName(Utility.readString(8, house.getName()));
        System.out.print("电话(" + house.getPhone() + "):");
        house.setPhone(Utility.readString(12, house.getPhone()));
        System.out.print("地址(" + house.getAddress() + "):");
        house.setAddress(Utility.readString(16, house.getAddress()));
        System.out.print("租金(" + house.getRent() + "):");
        house.setRent(Utility.readInt(house.getRent()));
        System.out.print("状态(" + house.getState() + "):");
        house.setState(Utility.readString(16, house.getState()));
        System.out.println("==============修改完成==============");

    }

    public void mainVenu() {

        do {
            System.out.println("\n==============房屋出租系统菜单==============");
            System.out.println("\t\t\t1 新 增 房 屋");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退            出");
            System.out.print("请输入你的选择(1~6):");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("输入有误");
            }
        } while (loop);
    }
}
