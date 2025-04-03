package com.jiankun.spring.controller;

import com.jiankun.spring.service.IBanjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/26 19:51
 */
@Controller
public class BanjiController {
    @Autowired
    @Qualifier(value = "banjiServiceImpl2")
    private IBanjiService banjiService;

    public void selectAll() {
        System.out.println("BanjiController.selectAll");
        banjiService.selectAll();
    }
}
