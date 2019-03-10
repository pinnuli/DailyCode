package the37_序列化二叉树;

/**
 * author@ pinnuli
 * date@ 2019/3/9
 */
public class Solution {
    String deserializeStr;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#");
            return sb.toString();
        }
        sb.append(root.val);
        sb.append(",");
        sb.append(Serialize(root.left));
        sb.append(",");
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    TreeNode Deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(",");
        String nodeStr = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);

        if (nodeStr.equals("#")) {
            return null;
        }

        int nodeVal = Integer.valueOf(nodeStr);
        TreeNode node = new TreeNode(nodeVal);
        node.left = Deserialize();
        node.right = Deserialize();
        return node;
    }
}
