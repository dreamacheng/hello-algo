package exm.algo.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow {

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
     * @param nums
     * @param k
     * @return
     */
    // 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        if (k <= 1) return nums;
        int[] rest = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        rest[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            rest[i - k + 1] = deque.peekFirst();
        }
        return rest;
    }
}
