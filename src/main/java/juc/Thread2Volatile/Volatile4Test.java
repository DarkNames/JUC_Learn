package juc.Thread2Volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 20:54
 * @Description: Volatile并不能保证多个线程同时修改Running变量所带来的不一致性问题，也就是说Volatile不能替代Synchronized
 * 运行下边的结果；并分析结果:得到的结果是：count不会等于100,000
 */
public class Volatile4Test {
    volatile int count = 0;
    void  method(){
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        Volatile4Test volatile4 = new Volatile4Test();
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(volatile4::method,"Thead-" + i));
        }

        threadList.forEach((thread)-> thread.start());
        threadList.forEach((thread)->{
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(volatile4.count);
    }

}
