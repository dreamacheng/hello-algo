package exm.algo.tree;

import java.util.*;

public class SerializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        List<Integer> rest = new ArrayList<>();
        while (!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                rest.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        String val = rest.toString().replace(" ", "");
        return val.substring(1, val.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        int[] preorder = Arrays.stream(data.split(",")).mapToInt(Integer::valueOf).toArray();
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int start, int end, int[] inorder, int left, int right) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int cursor = -1;
        for (int i = left; i <= right; i++) {
            // 可以用二分优化
            if (inorder[i] == root.val) {
                cursor = i;
            }
        }
        int leftCnt = cursor - left;
        root.left = buildTree(preorder, start + 1, start + leftCnt, inorder, left, cursor - 1);
        root.right = buildTree(preorder, start + leftCnt + 1, end, inorder,  cursor + 1, right);
        return root;
    }

}
