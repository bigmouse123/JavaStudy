package com.situ.web.dao;

import com.situ.web.pojo.User;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 14:06
 */
public interface IUserDao {
    User login(String username, String password);
}
