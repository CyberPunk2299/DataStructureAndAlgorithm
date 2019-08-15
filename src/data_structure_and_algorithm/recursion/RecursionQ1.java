package data_structure_and_algorithm.recursion;

import java.util.Scanner;

/**
 * @description:
 * @author: MuQinglin
 * @time: 2019/8/12 15:40
 */
public class RecursionQ1 {

    static long count;
    static void hanoi(int n, char a, char b, char c) {
        if (n == 1) {
            //A 到 C
            System.out.printf("第%d次移动:\t圆盘从%c棒移动到%c棒\n", ++count, a, c);
        } else {
            //A 到 B
            hanoi(n - 1, a, c, b);
            // A 到 C
            System.out.printf("第%d次移动:\t圆盘从%c棒移动到%c棒\n", ++count, a, c);
            //B 到 C
            hanoi(n - 1, b, a, c);
        }
    }
    static void baguenaudier(int n) {

    }

    public static void main(String[] args) {
        int n;
        count = 0;
        System.out.println("请输入n");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        hanoi(n,'A','B','C');
        System.out.println("一共需要" + count + "步数" );
    }
}
