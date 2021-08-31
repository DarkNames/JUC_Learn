package juc.Thread0;

/**
 * @Auther: zhangyf
 * @Date: 2021/4/26 23:55
 * @Description: 线程状态
 */
public class Thead_3Status {
    static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getState());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        System.out.println(t.getState());
        t.start();

        try {
            t.join();
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getState());

    }
}
