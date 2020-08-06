package exm.algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     */
    public List<List<Integer>> permute(int[] nums) { // dfs + 回溯
        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<List<Integer>> rest = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        for (int num : nums) {
            curr.add(num);
        }
        backtrack(nums.length, rest, curr, 0);
        return rest;
    }

    private void backtrack(int len, List<List<Integer>> rest, List<Integer> curr, int currIndex) {
        if (currIndex == len) {
            rest.add(new ArrayList<>(curr));
        }
        for (int i = currIndex; i < len; i++) {
            Collections.swap(curr, currIndex, i);
            backtrack(len, rest, curr, currIndex + 1);
            Collections.swap(curr, currIndex, i);
        }
    }
}
