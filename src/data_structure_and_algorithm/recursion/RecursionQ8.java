package data_structure_and_algorithm.recursion;

/**
 * @description: 求24点
 * @author: MuQinglin
 * @time: 2019/8/12 19:15
 */
public class RecursionQ8 {


    static boolean count24(double[] a, int n) {

        //先写临界条件
        if (n == 1) {
            if (a[0] == 24) {
                return true;
            } else {
                return false;
            }
        }

        double[] temp = new double[4];

        for (int i = 0; i < n - 1; i++) {
            //定位到每两个数的组合
            for (int j = i + 1; j < n; j++) {
                int m = 0;
                //遍历剩余的数，放入临时数组
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        temp[m++] = a[k];
                    }
                }
                temp[m] = a[i] + a[j];

                // m + 1 值为 n - 1
                if (count24(temp, m + 1)) {
                    return true;
                }

                temp[m] = a[i] - a[j];
                // m + 1 值为 n - 1
                if (count24(temp, m + 1)) {
                    return true;
                }

                temp[m] = a[j] - a[j];
                // m + 1 值为 n - 1
                if (count24(temp, m + 1)) {
                    return true;
                }

                temp[m] = a[i] * a[j];
                // m + 1 值为 n - 1
                if (count24(temp, m + 1)) {
                    return true;
                }

                if (a[i] != 0) {
                    temp[m] = a[j] / a[i];
                    // m + 1 值为 n - 1
                    if (count24(temp, m + 1)) {
                        return true;
                    }
                }

                if (a[j] != 0) {
                    temp[m] = a[i] / a[j];
                    // m + 1 值为 n - 1
                    if (count24(temp, m + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }



    public static void main(String[] args) {
        double[] arr1 = {1,1,4,2};
        double[] arr2 = {5,5,5,1};
        System.out.println(count24(arr1, 4));
        System.out.println(count24(arr2, 4));
    }
}
