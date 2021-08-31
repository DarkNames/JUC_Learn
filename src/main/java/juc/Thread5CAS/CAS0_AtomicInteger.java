package juc.Thread5CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 20:54
 * @Description: 对比上一个程序，可以用synchronized解决，synchronized可以保证可见性和原子性，volatile只能保证可见性
 *
 */
public class CAS0_AtomicInteger {
//    /*volatile*/ int count = 0;

    AtomicInteger count = new AtomicInteger(0);

    void  method(){
        for (int i = 0; i < 10000; i++) {
//            synchronized (CAS0_AtomicInteger.class){
                count.incrementAndGet();
//            }
        }
    }

    public static void main(String[] args) {
        CAS0_AtomicInteger volatile4 = new CAS0_AtomicInteger();
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
