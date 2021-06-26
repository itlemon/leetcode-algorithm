package cn.itlemon.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.145 二叉树的后序遍历 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-25
 */
public class No145BinaryTreePostorderTraversal {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
    }

    /**
     * 迭代法：O(n)，常规写法，左右根
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                result.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return result;
    }

    /**
     * 技巧迭代法：O(n)，根右左
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        // 设置一个双端队列逆序保存数据，这样出来的时候就是正序
        Deque<Integer> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                queue.offerFirst(root.val);
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return new ArrayList<>(queue);
    }

}
