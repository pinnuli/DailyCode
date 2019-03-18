package the39_数组中出现次数超过一半的数字;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * author@ pinnuli
 * date@ 2019/3/11
 */
public class Solution {
    /**
     * 使用基于快排的思想，时间复杂度为O(n)
     * @param array
     * @return
     */
    public int moreThanHalfNumLikeQuickSort(int [] array) {
        if (!checkValidArray(array)) {
            return 0;
        }

        int middle = array.length >> 1;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        while (middle != index) {
            if(index < middle) {
                index = partition(array, index + 1, end);
            } else {
                index = partition(array, start, index - 1);
            }
        }

        if (!checkMoreThanHalf(array, array[middle])) {
            return 0;
        }
        return array[middle];
    }

    /**
     * 时间复杂度为O(n)
     * @param array
     * @return
     */
    public int moreThanHalfNum(int[] array) {
        if (!checkValidArray(array)) {
            return 0;
        }

        int number = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                number = array[i];
                times ++;
            } else if (number == array[i]) {
                times ++;
            } else {
                times --;
            }
        }

        if (!checkMoreThanHalf(array, number)) {
            return 0;
        }
        return number;
    }
    private boolean checkValidArray(int[] array) {
        if (array == null || array.length <=0){
            return false;
        }
        return true;
    }

    private boolean checkMoreThanHalf(int[] array, int number) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                count ++;
            }
        }
        return count > (array.length >> 1);
    }
    private int partition(int[] array, int low, int high) {
        int key = array[low];
        while(low < high) {
            while (low < high && array[high] >= key) {
                high--;
            }
            array[low] = array[high];
            while (low < high && array[low] <= key) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = key;
        return low;
    }

}
