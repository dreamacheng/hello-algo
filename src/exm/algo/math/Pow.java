package exm.algo.math;

public class Pow {

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }


    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     *
     * 示例 1:
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     *
     * 示例 2:
     * 输入: 2.10000, 3
     * 输出: 9.26100
     *
     * 示例 3:
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     * 说明:
     * -100.0 < x < 100.0
     * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/powx-n
     */
    public static double myPow(double x, int n) {
        long N = n;
        return N > 0 ? quickMul(x, N) : 1.0/quickMul(x, -N);
    }


    public static double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

}
