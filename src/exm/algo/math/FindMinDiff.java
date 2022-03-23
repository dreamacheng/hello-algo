package exm.algo.math;

import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 2 <= timePoints.length <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 */
public class FindMinDiff {

    /**
     * bitmap
     * 桶排序
     */
    public int findMinDifference(List<String> timePoints) {
        final int MOD = 32;
        final int timeTotal = 24 * 60;
        if (timePoints.size() > timeTotal) {
            return 0;
        }
        int len = timeTotal / MOD;
        int[] bitmap = new int[len];
        for (String str : timePoints) {
            String[] split = str.split(":");
            int timeSum = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            int pos = timeSum / MOD;
            int bitPos = timeSum % MOD;
            if ((bitmap[pos] & (1 << bitPos)) != 0) {
                return 0;
            }
            bitmap[pos] |= 1 << bitPos;
        }
        int min = timeTotal;
        int curTime = 0;
        int preTime = -1;
        int head = 0;
        while (curTime < timeTotal) {
            int pos = curTime / MOD;
            int bitPos = curTime % MOD;
            if ((bitmap[pos] & (1 << bitPos)) != 0) {
                if (preTime == -1) {
                    head = curTime;
                    preTime = curTime++;
                    continue;
                }
                min = Math.min(min, curTime - preTime);
                preTime = curTime++;
                continue;
            }
            curTime++;
        }
        return Math.min(min, Math.min(preTime - head, timeTotal - preTime + head));
    }
}
