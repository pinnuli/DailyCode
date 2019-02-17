package the14_剪绳子;

/**
 * @author: pinnuli
 * @date: 2019-02-17
 */

public class Solution {

    public int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }

        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                max = Math.max(max, product);
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }

    public int maxProductAfterCutting2(int length) {
        if (length < 2) {
            return 0;
        }

        if (length == 2) {
            return 1;
        }

        if (length == 3) {
            return 2;
        }

        int timesOf3 = length / 3;

        if (length % 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
    }


}
