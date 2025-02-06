package com.situ.web.service.impl;

import com.situ.web.dao.IBanjiDao;
import com.situ.web.dao.impl.BanjiDaoImpl;
import com.situ.web.pojo.Banji;
import com.situ.web.service.IBanjiService;
import com.situ.web.utils.PageInfo;

import java.util.List;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/6 14:25
 */
public class BanjiServiceImpl implements IBanjiService {

    private IBanjiDao banjiDao = new BanjiDaoImpl();

    @Override
    public List<Banji> selectAll() {
        return banjiDao.selectAll();
    }

    @Override
    public void deleteById(int id) {
        banjiDao.deleteById(id);
    }

    @Override
    public void add(Banji banji) {
        banjiDao.add(banji);
    }

    @Override
    public Banji selectById(int id) {
        return banjiDao.selectById(id);
    }

    @Override
    public void update(Banji banji) {
        banjiDao.update(banji);
    }

    @Override
    public PageInfo<Banji> selectByPage(int pageNo, int pageSize) {
        int offset = (pageNo - 1) * pageSize;
        List<Banji> list = banjiDao.selectByPage(offset, pageSize);
        int totalCount = banjiDao.selectTotalCount();
        int totalPage = (int) Math.ceil((double) totalCount / pageSize);
        PageInfo<Banji> pageInfo = new PageInfo<>(list, totalPage, pageNo, pageSize);
        return pageInfo;
    }
}
