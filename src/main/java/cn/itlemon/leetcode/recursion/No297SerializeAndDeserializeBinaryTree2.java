package cn.itlemon.leetcode.recursion;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.297 二叉树的序列化与反序列化 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-03
 */
public class No297SerializeAndDeserializeBinaryTree2 {

    private static final String SEP = ",";
    private static final String NULL = "#";

    /**
     * 将TreeNode序列化成字符串，层序遍历
     *
     * @param root 根节点
     * @return 字符串
     */
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node == null) {
                result.append(NULL + SEP);
            } else {
                result.append(node.val).append(SEP);
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
        }
        return result.toString();
    }

    /**
     * 将字符串序列化为TreeNode，层序遍历
     *
     * @param data 字符串
     * @return TreeNode
     */
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        LinkedList<String> temp = new LinkedList<>(Arrays.asList(data.split(SEP)));
        TreeNode root = new TreeNode(Integer.parseInt(temp.removeFirst()));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            String left = temp.removeFirst();
            String right = temp.removeFirst();
            if (!NULL.equals(left)) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.addLast(node.left);
            }
            if (!NULL.equals(right)) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.addLast(node.right);
            }
        }
        return root;
    }

}
