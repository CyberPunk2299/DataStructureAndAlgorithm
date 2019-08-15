package data_structure_and_algorithm.binarysearch;

/**
 * @description:
 * @author: MuQinglin
 * @time: 2019/8/12 21:15
 */
public class BinarySearchQ0 {


    //找到一个比key小的最大的数，返回索引
     int findMaxLessThanKey(int[] arr, int fromIndex, int toIndex, int key) {
        int start = fromIndex;
        int end = toIndex - 1;
        int maxIndex = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (arr[middle] >= key) {
                 end = middle - 1;
            } else {
                maxIndex = middle;
                start = middle + 1;
            }
        }
        return maxIndex;
    }

    //常规的二分查找（没有范围判断）
     int findMaxIndexCore(int[] arr, int p, int fromIndex, int toIndex) {
        int start = fromIndex;
        int end = toIndex - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            int temp = arr[middle];
            if (temp < p) {
                start = middle + 1;
            } else if (temp > p) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    final static double ZERO = 1e-6;
     /*
      * @Description:求方程的根
      * @param: null
      * @return:
      * @Author: MuQinglin
      * @Date: 15:05 2019/8/13
      * @Version: 1.0
      */

     double findRootOfEquation() {
        double start = 0;
        double end = 100;
        double middle = start + (end - start) / 2;

        double y = f(middle);

        while (Math.abs(y) > ZERO) {
            if (y > ZERO) {
                end = middle;
            } else if (y < ZERO) {
                start = middle;
            }
            middle = start + (end - start) / 2;
            y = f(middle);
        }
        return middle;
    }

    //定义 f 函数
     double f(double x) {
        return x*x*x - 5*x*x + 10*x - 80;
    }



    public static void main(String[] args) {
        int[] test = {0,1,2,3,4,5,6,7,8,9};
        BinarySearchQ0 binarySearchQ0 = new BinarySearchQ0();
        System.out.println(binarySearchQ0.findMaxIndexCore(test, 10, 0, test.length));
        System.out.println(binarySearchQ0.findMaxLessThanKey(test, 0, test.length, 5));
        System.out.println(binarySearchQ0.findRootOfEquation());

    }
}
