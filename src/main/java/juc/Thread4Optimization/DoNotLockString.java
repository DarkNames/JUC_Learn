package juc.Thread4Optimization;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 23:00
 * @Description:
 *  不要以字符串常量作为锁对象，在下面例子中m1，m2其实锁的是同一个对象；
 *  这种情况还会发生比较诡异的现象，比如你用到了一个类库，在该类库中代码锁定了字符串“hello”
 *  但是你读不到源码，所以你自己也在代码中锁定了“hello”，这个时候有可能发生非常诡异的死锁阻塞
 *  因为你程序和你用到的类库不经意间用到了同一把锁
 */
public class DoNotLockString {
    String s1 = "hello";
    String s2 = "hello";

    void m1(){
        synchronized (s1){

        }
    }

    void m2(){
        synchronized (s2){

        }
    }

}
