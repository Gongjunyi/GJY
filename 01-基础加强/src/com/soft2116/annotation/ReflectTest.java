package com.soft2116.annotation;
/**
 * @description: 注解测试类
 * @author: mqxu
 * @date: 2022-02-20
 */
import java.lang.reflect.Method;

@Pro(className = "com.soft2116.annotation.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //1.获取该类的字节码文件对象
        Class<?> reflectTestClass = ReflectTest.class;
        //2.获取该类上方的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        //public class ProImpl implements Pro{
        //public String className(){
        //return "com .soft2116.annotation.Demo1" ;
        // }
        //public String methodName(){
        //return "show" ;
        //}
        //}
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法,获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className + ", " + methodName);
        //4.加载该类进内存
        Class<?> cls = Class.forName(className);
        //5.通过构造方法创建对象
        Object obj = cls.getConstructor().newInstance();
        //6.获取方法对象
        Method method = cls.getMethod(methodName);
        //7.获取方法对象
        method.invoke(obj);
    }
}
