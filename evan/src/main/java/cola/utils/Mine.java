package cola.utils;

/**
 * 
 * @author shaofeijin
 *
 */
public class Mine {

    public static void main(String[] args) {

        // 插入排序
        int[] ints = { 31, 13, 11, 7 };
        int temp = 0;
        for (int i = 1; i < ints.length; i++) {
            int j = i - 1;
            temp = ints[i]; // 11
            // ints[j] 19
            for (; j >= 0 && temp < ints[j]; j--) {
                ints[i] = ints[j];
            }
            ints[j + 1] = temp;
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
