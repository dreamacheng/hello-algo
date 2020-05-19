package exm.algo.tree;

import java.util.LinkedList;

/**
 *  desc: 判断二叉树是否为镜像二叉树，即左右对称
 */
public class MirrorBinaryTree {

    /**
     * DFS 递归比较
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? false : isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.right, right.left) && isMirror(left.left, right.right);
    }

}
