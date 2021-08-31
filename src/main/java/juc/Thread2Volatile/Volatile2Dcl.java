package juc.Thread2Volatile;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 20:24
 * @Description:
 */
public class Volatile2Dcl {
    private static volatile Volatile2Dcl INSTANCE;
    private void Volatile2Dcl(){};

    public static Volatile2Dcl getInstance(){
        if(null == INSTANCE){
            synchronized (Volatile2Dcl.class){
                if(null == INSTANCE){
                    INSTANCE = new Volatile2Dcl();
                }
            }
        }
        return INSTANCE;
    }
}
