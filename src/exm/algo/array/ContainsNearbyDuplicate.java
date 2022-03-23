package exm.algo.array;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 *  
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1,2,3,1};
        System.out.println(containsNearbyDuplicate2(arr1, 3));

        int[] arr2 = new int[]{1,0,1,1};
        System.out.println(containsNearbyDuplicate2(arr2, 1));

        int[] arr3 = new int[]{1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate2(arr3, 2));
    }

    // 几乎暴力
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            for (int i = 1; i < list.size(); i++) {
                if (Math.abs(list.get(i) - list.get(i - 1)) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 滑动窗口
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (k > nums.length) {
            k = nums.length;
        }
        Set<Integer> set = new HashSet<>(k+1);
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
