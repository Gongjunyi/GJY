package com.soft2116.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 测试框架类
 * 当主方法执行后，会自动检测所有加了Check注解的方法，判断方法是否有异常，并记录到外部文件中
 * @author: mqxu
 * @date: 2022-02-20
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //1.创建计算器对象
        Calculator c = new Calculator();
        //2.获取字节码文件对象
        Class<?> cls = c.getClass();
        //3.获取所有方法
        Method[] methods = cls.getMethods();
        // 出现异常的次数
        int number = 0;
        // 创建缓冲字符流，将bug记录到外部文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods){
            //4.判断方法上是否有Check注解
            if(method.isAnnotationPresent(Check.class)){
                //5.有Check注解就执行该方法
                try {
                    method.invoke(c);
                }catch (Exception e){
                    //6.捕获异常并记录到文件中
                    number++;
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("----------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现"+number+"次异常");
        bw.flush();
        bw.close();
    }
}
