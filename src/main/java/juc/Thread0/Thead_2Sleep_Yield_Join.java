package juc.Thread0;

/**
 * @Auther: zhangyf
 * @Date: 2021/4/24 23:05
 * @Description:线程的常用方法
 */
public class Thead_2Sleep_Yield_Join {
    public static void main(String[] args) {
//        sleep();
//        yield();
        join();
    }

    static void sleep(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("sleep "+i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static void yield(){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("yield A" + i);
                if(i % 10 == 0)Thread.yield();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("yield B" + i);
                if(i % 10 == 0)Thread.yield();
            }
        }).start();
    }

    static void join(){
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("join A" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("join B" + i);
                try {
                    Thread.sleep(10);
                    if(i==50)t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

}
