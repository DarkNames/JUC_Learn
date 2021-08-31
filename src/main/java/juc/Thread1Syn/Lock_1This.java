package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/5/4 00:25
 * @Description:
 */
public class Lock_1This {
    private  int count = 10;
    public void method(){
        synchronized (this){   //任何线程要执行下面的代码，必须先拿到this的锁。
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}
