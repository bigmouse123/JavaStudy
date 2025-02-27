package com.jiankun.spring.proxy;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/2/27 10:33
 */
public class MiShu implements IQianzi {
    private DongShiZhang dongShiZhang;

    public MiShu(DongShiZhang dongShiZhang) {
        this.dongShiZhang = dongShiZhang;
    }

    @Override
    public void qianzi() {
        System.out.println("MiShu.qianzi 开启事务");
        System.out.println("MiShu.qianzi 前期工作");
        dongShiZhang.qianzi();
        System.out.println("MiShu.qianzi 后期收尾");
        System.out.println("MiShu.qianzi 关闭事务");
    }
}
