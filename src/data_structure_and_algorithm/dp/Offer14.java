package data_structure_and_algorithm.dp;

/**
 * @description: 割绳子，让割完后的绳子的长度乘积最大。
 * @author: MuQinglin
 * @time: 2019/8/14 18:09
 */
public class Offer14 {

    final int UPPER = 4;
    public int getMaxMultiplyLength(int length) {
        if (length <= 1) {
            return 0;
        }else if (length == 2) {
            return 1;
        } else if (length == 3) {
            return 2;
        }

        int max;
        int[] tempArray = new int[length + 1];
        for (int i = 0; i < UPPER; i++) {
            tempArray[i] = i;
        }

        for (int i = UPPER; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int tempSum = tempArray[j] * tempArray[i-j];
                if (max < tempSum) {
                    max = tempSum;
                }
                tempArray[i] = max;
            }
        }
        max = tempArray[length];
        return max;
    }

    public static void main(String[] args) {
        Offer14 offer14 = new Offer14();
        System.out.println(offer14.getMaxMultiplyLength(8));
    }
}
