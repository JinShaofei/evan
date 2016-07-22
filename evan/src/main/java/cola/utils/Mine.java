package cola.utils;

/**
 * 
 * @author shaofeijin
 *
 */
public class Mine {

    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        Thread a = new Thread(mr, "a");
        a.start();
        Thread b = new Thread(mr, "b");
        b.start();
    }

}
