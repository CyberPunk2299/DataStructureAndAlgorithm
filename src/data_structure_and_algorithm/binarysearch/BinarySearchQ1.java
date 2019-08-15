package data_structure_and_algorithm.binarysearch;

import java.util.Arrays;
import java.util.Random;

/**
 * @description:
 * @author: MuQinglin
 * @time: 2019/8/13 15:16
 */
public class BinarySearchQ1 {

    void findTwoWords(int[] arr, int key) {
        int length = arr.length;
        Arrays.sort(arr);

        int start = 0;
        int end = length - 1;
        while (start <= end) {
            int sum = arr[start]+arr[end];
            if (sum == key) {
                System.out.println("第一个数:" + arr[start] + ", 第二个数:" + arr[end]);
                return;
            } else if (sum > key) {
                end--;
            } else {
                start++;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000000);
        }
        BinarySearchQ1 q1 = new BinarySearchQ1();
        q1.findTwoWords(arr, 305312);
    }
}
