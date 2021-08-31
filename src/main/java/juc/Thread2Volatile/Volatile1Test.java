package juc.Thread2Volatile;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/15 00:46
 * @Description: volatile 测试类，比较有volatile跟没有volatile的情况
 * 添加了volatile：程序能正常执行并结束
 * 没有volatile：程序不能正常结束，会在while死循环中
 */
public class Volatile1Test {
    /*volatile*/ boolean flag = true;
    void method(){
        System.out.println(" m start");
        while (flag){
        }
        System.out.println(" m end");
    }
    public static void main(String[] args) {
        Volatile1Test v1 = new Volatile1Test();
        new Thread(v1::method,"t1").start();
        //lambda表达式 new Thread(new Runnable( run() {m()}
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v1.flag = false;
    }
}
