package the34_二叉树中和为某一值的路径;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * author@ pinnuli
 * date@ 2019/3/8
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null){
            return result;
        }

        findPath(root, target, new ArrayList<Integer>());
        return result;
    }

    private void findPath(TreeNode node, int target, ArrayList<Integer> path) {
        path.add(node.val);
        target -= node.val;

        if (target == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<Integer>(path));
        }

        if (node.left != null) {
            findPath(node.left, target, path);
        }

        if (node.right != null) {
            findPath(node.right, target, path);
        }

        path.remove(path.size() - 1);
    }
}
