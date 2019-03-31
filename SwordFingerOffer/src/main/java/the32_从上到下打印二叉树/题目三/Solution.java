package the32_从上到下打印二叉树.题目三;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

/**
 * author@ pinnuli
 * date@ 2019/3/31
 */
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) {
            return result;
        }
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            result.add(list);
        }
        return result;
    }
}
