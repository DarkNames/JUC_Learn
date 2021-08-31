package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/5/4 00:25
 * @Description: 静态方法是没有this对象，当synchronized修饰static方法的时候，这里的this就是当前对象的Class对象。
 */
public class Lock_3Static {
    private static int count = 10;
    public synchronized static void method(){ //这里等同与synchronized(Lock_3Static.class)
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void method2(){ //考虑一下这里写synchronized(this)是否可以？ 不可以,提示this必须在非static方法上
        synchronized (Lock_3Static.class){
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
