package data_structure_and_algorithm.dp;

import java.util.Scanner;

/**
 * @description: 求输入数组的最长升序子序列
 * @author: MuQinglin
 * @time: 2019/8/15 16:03
 */
 class LongestAscendingSubSequence {
    public int[] maxLen = null;
    public int[] dataArray = null;

    //有参构造
    public LongestAscendingSubSequence(int n) {
        this.maxLen = new int[n];
        for (int i = 0; i < maxLen.length; i++) {
            maxLen[i] = 1;
        }
        this.dataArray = new int[n];
    }

    //核心方法
    public int getLongestAscendingSubSequenceCore(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    maxLen[i] = Math.max(maxLen[j] + 1, maxLen[i]);
                }
            }
        }
        return maxLen[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字个数");
        int n = sc.nextInt();
        LongestAscendingSubSequence gl = new LongestAscendingSubSequence(n);
        System.out.println("请输入数组");
        for (int i = 0; i < n; i++) {
            gl.dataArray[i] = sc.nextInt();
        }

        System.out.println(gl.getLongestAscendingSubSequenceCore(gl.dataArray, n));
    }
 }
