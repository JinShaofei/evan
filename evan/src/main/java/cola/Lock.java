package cola;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author shaofeijin
 *
 */
public class Lock {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
            Thread.currentThread().sleep(1000 * 3);
        }
        System.out.println(list);
    }

}
