package exm.algo.array;

public class MinArray {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,4,1};
        System.out.println(minArray(arr));
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
     * @param numbers
     * @return
     */
    // 二分法： 时间：O(logn) 空间： O(1)
    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return -1;
        }
        int i = 0, j = numbers.length - 1;
        if (numbers[i] < numbers[j]) { // 数组未旋转
            return numbers[0];
        }
        while (i < j) {
            int mid = i + (j - i >>> 1);
            if (numbers[mid] > numbers[j]) { // mid在左排序数组
                i = mid + 1;
            } else if (numbers[mid] < numbers[j]) { // mid在右排序数组
                j = mid;
            } else {
                j--; // 旋转点仍在 [i, j] 区间内
            }
        }
        return numbers[i];
    }
}
