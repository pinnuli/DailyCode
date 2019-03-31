package bigo;

/**
 * author@ pinnuli
 * date@ 2019/3/31
 */
public class UglyNumber {
    int getNth(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] uglys = new int[n];
        uglys[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = uglys[index2] * 2, next3 = uglys[index3] * 3, next5 = uglys[index5] * 5;
            uglys[i] = Math.min(next2, Math.min(next3, next5));
            if (uglys[i] == next2) {
                index2 ++;
            }
            if (uglys[i] == next3) {
                index3 ++;
            }
            if (uglys[i] == next5) {
                index5 ++;
            }
        }
        return uglys[n - 1];
    }
}
