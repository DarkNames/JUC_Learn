package juc.Thread4Optimization;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 23:04
 * @Description:
 * 锁定某个对象o，如果o的属性发生改变，不影响锁的使用
 * 但是如果o变成另一个对象，则对象的对象发生改变
 * 应该避免将锁对象的引用变成另外的对象
 */
public class SyncSameObject {

    Object o = new Object();

    void m(){
        synchronized (o){
            while (true){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        SyncSameObject thread = new SyncSameObject();

        //启动第一个线程
        new Thread(thread::m,"t1").start();

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建第二个线程
        Thread t2 = new Thread(thread::m, "t2");
        thread.o = new Object(); //锁对象发生改变，所以t2线程得以执行；如果注释掉这句话线程2将永远得不到执行机会
        t2.start();

    }

}
