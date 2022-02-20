package com.soft2116.junit;

    /**
     * @description: 计算器类
     * @author: mqxu
     * @date: 2022-02-18
     **/
    public class Calculator{
        /**
         * 加法
         * @param a 整数
         * @param b 整数
         * @return 两数之和
         */
        public int add(int a,int b){
            // 故意的bug
            return a-b;
        }
        /**
         * @param a 整数
         * @param b 整数
         * @return 两数之差
         */
        public int sub(int a ,int b ){
            return a-b;
        }
    }

