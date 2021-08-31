package juc.Thread2Volatile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 20:54
 * @Description: 对比上一个程序，可以用synchronized解决，synchronized可以保证可见性和原子性，volatile只能保证可见性
 *
 */
public class Volatile5Test {
    /*volatile*/ int count = 0;
    void  method(){
        for (int i = 0; i < 10000; i++) {
            synchronized (Volatile5Test.class){
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Volatile5Test volatile4 = new Volatile5Test();
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
