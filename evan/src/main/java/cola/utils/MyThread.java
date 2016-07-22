package cola.utils;

/**
 * 
 * @author shaofeijin
 *
 */
public class MyThread extends Thread {

    private int count = 7;
    private String name;

    public MyThread(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 7; i++) {
            System.out.println(name + "执行结果：" + count--);
            // try {
            // Thread.sleep(1000 * 3);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
        }

    }

    public static void main(String[] args) {
        MyThread mTh1 = new MyThread("A");
        MyThread mTh2 = new MyThread("B");
        mTh1.start();
        mTh2.start();
    }


}

