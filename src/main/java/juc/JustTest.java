package juc;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/17 23:24
 * @Description:
 *
 * 0 new #2 <java/lang/Object>                  //创建一个对象
 * 3 dup                                        //申请内存
 * 4 invokespecial #1 <java/lang/Object.<init> : ()V>           //掉构造方法初始化
 * 7 astore_1                           //返回地址给 栈变量
 * 8 return
 */
public class JustTest {
    public static void main(String[] args) {
       Object o = new Object();
    }
}
