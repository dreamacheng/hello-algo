package exm.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * desc: 树的最大深度
 */
public class MaxDepth {

    /**
     * 自底向上
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 自顶向下
     * @param root
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curr = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; ++i) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return depth;
    }
}
