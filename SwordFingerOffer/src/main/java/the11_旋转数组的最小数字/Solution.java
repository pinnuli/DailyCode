package the11_旋转数组的最小数字;

/**
 * @author: pinnuli
 * @date: 2019-02-07
 */

public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;
            if (array[index1] == array[index2]
                    && array[indexMid] == array[index1] ) {
                return minInOrder (array, index1, index2);
            }
            if (array[indexMid] >= array[index1]) {
                index1 = indexMid;
            }
            if (array[indexMid] <= array[index2]) {
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }

    public int minInOrder(int[] array, int index1, int index2) {
        int result = array[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }

}
