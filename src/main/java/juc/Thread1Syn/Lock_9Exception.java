package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/6/26 16:12
 * @Description: 程序执行过程中，如果出现一场默认情况会释放锁。
 * 所以在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况。
 * 比如：在一个web app处理过程中，多个servlet线程同时访问同一个资源，这时如果异常处理不合适；
 * 第一个线程抛出异常，其他线程会进入同步代码区，有可能访问到异常产生是的数据；
 * 因此要非常小心处理同步业务逻辑中的异常。
 *
 * thread 1 count = 5
 * thread 2start
 * thread 2 count = 6
 */
public class Lock_9Exception {
    int count = 0;

    synchronized void method() {
        System.out.println(Thread.currentThread().getName() + "start");
        while (true) {
            count++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 1 / 0;
                System.out.println(1);
            }
        }
    }

    public static void main(String[] args) {
        Lock_9Exception lockException = new Lock_9Exception();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                lockException.method();
            }
        };
        new Thread(r, "thread 1").start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "thread 2").start();
    }
}
