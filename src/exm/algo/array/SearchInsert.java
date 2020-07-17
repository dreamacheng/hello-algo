package exm.algo.array;

public class SearchInsert {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        searchInsert(arr, 2);
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start >>> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
