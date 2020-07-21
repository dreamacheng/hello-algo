package exm.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     *
     * 示例：
     *
     * 输入：3
     * 输出：
     * [
     *   [1,null,3,2],
     *   [3,2,null,1],
     *   [3,1,null,null,2],
     *   [2,1,3],
     *   [1,null,2,null,3]
     * ]
     * 解释：
     * 以上的输出对应以下 5 种不同结构的二叉搜索树：
     *
     *    1         3     3      2      1
     *     \       /     /      / \      \
     *      3     2     1      1   3      2
     *     /     /       \                 \
     *    2     1         2                 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
     */
    public List<TreeNode> generateTrees(int n) {
        if (n < 0) throw new RuntimeException("fucking illegal input");
        if (n == 0) return Collections.emptyList();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        // 枚举根节点
        for (int i = start; i <= end; i++) {
            // 所有可行的左子树集合
            List<TreeNode> lTrees = generateTrees(start, i - 1);

            // 所有可行的右子树集合
            List<TreeNode> rTrees = generateTrees(i + 1, end);


            for (TreeNode lTree : lTrees) {
                for (TreeNode rTree : rTrees) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = lTree;
                    curr.right = rTree;
                    allTrees.add(curr);
                }
            }

        }
        return allTrees;
    }
}
