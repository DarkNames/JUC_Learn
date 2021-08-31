package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/5/4 00:13
 * @Description: 对某个对象加锁
 */
public class Lock_0Object {
    private  int count = 10;
//    private Object o = new Object();
    private Object o = null;
    public void method(){
        synchronized (o){   //任何线程要执行下面的代码，必须拿到o的锁。
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public static void main(String[] args) {
        Lock_0Object lock_0Object = new Lock_0Object();
        lock_0Object.method();
    }
}
