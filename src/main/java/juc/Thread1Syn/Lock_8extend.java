package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/6/26 15:57
 * @Description: 一个同步方法可以掉另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候依然会得到改对象的锁，
 *  也就是锁synchronized获得的锁是可重入的
 *  这里是继承中有可能发生的情形，子类调用父类的同步方法。
 */
public class Lock_8extend {
    synchronized void m(){
        System.out.println("m");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new Child().m();
    }

    public static class Child extends Lock_8extend {
        @Override
        synchronized void m() {
            System.out.println("child start");
            super.m();
            System.out.println("child end");
        }
    }
}

