package com.soft2116.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @description: 自定义注解：描述需要执行的类名和方法名
 * @author: mqxu
 * @date: 2022-02-20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
    String className();

    String methodName();
}
