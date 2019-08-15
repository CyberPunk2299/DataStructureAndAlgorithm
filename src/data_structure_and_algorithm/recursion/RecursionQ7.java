package data_structure_and_algorithm.recursion;

/**
 * @description: 放苹果
 * @author: MuQinglin
 * @time: 2019/8/12 18:50
 */
public class RecursionQ7 {
    static void putApples() {

    }
    /*
     * @Description:
     * @param: m 苹果数
     * @param: n 盘子数
     * @return: int
     * @Author: MuQinglin
     * @Date: 19:02 2019/8/12
     * @Version: 1.0
     */
    static int putApples(int m, int n) {
        if (m < n) {
            return putApples(m, m);
        }

        if (m == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        //盘子不空的情况 + 盘子空 1 个的情况
        return putApples(m - n, n) + putApples(m, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(putApples(2, 2));
    }
}
