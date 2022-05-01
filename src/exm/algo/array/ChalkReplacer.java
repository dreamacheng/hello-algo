package exm.algo.array;

/**
 * 一个班级里有 n 个学生，编号为 0 到 n - 1 。每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。
 *
 * 给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，那么学生 i 需要 补充 粉笔。
 *
 * 请你返回需要 补充 粉笔的学生 编号 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk
 */
public class ChalkReplacer {

    // 前缀和 + 二分
    public int chalkReplacer(int[] chalk, int k) {
        long[] sum = new long[chalk.length];
        sum[0] = chalk[0];
        for (int i = 1; i < chalk.length; i++) {
            sum[i] = sum[i-1] + chalk[i];
        }
        long m = k % sum[chalk.length - 1];
        if (m == 0) {
            return 0;
        }
        int l = 0, r = chalk.length - 1;
        int rest = -1;
        while (l <= r) {
            int mid = l + (r - l >>> 1);
            if (sum[mid] > m) {
                rest = mid;
                r = mid - 1;
            } else if (sum[mid] < m) {
                l = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return rest;
    }
}
