package exm.algo.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,1};
        System.out.println(subarraySum(arr, 2));
    }


    // 前缀和
    public static int subarraySum(int[] nums, int k) {
        int[] suffixSum = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            suffixSum[i] = suffixSum[i-1] + nums[i-1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : suffixSum) {
            int target = i - k;
            Integer count = map.get(target);
            if (Objects.nonNull(count)) {
                result += count;
            }
            map.merge(i, 1, Integer::sum);
        }
        return result;
    }
}
