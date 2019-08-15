package data_structure_and_algorithm.enumtest;

import java.util.Scanner;

/**
 * @description:
 * @author: MuQinglin
 * @time: 2019/8/11 20:53
 */
public class EnumQ3 {
    char[][] left = new char[3][7];
    private static String[][] myString = new String[3][3];


    static boolean isFake(String[][] left, String c, boolean light) {

        for (int i = 0; i < 3; i++) {
            String pleft = null;
            String pright = null;
            if (light == true) {
                pleft = left[i][0];
                pright = left[i][1];
            } else {
                pleft = left[i][1];
                pright = left[i][0];
            }
            switch (left[i][2]) {
                case "up" :
                    if (pright.contains(c) == false) {
                        return false;
                    }
                    break;
                case "even":
                    if (pright.contains(c) == true || pleft.contains(c) == true) {
                        return false;
                    }
                    break;
                case "down":
                    if (pleft.contains(c) == false) {
                        return false;
                    }
                    break;
                default:
            }
        }
        return true;

    }


    public static void main(String[] args) {
        //ABCD EFGH even
        //ABCI EFJK up
        //ABIJ EFGH even
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要测试的次数");
        int n = sc.nextInt();
        while (n-- > 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println("请输入第" + i + "行，第" + j + "列:" );
                    myString[i][j] = sc.next();
                }
            }
            for (char c = 'A'; c <= 'L'; c++) {
                String s = String.valueOf(c);
                if (isFake(myString, s, true)) {
                    System.out.println(s + " is the fake and it is light");
                    break;
                } else if (isFake(myString, s, false)) {
                    System.out.println(s + " is the fake and it is weight");
                    break;
                }
            }
        }
    }
}
