package juc.Thread4Optimization;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 22:51
 * @Description: synchronized
 *  1、synchronized同步代码块中的语句越少越好； //降低锁的粒度
 *  2、当一个方法中synchronized代码块过多，则可以对整个方法加锁；  //增加锁的粒度，减少对锁资源的争抢
 */
public class FineCoarseLock {
    int count = 0;

    synchronized void m1(){

        // do sth need to syn
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;

        // do sth need to syn
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    void m2(){

        // do sth need to syn
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        //采用细粒度的锁，可以使线程争抢时间变短，提高效率
        synchronized (this) {
            count++;
        }

        // do sth need to syn
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
