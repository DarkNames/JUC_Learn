package juc.Thread0;

/**
 * @Auther: zhangyf
 * @Date: 2021/4/24 22:42
 * @Description:常见创建线程的3重方式
 * 方式1：通过继承Thead方式创建
 * 方式2：实现runnable接口创建
 * 方式3：java8后新增lambda方式创建
 * 提问：方式1与方式2哪种更好，
 * 答：方式2，因为java事单继承多实现，如果继承了就不能再继续基础其他类；但是可以实现多个接口。
 */
public class Thead_1CreateThead {
    static class ExtendThread extends Thread{
        @Override
        public void run() {
            System.out.println("extend to create thead");
        }
    }
    static class ImplRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("impl runnable to create thread");
        }
    }
    public static void main(String[] args) {
        new ExtendThread().start();
        /** 方式2启动的时候需要先new Thead()再把实现类交予Thead进行start*/
        new Thread(new ImplRunnable()).start();
        new Thread(()->{
            System.out.println("lambda to create Thead");
        }).start();
    }
}
