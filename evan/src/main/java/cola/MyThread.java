package cola;

/**
 * 
 * @author shaofeijin
 *
 */
public class MyThread extends Thread {


    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            System.out.println("------>" + i);
        }

    }




    public static void main(String[] args) {

        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        m1.start();
        m2.start();


    }

}
