package exm.algo.math;

public class SingleNumber {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     *
     * 示例 1：
     * 输入：nums = [3,4,3,3]
     * 输出：4
     *
     * 示例 2：
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
     */
    public int singleNumber(int[] nums) {
        //考虑数字的二进制形式，对于出现三次的数字，各二进制位出现的次数都是3的倍数。
        //因此，统计所有数字的各二进制位中1的出现次数，并对3求余，结果则为只出现一次的数字
        int[] bin = new int[32];
        for (int num : nums) {
            int one = 1;
            for (int i = 0; i < 32; i++) {
                bin[i] += num&1;
                num >>>= 1;
            }
        }
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= bin[i]%3;
        }
        return res;
    }

    /**
     * 有限状态机
     *
     *  00 -> 01 -> 10 -> 00 (输入二进制位为1)
     *  00 -> 00    01 -> 01    10 -> 10 (输入二进制位为0)
     *  三种状态，高位用two表示，低位用one表示
     */
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
