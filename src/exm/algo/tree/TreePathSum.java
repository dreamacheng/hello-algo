package exm.algo.tree;

import sun.awt.image.ImageWatched;

import java.util.*;

public class TreePathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        List<List<Integer>> res = pathSum(root, 22);
        System.out.println(res);
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     * @param root
     * @param sum
     * @return
     * 递归
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    // dfs 开辟两个迭代用的栈，node stack， sum stack
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        nodeStack.push(root);
        sumStack.push(sum - root.val);

        TreeNode currNode;
        int currSum;
        while (!nodeStack.isEmpty()) {
            currNode = nodeStack.pop();
            currSum = sumStack.pop();
            if (currNode.left == null && currNode.right == null && currSum == 0) return true;
            if (currNode.left != null) {
                nodeStack.push(currNode.left);
                sumStack.push(currSum - currNode.left.val);
            }
            if (currNode.right != null) {
                nodeStack.push(currNode.right);
                sumStack.push(currSum - currNode.right.val);
            }
        }
        return false;
    }

    /**
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-ii
     */
    /**
     * !!!important -> currPath只有一份，放入res的应该是符合条件path的一份拷贝，每次遍历完当前节点后，应删除当前节点
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> currPath = new LinkedList<>();
        recursive(root, sum, currPath, res);
        return res;
    }

    private static void recursive(TreeNode root, int sum, LinkedList<Integer> currPath, List<List<Integer>> res) {
        if (root == null) return;
        currPath.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            // 整个递归过程中，是同一个currPath，必须拷贝
            res.add(new LinkedList<>(currPath));
        }
        if (root.left != null) {
            recursive(root.left, sum - root.val, currPath, res);
        }
        if (root.right != null) {
            recursive(root.right, sum - root.val, currPath, res);
        }
        // important，删除当前遍历完成的节点
        currPath.removeLast();
    }

}
