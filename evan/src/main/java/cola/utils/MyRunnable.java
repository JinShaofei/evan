package cola.utils;

public class MyRunnable implements Runnable {

    private int count = 7;


    @Override
    public void run() {
        for (int i = 0; i <= 7; i++) {
            System.out.println(Thread.currentThread().getName() + "执行结果：" + count--);
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
        MyRunnable mr = new MyRunnable();
        Thread mTh1 = new Thread(mr, "A");
        Thread mTh2 = new Thread(mr, "B");
        mTh1.start();
        mTh2.start();
        try {
            mTh1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            mTh2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "主线程运行结束!");
    }


}
