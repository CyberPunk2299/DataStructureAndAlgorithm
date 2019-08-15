package data_structure_and_algorithm.recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: MuQinglin
 * @time: 2019/8/12 16:13
 */
public class RecursionQ2 {

    static int iCount = 0;
    static int[] position = null;


    static void nQueen(int n, int m) {
        int i, j;
        int ct;
        if ( n == m) {
            System.out.println(Arrays.toString(position));
            return;
        }
        for (i = 1; i <= m; i++) {
            position[n] = i;
            ct = 1;
            for (j = 0; j < n; j++) {
                if (position[j] == position[n]) {
                    ct = 0;
                } else if (Math.abs(position[j] - position[n]) == (n - j)) {
                    ct = 0;
                }
            }
            if (ct == 1) {
                nQueen(n + 1, m);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入阶数N");
        int n = scanner.nextInt();
        position = new int[n];
        nQueen(0, n);
    }
}
