package com.jiankun.springboot.service;

import com.jiankun.springboot.mapper.TypeMapper;
import com.jiankun.springboot.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/5 16:08
 */
public interface ITypeService {
    List<Type> list();
}
