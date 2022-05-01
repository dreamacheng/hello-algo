package exm.algo.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序
 */
public class BSTAllElements {

    // 中序遍历BST-归并
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = preorder(root1);
        List<Integer> r2 = preorder(root2);
        List<Integer> rest = new ArrayList<>(r1.size() + r2.size());
        int i = 0, j = 0;
        while (i < r1.size() && j < r2.size()) {
            if (r1.get(i) > r2.get(j)) {
                rest.add(r2.get(j++));
            } else {
                rest.add(r1.get(i++));
            }
        }
        if (i == r1.size()) {
            while (j < r2.size()) {
                rest.add(r2.get(j++));
            }
        }
        if (j == r2.size()) {
            while (i < r1.size()) {
                rest.add(r1.get(i++));
            }
        }
        return rest;
    }

    public List<Integer> preorder(TreeNode root) {
        List<Integer> rest = new ArrayList<>();
        if (root == null) {
            return rest;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            rest.add(curr.val);
            curr = curr.right;
        }
        return rest;
    }
}
