package cola.utils;

/**
 * 
 * @author shaofeijin
 *
 */
public class Mine {

    public static void main(String[] args) {

        // 插入排序
        int[] ints = { 11, 23, 21, 45, 67, 82, 56 };
        int temp = 0;
        for (int i = 1; i < ints.length; i++) {
            int j = i - 1;
            temp = ints[i]; // 11
            // ints[j] 19
            for (; j >= 0 && temp < ints[j]; j--) {
                ints[j + 1] = ints[j];
            }
            ints[j + 1] = temp;
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
