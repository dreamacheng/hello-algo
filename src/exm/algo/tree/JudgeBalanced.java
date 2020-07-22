package exm.algo.tree;

public class JudgeBalanced {


    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int deviation = Math.abs(height(root.right, 1) - height(root.left, 1));
        return  deviation <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node, int height) {
        if (node == null) return height;
        height++;
        int curr = Math.max(height(node.right, height), height(node.left, height));
        return  curr;
    }
}
