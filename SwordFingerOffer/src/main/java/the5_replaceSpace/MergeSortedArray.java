package the5_replaceSpace;

/**
 * 有两个排序数组A和B，内存在A的末尾有足够多的空余空间容纳B，实现一个函数，把B
 * 插入到A，并且是有序的。
 * @author: pinnuli
 * @date: 2019-01-13
 */

public class MergeSortedArray {

    public void mergerSortedArray(int[] arrA, int lengthOfArrA,  int[] arrB, int lengthOfArrB) {
        int lengthOfTotal = lengthOfArrA + lengthOfArrB;
        lengthOfArrA--;
        lengthOfArrB--;
        lengthOfTotal--;
        while (lengthOfArrA >= 0 && lengthOfArrB >= 0) {
            if (arrA[lengthOfArrA] >= arrB[lengthOfArrB]) {
                arrA[lengthOfTotal--] = arrA[lengthOfArrA--];
            } else {
                arrA[lengthOfTotal--] = arrB[lengthOfArrB--];
            }
        }
        while (lengthOfArrB >= 0) {
            arrA[lengthOfTotal--] = arrB[lengthOfArrB--];
        }
    }
}
