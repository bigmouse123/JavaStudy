package com.jiankun.springboot.annotation;

import java.lang.annotation.*;

/**
 * @author OfferKing
 * @version 1.0
 * @date 2025/3/5 9:52
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String module() default "";

}
