package exm.algo.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicateNum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(arr));
    }

    /**
     * desc: 找出数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     * @param nums
     * @return
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        throw new RuntimeException("array illegality");
    }

    /**
     * 优化：不使用额外的空间
     * 时间复杂度 O(n)  空间复杂度 O(1)
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0, len = nums.length; i < len; ++i) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) { // 值为nums[i] 的元素已经在 下标为nums[i]时，数字重复
                    return nums[i];
                }
                // 否则 交换 nums[i] 与 nums[nums[i]], 每次交换，都会使一个 num[i] = i 成立，即下标与值相等
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        throw new RuntimeException("array illegality");
    }
}
