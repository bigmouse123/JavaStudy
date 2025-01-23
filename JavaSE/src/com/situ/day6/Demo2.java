package com.situ.day6;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/1/16 21:12
 */
public class Demo2 {

    @Test
    //第一代日期类
    public void test() throws ParseException {

        Date date1 = new Date();
        System.out.println(date1);
        Date date2 = new Date(98546215);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");
        String format = sdf.format(date1);
        System.out.println(sdf.format(date1));
        System.out.println(sdf.format(date2));
        String s = "2024年11月8日 14时35分59秒 星期二";
        Date parse = sdf.parse(s);
        System.out.println(sdf.format(parse));

    }

    //第二代日期类
    @Test
    public void test2() {
        //1.Calendar是一个抽象类，并且构造器是private
        //2.可以通过getInstance()来获取实例
        //3.提供大量的方法和字段提供给程序员
        //4.Calendar没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
        //5.如果我们需要按照24小时进制来获取时间，Calendar.HOUR==改成=>Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance();//创建日历类对象//比较简单，自由
        System.out.println("c=" + c);
        //2.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        //这里为什么要+1,因为Calendar返回月时候，是按照0开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calender没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) +
                " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<String>();
        list.add("李");
        list.add("建");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    //第三代日期类
    @Test
    public void test4() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = localDateTime.format(formatter);
        System.out.println(format);
        System.out.println("年=" + localDateTime.getYear());
        System.out.println("月=" + localDateTime.getMonth());
        System.out.println("月=" + localDateTime.getMonthValue());
        System.out.println("日=" + localDateTime.getDayOfMonth());
        System.out.println("时=" + localDateTime.getHour());
        System.out.println("分=" + localDateTime.getMinute());
        System.out.println("秒=" + localDateTime.getSecond());
    }

    @Test
    public void test5() {
        //1.通过静态方法now()获取表示当前时间戳的对象
        Instant now = Instant.now();
        System.out.println(now);
        //2.通过from可以把Instant转成Date
        Date date = Date.from(now);
        //3. 通过 date 的toInstant() 可以把 date 转成Instant 对象
        Instant instant = date.toInstant();
    }

}
