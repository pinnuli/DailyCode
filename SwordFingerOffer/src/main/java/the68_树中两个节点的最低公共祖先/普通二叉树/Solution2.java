package the68_树中两个节点的最低公共祖先.普通二叉树;

import java.util.ArrayList;

/**
 * author@ pinnuli
 * date@ 2019/3/30
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        getNodePath(root, p, path1);
        getNodePath(root, p, path2);
        return getLastCommonNode(path1, path2);
    }

    private TreeNode getLastCommonNode(ArrayList<TreeNode> list1, ArrayList<TreeNode> list2) {
        TreeNode commonNode = null;
        int index = 0;
        while (index < list1.size() && index < list2.size() && list1.get(index) == list2.get(index)) {
            commonNode = list1.get(index);
            index ++;
        }
        return commonNode;
    }

    private boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> list) {
        if (root == null) {
            return false;
        }
        list.add(root);
        if (list.get(list.size() - 1) == node) {
            return true;
        }
        boolean found = false;
        if (root.left != null) {
            found = getNodePath(root.left, node, list);
        }
        if (!found && root.right != null) {
            found = getNodePath(root.right, node, list);
        }
        if (!found) {
            list.remove(list.size() - 1);
        }
        return found;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        Solution2 solution2 = new Solution2();
        solution2.lowestCommonAncestor(root, left, right);
    }
}
