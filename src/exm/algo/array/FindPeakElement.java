package exm.algo.array;

public class FindPeakElement {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,2}));
        System.out.println(findPeakElement2(new int[]{1,2,3,2}));
    }

    // 上坡一定有坡顶
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("fuck input illegal");
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left >>> 1);
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    // 暴力美学
    public static int findPeakElement2(int[] nums) {
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }
}
