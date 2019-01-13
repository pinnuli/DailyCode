package the5_replaceSpace;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortedArrayTest {
    @Test
    public void mergerSortedArray() throws Exception {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        int[] arrA = new int[10];
        arrA[0] = -12;
        arrA[1] = 32;
        arrA[2] = 49;
        arrA[3] = 63;
        arrA[4] = 90;
        int[] arrB = {-7, -1, 56, 89};
        mergeSortedArray.mergerSortedArray(arrA, 5, arrB, 4);
        for (int i = 0; i < 5 + 4; i++) {
            System.out.print(arrA[i] + " ");
        }
    }

}