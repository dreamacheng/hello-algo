package exm.algo.dp;


public class RobSeries {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(maxMoney2(arr));
    }

    /**
     * description：LeetCode 198. House Robber
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * eg:
     *  input: [2, 2, 5, 4]
     *  output: 7
     *
     *  f(n) = Max(f(n-2) + arr[n-1], f(n-1) )
     */
    public static int maxMoney (int[] arr) {
        int length = arr.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];

        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i < length + 1; i ++) {
            dp[i] = Math.max(dp[i-2] + arr[i-1], dp[i-1]);
        }

        return dp[length];
    }
    // 空间优化
    public static int maxMoney2 (int[] arr) {
        int prev = 0;
        int curr = 0;

        for (int i : arr) {
            // 循环开始时 prev 表示 dp[i-2], curr 表示 dp[i-1]
            // dp[i] = Math.max(dp[i-2] + arr[i-1], dp[i-1]);
            int temp = Math.max(prev + i, curr);
            prev = curr;
            curr = temp;

            // 循环结束 prev 表示 dp[i-1], curr 表示 dp[i]
        }
        return curr;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     */
    public int rob(int[] nums) { // 对nums[1..n] 和 nums[0..n-1] 求dp最大值
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(maxProfit(nums, 0, nums.length - 1), maxProfit(nums, 1, nums.length));
    }

    private int maxProfit(int[] nums, int start, int end) {
        if (start >= end) return nums[start];
        int pre = 0, curr = 0;
        for (int i = start; i < end; i++) {
            int temp = Math.max(pre + nums[i], curr);
            pre = curr;
            curr = temp;
        }
        return curr;
    }


    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int rob2(TreeNode root) {
        // 由 rest数组表示当前节点偷或不偷两种状态， rest[0]表示当前节点不可以偷， rest[1]表示当前节点可以偷
        // rest[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
        // rest[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
        int[] rest = robTreeNode(root);
        return Math.max(rest[0], rest[1]);
    }

    private int[] robTreeNode(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];
        int[] left = robTreeNode(root.left);
        int[] right = robTreeNode(root.right);
        result[0] = Math.max(left[0],left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
