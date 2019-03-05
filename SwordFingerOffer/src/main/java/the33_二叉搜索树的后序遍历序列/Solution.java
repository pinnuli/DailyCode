package the33_二叉搜索树的后序遍历序列;

/**
 * author@ pinnuli
 * date@ 2019/3/1
 */
public class Solution {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    public boolean verify(int[] sequence, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        int root = sequence[end];
        int currentIndex = start;
        while (currentIndex < end && sequence[currentIndex] < root) {
            currentIndex ++;
        }

        for (int j = currentIndex; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        return verify(sequence, start, currentIndex - 1) && verify(sequence, currentIndex, end - 1);
    }
}
