package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/5/4 12:57
 * @Description: 测试synchronized的作用
 */
public class Lock_4Test implements Runnable{
    private int count = 100;

    @Override
    public /*synchronized*/ void run() {
        count --;
        System.out.println(Thread.currentThread().getName() + " count =" + count);
    }

    public static void main(String[] args) {
        Lock_4Test t = new Lock_4Test();
        for (int i = 100 ; i > 0; i--) {
            new Thread(t,"thread-" + i ).start();
        }
    }
}
