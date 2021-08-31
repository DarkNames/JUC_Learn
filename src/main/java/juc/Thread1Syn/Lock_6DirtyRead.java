package juc.Thread1Syn;

/**
 * @Auther: zhangyf
 * @Date: 2021/6/26 15:37
 * @Description: 面试题：模拟银行账户，对业务写方法加锁，对业务读方法不加锁，这样行不行？
 * 结论：不行，因为当写方法尚未执行完毕，就执行读方法的时候会出现脏读的情况；
 * 例如；设置了100的金额，第一次读到0；第二次读到100
 */
public class Lock_6DirtyRead {
    private String userName;
    private double balance;

    private synchronized void set(String userName, double balance) {
        this.userName = userName;
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /*synchronized */ double getBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Lock_6DirtyRead dirtyRead = new Lock_6DirtyRead();
        new Thread(() -> dirtyRead.set("zhangsan", 100.0)).start();

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(dirtyRead.getBalance());
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(dirtyRead.getBalance());
    }
}
