package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/5/10 23:22
 * @Description: 同步方法和非同步方法是否可以同时运行
 * 结论：必须可以,相互不影响
 */
public class Lock_5Test {

    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName() + " m1 start ......");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end ......");
    }

    public  void method2(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 start ......");
    }


    public static void main(String[] args) {
        final Lock_5Test lock = new Lock_5Test();
//        new Thread(()->lock.method1(),"method1").start();
//        new Thread(()->lock.method2(),"method2").start();

//        new Thread(lock::method1,"method1").start();
//        new Thread(lock::method2,"method2").start();

        /**
         * jdk1.8之前的写法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.method1();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.method2();
            }
        }).start();
    }

}
