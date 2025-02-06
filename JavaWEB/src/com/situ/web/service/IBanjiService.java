package com.situ.web.service;

import com.situ.web.pojo.Banji;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 14:24
 */
public interface IBanjiService {
    List<Banji> selectAll();
    void deleteById(int id);
    void add(Banji banji);
    Banji selectById(int id);
    void update(Banji banji);
}
