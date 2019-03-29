package the66_构建乘法数组;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 * author@ pinnuli
 * date@ 2019/3/29
 */
public class Solution {
    /**
     * 将A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]看成两部分:
     * A[0]*A[1]*...*A[i-1] 和 A[i+1]*...*A[n-1]，
     * 先从左往右乘，再从右往左乘
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int length = A.length;
        int[] result = new int[length];
        for (int i = 0, product = 1; i < length; product *= A[i], i++){
            result[i] = product;
        }
        for (int i = length - 1, product = 1; i >= 0; product *= A[i], i--) {
            result[i] *= product;
        }
        return result;
    }

    public static void main(String[] args) {
        multiply(new int[]{120,60,40,30,24});
    }
}
