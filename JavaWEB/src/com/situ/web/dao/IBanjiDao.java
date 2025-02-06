package com.situ.web.dao;

import com.situ.web.pojo.Banji;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/4 3:42
 */
public interface IBanjiDao {
    List<Banji> selectAll();
    void deleteById(int id);
    void add(Banji banji);
    Banji selectById(int id);
    void update(Banji banji);
    List<Banji> selectByPage(int offset, int pageSize);
    int selectTotalCount();
}
