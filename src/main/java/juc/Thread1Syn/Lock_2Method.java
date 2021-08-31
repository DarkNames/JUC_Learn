package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/5/4 00:25
 * @Description:
 */
public class Lock_2Method {
    private  int count = 10;
    public synchronized void method(){ //等同于在方法执行的时候要synchronized (this)
            count --;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
