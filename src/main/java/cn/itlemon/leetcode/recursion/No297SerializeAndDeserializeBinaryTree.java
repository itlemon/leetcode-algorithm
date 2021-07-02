package cn.itlemon.leetcode.recursion;

import java.util.LinkedList;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.297 二叉树的序列化与反序列化 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-02
 */
public class No297SerializeAndDeserializeBinaryTree {

    private static final String SEP = ",";
    private static final String NULL = "#";

    /**
     * 将TreeNode序列化成字符串，前序遍历
     *
     * @param root 根节点
     * @return 字符串
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * 将字符串序列化为TreeNode，前序遍历
     *
     * @param data 字符串
     * @return TreeNode
     */
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String item : data.split(SEP)) {
            list.addLast(item);
        }
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        // 前序遍历
        String first = list.removeFirst();
        if (NULL.equals(first)) {
            return null;
        }
        // 处理本节内容
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

}
