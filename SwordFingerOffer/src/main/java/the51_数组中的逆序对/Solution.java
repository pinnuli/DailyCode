package the51_数组中的逆序对;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author: pinnuli
 * @date: 2019-03-22
 */

public class Solution {
    private long count = 0;
    private int[] arrayBak;

    /**
     *
     */
    public int InversePairs(int [] array) {
        arrayBak = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int)(count % 1000000007);
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private void merge(int[] array, int low, int mid, int high) {
        int i = low, k = low, j = mid + 1;
        while(i <= mid || j <= high) {
            if (i > mid) {
                arrayBak[k] = array[j++];
            } else if (j > high) {
                arrayBak[k] = array[i++];
            } else if (array[i] <= array[j]) {
                arrayBak[k] = array[i++];
            } else {
                this.count += mid - i + 1;
                arrayBak[k] = array[j++];
            }
            k++;
        }
        for (k = low; k <= high; k++) {
            array[k] = arrayBak[k];
        }
    }


}
