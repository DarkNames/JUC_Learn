package juc.Thread0;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhangyf
 * @Date: 2021/4/23 00:00
 * @Description: 线程的创建方法与运行方式差别：
 * 1、通过继承Thread类，并重写run方法继承
 * 2、通过new thread.run运行方式会跟主线程串行方式执行。
 * 3、通过new thread.start运方式会跟主线程并行运行方式执行。
 */
public class Thead_0WhatIsThead {

    private static class T1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    public static void main(String[] args) {
//        new T1().run();
        new T1().start();
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
