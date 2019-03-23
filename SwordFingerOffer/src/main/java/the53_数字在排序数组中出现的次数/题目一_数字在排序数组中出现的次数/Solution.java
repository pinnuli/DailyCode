package the53_数字在排序数组中出现的次数.题目一_数字在排序数组中出现的次数;

/**
 * 统计一个数字在排序数组中出现的次数。
 * author@ pinnuli
 * date@ 2019/3/23
 */
public class Solution {
    /**
     * 使用二分查找分别找到第一个k和最后一个k的位置
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int result = 0;
        if (array != null && array.length != 0) {
            int first = getFirstK(array, k, 0, array.length - 1);
            int last = getLastK(array, k, 0, array.length - 1);
            if (first > -1 && last > -1) {
                result = last - first + 1;
            }
        }
        return result;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleValue = array[middleIndex];
        if (middleValue == k) {
            if ((middleIndex > 0 && array[middleIndex - 1] != k)
                    || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (middleValue > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirstK(array, k, start, end);
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = (start + end) / 2;
        int middleValue = array[middleIndex];
        if (middleValue == k) {
            if ((middleIndex < array.length - 1 && array[middleIndex + 1] != k)
                    || middleIndex == array.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (middleValue > k) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(solution.GetNumberOfK(array, 3));
    }
}
