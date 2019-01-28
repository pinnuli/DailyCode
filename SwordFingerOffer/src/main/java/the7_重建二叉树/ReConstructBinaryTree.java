package the7_重建二叉树;

/**
 * @author: pinnuli
 * @date: 2018-12-09
 */

public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in){
        return ConstructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode ConstructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (pre[startPre] == in[i]) {
                root.left = ConstructCore(pre, startPre + 1, startPre + i - startIn, in, startIn, i -1);
                root.right = ConstructCore(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
    }
}
