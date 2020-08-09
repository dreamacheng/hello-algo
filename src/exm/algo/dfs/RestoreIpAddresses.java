package exm.algo.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {

    private List<String> rest = new LinkedList<>();

    private static final int SEGMENT_COUNT = 4;

    private int[] dfs_seg;

    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     *
     * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
     *
     * 示例:
     *
     * 输入: "25525511135"
     * 输出: ["255.255.11.135", "255.255.111.35"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
     */
    public List<String> restoreIpAddresses(String s) { // dfs
        dfs_seg = new int[SEGMENT_COUNT];
        dfs(s, 0, 0);
        return rest;
    }

    private void dfs(String s, int segId, int segStart) {

        // dfs 终点
        if (segId == SEGMENT_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEGMENT_COUNT; i++) {
                    sb.append(dfs_seg[i]);
                    if (i != SEGMENT_COUNT - 1) {
                        sb.append(".");
                    }
                }
                rest.add(sb.toString());
            }
            return;
        }

        // 字符串提前遍历完成，终止
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            dfs_seg[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                dfs_seg[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }

    }
}
