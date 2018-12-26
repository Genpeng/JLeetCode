package util;

/**
 * Some useful functions about the console output.
 *
 * @author  Genpeng Xu (xgp1227@gmail.com)
 * @date    2018/12/25
 */
public class PrintUtil {
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; ++i) {
            if (i <= arr.length - 2) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
    }
}
