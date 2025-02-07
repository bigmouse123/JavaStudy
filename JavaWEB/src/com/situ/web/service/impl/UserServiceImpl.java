package com.situ.web.service.impl;

import com.situ.web.dao.IUserDao;
import com.situ.web.dao.impl.UserDaoImpl;
import com.situ.web.pojo.User;
import com.situ.web.service.IUserService;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 14:03
 */
public class UserServiceImpl implements IUserService {

    private IUserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
