package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/6/26 15:48
 * @Description: synchronized 的可重入性，当同一把锁，可以进入改锁对象锁住的其他方法；
 * 如果不具备可重入性则会出现死锁现象。
 * 为什么必须可重入，例如；有一个类的方法是synchronized，这个方法是重写父类的方法，如果这时候调用super.method;
 * 不可重入就出现死锁现象。
 *
 * 总结：一个同步方法可以掉另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候依然会得到改对象的锁，
 * 也就是锁synchronized获得的锁是可重入的
 */
public class Lock_7AgainRun {

    public synchronized void m1(){
        System.out.println("m1");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }

    public synchronized void m2(){
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        Lock_7AgainRun againRun = new Lock_7AgainRun();
        new Thread(()->againRun.m1()).start();
    }
}
