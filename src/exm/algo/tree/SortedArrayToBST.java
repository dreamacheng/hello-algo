package exm.algo.tree;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) return null;
        return bulidHelper(nums, 0, nums.length - 1);
    }

    // 归并迭代构建
    private TreeNode bulidHelper(int[] nums, int start, int end) {
        if (start == end) return new TreeNode(nums[start]);
        if (start > end) return null;
        int mid = start + (end - start >>> 1);
        TreeNode root = new TreeNode(nums[mid]);
        return buildTreeNode(root, bulidHelper(nums, start, mid - 1), bulidHelper(nums, mid + 1, end));
    }

    private TreeNode buildTreeNode(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return null;
        root.left = left;
        root.right = right;
        return root;
    }
}
