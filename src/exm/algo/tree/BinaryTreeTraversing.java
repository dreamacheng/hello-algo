package exm.algo.tree;

import java.util.*;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversing {

    /**
     * 递归前序遍历
     * @param root 根节点
     */
    public static void preorderTraversing1 (TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversing1(root.lChild);
        preorderTraversing1(root.rChild);
    }

    /**
     * 非递归前序遍历
     * 借助栈来实现 根 -> 左子节点 -> 右子节点 的遍历
     * @param root 根节点
     */
    public static List<Integer> preorderTraversing2 (TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode spec = null;
        while (!stack.isEmpty()) {
            spec = stack.pop();
            result.add(spec.val);
            if(spec.rChild != null) {
                stack.push(spec.rChild);
            }
            if(spec.lChild != null) {
                stack.push(spec.lChild);
            }
        }
        return result;
    }

    /**
     * 递归中序遍历
     * @param root 根节点
     */
    public static void inorderTraversing1 (TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversing1(root.lChild);
        System.out.print(root.val + " ");
        inorderTraversing1(root.rChild);
    }

    /**
     * 非递归中序遍历
     * 借助一个栈实现
     * 1.循环压入左子树，直到左子树为空
     * 2.pop当前节点并打印，再以同样的模式遍历右子树
     * 3.当栈与当前节点都为空时，遍历完成
     * @param root
     */
    public static List<Integer> inorderTraversing2 (TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode spec = root;
        while (!stack.isEmpty() || spec != null) {
            while (spec != null) {
                stack.push(spec);
                spec = spec.lChild;
            }
            spec = stack.pop();
            result.add(spec.val);
            spec = spec.rChild;
        }
        return result;
    }

    /**
     * 递归后序遍历
     * @param root
     */
    public static void postorderTraversing1 (TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversing1(root.lChild);
        postorderTraversing1(root.rChild);
        System.out.print(root.val + " ");
    }

    /**
     * 非递归后序遍历
     * 借助两个栈实现，首先将当前节点放入栈一，pop后将左右子节点继续放入栈一，并将当前节点放如栈二
     * 循环以上过程直到栈一为空，此时栈二节点的出栈顺序即为树的后序遍历
     * （当前节点的左右子树入栈一时，是左节点先入，以保证在入栈二时是后入）
     *
     *  先序： 根 -> 左 -> 右    变形： 根 -> 右 -> 左 逆序遍历  —> 后序
     * @param root
     */
    public static List<Integer> postorderTraversing2 (TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack1 = new Stack<>();
//        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode spec= root;
        stack1.push(spec);
        while (!stack1.isEmpty()) {
            spec = stack1.pop();
            if (spec.lChild != null) {
                stack1.push(spec.lChild);
            }
            if (spec.rChild != null) {
                stack1.push(spec.rChild);
            }
//            stack2.push(spec);
            result.addFirst(spec.val);
        }
//        while (!stack2.isEmpty()) {
//            System.out.print(stack2.pop().val + " ");
//        }
        return result;
    }

    /**
     * 按层遍历二叉树
     * 借助一个队列，不断将每层节点放入队列，放入下一层节点时打印当前层
     * LinkedList 实现了 Queue<E> 接口
     * @param root
     */
    public static void layerTraversing(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cur = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.lChild != null) {
                queue.offer(cur.lChild);
            }
            if (cur.rChild != null) {
                queue.offer(cur.rChild);
            }
            System.out.print(cur.val + " ");
        }
    }

    /**
     * 层遍历二叉树
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while(!nodes.isEmpty()) {
            List<Integer> res = new LinkedList<>();
            // size即为当前遍历层的节点数
            int size = nodes.size();
            // 遍历当层节点，按照从左至右的顺序将当前层的子节点放入LinkedList,
            for (int i = 0; i < size; i++) {
                TreeNode curr = nodes.poll();
                res.add(curr.val);
                if (curr.lChild != null) {
                    nodes.add(curr.lChild);
                }
                if (curr.rChild != null) {
                    nodes.add(curr.rChild);
                }
            }
            result.add(res);
        }
        return result;
    }
}

class TreeNode {
    TreeNode lChild;
    TreeNode rChild;
    Integer val;
    TreeNode(Integer val) {
        this.val = val;
    }
}