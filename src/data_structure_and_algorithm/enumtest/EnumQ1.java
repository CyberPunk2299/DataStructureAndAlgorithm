package data_structure_and_algorithm.enumtest;

import java.util.Scanner;

/**
 * @description:
 * @author: MuQinglin
 * @time: 2019/8/11 17:43
 */
public class EnumQ1 {
    final int DATE1 = 23;
    final int DATE2 = 28;
    final int DATE3 = 33;

    //完美立方
    public void pectfectCube(int n) {
        for (int a = 2; a <= n; a++) {
            for (int b = 2; b <= a - 1; b++) {
                for (int c = 2; c < b - 1; c++) {
                    for (int d = 2; d < c - 1; d++) {
                        if (a*a*a == b*b*b + c*c*c + d*d*d) {
                            System.out.println("a = " + a  + "; b,c,d 分别为：" + b +", " +  c + ", "  + d);
                        }
                    }
                }
            }
        }
    }

    //生理周期
    public void physiologicalCycle() {
        Scanner scanner = new Scanner(System.in);
        int p, e, i, d;

        int ncase = 0;
        while (scanner.hasNext()) {
            p = scanner.nextInt();
            e = scanner.nextInt();
            i = scanner.nextInt();
            d = scanner.nextInt();
            ncase++;
            int k = d + 1;

            //得到第一个 k
            for (; (k - p) % DATE1 != 0; k++) {};
            for (; (k - e) % DATE2 != 0; k += DATE1) {};
            for (; (k - i) % DATE3 != 0; k += DATE1*DATE2){};
            int m = k - d;
            System.out.println("第" +ncase + "个实例间隔:" + m + "天");
        }

    }

    public static void main(String[] args) {
        EnumQ1 fundamentalsOfAlgorithmics = new EnumQ1();
        //完美立方
        fundamentalsOfAlgorithmics.pectfectCube(100);
        //生理周期
        fundamentalsOfAlgorithmics.physiologicalCycle();
    }
}
