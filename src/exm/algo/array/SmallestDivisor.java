package exm.algo.array;

public class SmallestDivisor {

    public static void main(String[] args) {
        int[] nums = new int[]{44,22,33,11,1};
        System.out.println(smallestDivisor(nums, 5));
    }

    // 二分
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 10000000;
        int rest = -1;
        while (left <= right) {
            int mid = left + (right - left >>> 1);
            int sum = 0;
            for (int num : nums) {
                // 向上取整小技巧
//                sum += num / mid + (num % mid == 0 ? 0 : 1);
                sum += (num - 1)/mid + 1;
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                rest = mid;
                right = mid - 1;
            }
        }
        return rest;
    }
}
