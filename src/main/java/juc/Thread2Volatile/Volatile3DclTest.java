package juc.Thread2Volatile;

/**
 * @Auther: zhangyf
 * @Date: 2021/7/29 20:28
 * @Description:
 */
public class Volatile3DclTest {
    private static volatile Volatile3DclTest INSTANCE;
    private void Volatile3DclTest(){};

    public static Volatile3DclTest getInstance(){
        if(null == INSTANCE){
            synchronized (Volatile2Dcl.class){
                if(null == INSTANCE){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Volatile3DclTest();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Volatile3DclTest.getInstance().hashCode());
            }).start();
        }
    }
}
