package com.jiankun.ssm.mapper;


import com.jiankun.ssm.pojo.Student;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/27 15:10
 */
public interface StudentMapper {
    List<Student> selectAll();
}
