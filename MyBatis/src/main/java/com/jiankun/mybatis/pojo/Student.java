package com.jiankun.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/25 10:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer banjiId;
    private Banji banji;

    public Student(Integer id, String name, Integer age, String gender, Integer banjiId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.banjiId = banjiId;
    }
}
