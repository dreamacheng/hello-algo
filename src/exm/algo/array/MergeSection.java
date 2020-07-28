package exm.algo.array;

import java.util.*;

public class MergeSection {

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     */
    public int[][] merge(int[][] intervals) { // 排序 + 双指针

        if (intervals == null || intervals.length == 0) return new int[][]{};
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int[][] rest = new int[intervals.length][2];
        int left = 0, k = 0;
        int max = intervals[left][1];
        for (int right = 1; right <= intervals.length; right++) {
            if (right < intervals.length && max >= intervals[right][0]) {
                max = Math.max(max, intervals[right][1]);
            } else {
                rest[k++] = (new int[]{intervals[left][0], max});
                left = right;
                max = intervals[left == intervals.length ? left -1 : left][1];
            }
        }
        return Arrays.copyOf(rest, k);
    }

}
