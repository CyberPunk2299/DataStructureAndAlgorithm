package data_structure_and_algorithm.dp;

import java.util.Scanner;

 /*
  * @Description: 数字三角形的最长路径
  * @param: null
  * @return:
  * @Author: MuQinglin
  * @Date: 16:00 2019/8/14
  * @Version: 1.0
  */

 class NumebrsTriangle {
    final static int MAX = 101;
    int[][] dataArray = null;
    int[][] maxSum = null;
    int[] maxSumPro = null;
    int row = -1;
    int n = 0;

    //带数据的构造函数
    public NumebrsTriangle(int value){
        this.n = value;
        this.maxSum = new int[value][value];
        this.dataArray = new int[value][value];
        row = value;
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++) {
                maxSum[i][j] = -1;
            }
        }
    }
    public NumebrsTriangle() {

    }

    //记忆递归型
    int getMaxSumByMemory(int i, int j) {

        if (maxSum[i][j] != -1) {
            return maxSum[i][j];
        }
        if (i == n - 1) {
            maxSum[i][j] = dataArray[i][j];
        } else {
            int leftMax = getMaxSumByMemory(i + 1, j);
            int rightMax = getMaxSumByMemory(i + 1, j + 1);
            maxSum[i][j] = Math.max(leftMax, rightMax) + dataArray[i][j];
        }
        return maxSum[i][j];
    }


    public static void main(String[] args) {
        //测试 递归型
//        int i, j;
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        DpQ1 dpQ1 = new DpQ1(n);
//        for(i = 0; i < n; i++){
//            for (j = 0; j <= i ; j++) {
//                dpQ1.dataArray[i][j] = scanner.nextInt();
//            }
//        }
//        System.out.println(dpQ1.getMaxSumByMemory(0, 0));



        //改 递推型
        int i, j;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        NumebrsTriangle numebrsTriangle = new NumebrsTriangle(n);

        for (i = 0; i < n; i++) {
            for (j = 0; j <= i; j++) {
                numebrsTriangle.dataArray[i][j] = scanner.nextInt();
            }
//            System.out.println((i+1) + "行: " + Arrays.toString(dpQ1.dataArray[i]));
        }
        for (i = 0; i < n; i++) {
            numebrsTriangle.maxSum[n - 1][i] = numebrsTriangle.dataArray[n - 1][i];
        }

        for (i = n - 2;i >= 0; i--) {
            for (j = 0; j <= i; j++) {
                numebrsTriangle.maxSum[i][j] = Math.max(numebrsTriangle.maxSum[i+1][j], numebrsTriangle.maxSum[i+1][j+1]) + numebrsTriangle.dataArray[i][j];
            }
        }
        System.out.println(numebrsTriangle.maxSum[0][0]);
    }
}

