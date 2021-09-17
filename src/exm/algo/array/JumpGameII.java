package exm.algo.array;

public class JumpGameII {

    public static void main(String[] args) {
        System.out.println(jump2(new int[]{2,3,1,1,4}));
    }

    // 每次在上次能跳到的范围（end）内选择一个能跳到的最远位置（max）作为新的范围
    public static int jump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("fuck input illegal");
        }
        int max = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }

    // 从后往前，贪心寻找最远值
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("fuck input illegal");
        }
        int pos = nums.length - 1;
        int step = 0;
        while (pos > 0) {
            int minIndex = pos;
            for (int i = pos - 1; i >= 0; i--) {
                if (nums[i] >= pos - i) {
                    minIndex = i;
                }
            }
            pos = minIndex;
            step++;
        }
        return step;
    }
}
