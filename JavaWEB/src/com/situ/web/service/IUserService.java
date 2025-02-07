package com.situ.web.service;

import com.situ.web.pojo.User;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/7 14:03
 */
public interface IUserService {
    User login(String username, String password);
}
