package the21_调整数组顺序使奇数位于偶数前面;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: pinnuli
 * @date: 2019-02-23
 */

public class Solution {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分.
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array == null) {
            return;
        }

        int preIndex = 0;
        int postIndex = array.length - 1;

        while (preIndex < postIndex) {
            while (preIndex < postIndex && !isEven(array[preIndex])) {
                preIndex ++;
            }
            while (preIndex < postIndex && isEven(array[postIndex])) {
                postIndex --;
            }

            if (preIndex < postIndex) {
                int temp = array[preIndex];
                array[preIndex] = array[postIndex];
                array[postIndex] = temp;
            }
        }
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    /**
     * 利用插排思想，时间复杂度为O(n^2)
     * @param array
     */
    public void reOrderArray2(int[] array) {
        if (array == null) {
            return;
        }

        boolean change = true;
        for (int i = 0; i < array.length && change; i++) {
            if (isEven(array[i])) {
                change = false;
                for (int j = i + 1; j < array.length; j++) {
                    if (!isEven(array[j])) {
                        change = true;
                        int temp = array[j];
                        while (j > i) {
                            array[j] = array[j - 1];
                            j--;
                        }
                        array[i] = temp;
                        break;
                    }
                }
            }
        }
    }

    /**
     * 新建一个数组，先将奇数放入，再将偶数放入，时间复杂度为O(n)，空间复杂度为S(n)
     * @param array
     */
    public void reOrderArray3(int[] array) {
        if (array == null) {
            return;
        }

        int[] tempArray = new int[array.length];
        int tempIndex = 0;
        for (int anArray1 : array) {
            if (!isEven(anArray1)) {
                tempArray[tempIndex] = anArray1;
                tempIndex++;
            }
        }

        for (int anArray : array) {
            if (isEven(anArray)) {
                tempArray[tempIndex] = anArray;
                tempIndex++;
            }
        }

        System.arraycopy(tempArray, 0, array, 0, array.length);

    }

    private boolean isEven(int number) {
        return (number & 1) == 0;
    }
}
