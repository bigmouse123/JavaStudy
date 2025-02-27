package com.jiankun.spring.proxy;

import com.jiankun.spring.service.IBanjiService;
import com.jiankun.spring.service.impl.BanjiServiceImpl;
import org.junit.Test;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/27 10:36
 */
public class ProxyDemo {
    public static void main(String[] args) {
        DongShiZhang dongShiZhang = new DongShiZhang();
        IQianzi miShu = new MiShu(dongShiZhang);
        miShu.qianzi();
    }

    @Test
    public void test1() {
        DongShiZhang dongShiZhang = new DongShiZhang();
        IQianzi proxy = (IQianzi) ProxyFactory.getProxyInstance(dongShiZhang);
        proxy.qianzi();
    }

    @Test
    public void test2() {
        IBanjiService banjiService = new BanjiServiceImpl();
        IBanjiService proxy = (IBanjiService) ProxyFactory.getProxyInstance(banjiService);
        proxy.selectAll();
        proxy.deleteById("1");
    }
}
