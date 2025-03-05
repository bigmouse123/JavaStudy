package com.jiankun.springboot.service.impl;

import com.jiankun.springboot.mapper.TypeMapper;
import com.jiankun.springboot.pojo.Type;
import com.jiankun.springboot.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/5 16:10
 */
@Service
public class TypeMapperImpl implements ITypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> list() {
        return typeMapper.list();
    }
}
