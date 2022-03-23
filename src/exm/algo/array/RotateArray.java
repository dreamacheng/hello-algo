package exm.algo.array;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *  
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 1) {
            return;
        }
        if (k > nums.length) {
            k = k % nums.length;
        }
        for (int i = 0; i < nums.length/2; i++) {
            exchange(nums, i, nums.length - i - 1);
        }
        for (int i = 0; i < k/2; i++) {
            exchange(nums, i, k - i -1);
        }
        for (int i = k, j = 0; i < (k + nums.length)/2; i++, j++) {
            exchange(nums, i, nums.length - 1 - j);
        }
    }

    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
