## **Hello algo**

### * Array

 * 找出数组中重复的数字(https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

   ```
   找出数组中重复的数字。在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
   数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
   请找出数组中任意一个重复的数字。
   ```

   * 使用辅助集合 （时间复杂度：O(n) , 空间复杂度：O(n) ）
   * 利用输入数组的元素范围在0 ~ n-1的特性，将值为i的元素放至index为i的位置
     * 当index为i的元素值已经为i时，元素重复
     * 不重复则交换nums[i] 与 nums[nums[i]]（每次交换都会使一个nums[i]=i成立）

* 数组中的第K个最大元素(https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

  ```
  在未排序的数组中找到第 k 个最大的元素。
  请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
  ```

  * 快排减治
  * 堆

* 旋转数组的最小数字(https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof)

  ```
  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
  ```

  * 二分法缩减搜索范围

* 长度最小的子数组(https://leetcode-cn.com/problems/minimum-size-subarray-sum)

  ```
  给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
  ```

  * 设置滑动窗口（双指针）（时间复杂度：O(n) , 空间复杂度：O(1) ）
  * 前缀和 + 二分查找  (时间复杂度：O(nlogn) , 空间复杂度：O(n) )

* 三数之和(https://leetcode-cn.com/problems/3sum/)

  ```
  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
  ```

  * 双指针

* 三数之和(https://leetcode-cn.com/problems/3sum/)

  ```
  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
  ```

  * 排序 + 双指针

* 最接近的三数之和(https://leetcode-cn.com/problems/3sum-closest/)

  ```
  给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
  ```

  * 排序 + 双指针

* 两数之和(https://leetcode-cn.com/problems/two-sum/)

  ```
  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
  ```

  * 哈希表
  
* 跳跃游戏(https://leetcode-cn.com/problems/jump-game/)

  ```
  给定一个非负整数数组，你最初位于数组的第一个位置。
  数组中的每个元素代表你在该位置可以跳跃的最大长度。
  判断你是否能够到达最后一个位置。
  ```

  * 每次遍历维护当前位置所能到达的最远位置，能到达数组最后返回true，达到位置为0时false

* 两个数组的交集(https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/)

  ```
  给定两个数组，编写一个函数来计算它们的交集。
  ```

  * 利用哈希表
  * 排序后双指针

* 下一个排列(https://leetcode-cn.com/problems/next-permutation/)

  ```
  实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
  如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
  必须原地修改，只允许使用额外常数空间。
  以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
  ```

  * 从后往前遍历扫描，找到第一个单调递减的数，再反向遍历找到大于交换点的数，翻转交换点以后的数据位以保证单调递增

* 全排列(https://leetcode-cn.com/problems/permutations)

  ```
  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
  ```

  * dfs + 回溯

* 合并区间(https://leetcode-cn.com/problems/merge-intervals/)

  ```
  给出一个区间的集合，请合并所有重叠的区间。
  ```

  * 排序 + 双指针

### * LinkedList

* 两数相加(https://leetcode-cn.com/problems/add-two-numbers/)

  ```
  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
  ```

  * 设置进位标志（dummy节点简化判断）

* 两数相加2(https://leetcode-cn.com/problems/add-two-numbers-ii/)

  ```
  给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
  你可以假设除了数字 0 之外，这两个数字都不会以零开头。
  ```

  * 借助栈使得从低位开始加，设置进位标志（返回的节点采取头插法）

* 相交链表(https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)

  ```
  编写一个程序，找到两个单链表相交的起始节点。
  ```

  * 双指针（两个指针都走lenA+lenB，当结束时，pA != PB且不为null，则相交，null则不相交）

* 环形链表2(https://leetcode-cn.com/problems/linked-list-cycle-ii/)

  ```
  给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
  说明：不允许修改给定的链表。
  ```

  * 双指针（先双指针判断链表是否有环，有环头节点与相交节点一起遍历，相等时即为入环节点）

* 合并两个有序链表2(https://leetcode-cn.com/problems/merge-two-sorted-lists/)

  ```
  将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
  ```

  * 设置dummy顺序遍历合并
  * 递归

* 合并K个有序链表2(https://leetcode-cn.com/problems/merge-k-sorted-lists/)

  ```
  合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
  ```

  * 归并合并链表（渐进时间复杂度：O(kn*logk) , 空间复杂度：O(logk) ）

* 翻转链表(https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

  ```
  定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
  ```

  * 顺序翻转
  * 递归

* 回文链表(https://leetcode-cn.com/problems/palindrome-linked-list/)

  ```
  请判断一个链表是否为回文链表。
  ```

  * 快慢双指针（慢指针遍历的同时翻转链表）（特殊处理两个节点时和奇数节点与偶数节点）

* 删除链倒数第K个节点

  * 双指针

* 移除链表元素(https://leetcode-cn.com/problems/remove-linked-list-elements/)

  ```
  删除链表中等于给定值 val 的所有节点。
  ```

  * 使用dummy节点顺序遍历删除

* K个一组翻转链表(https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

  ```
  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
  k 是一个正整数，它的值小于或等于链表的长度。
  如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
  ```

  * 一次遍历获取长度，顺序遍历翻转
  * 记录四个关键节点，当前翻转片段的头节点，尾节点，头节点的前驱，尾节点的后继，顺序翻转

### * Stack、Queue、Heap

 * 每日温度（https://leetcode-cn.com/problems/daily-temperatures）

   ```
   请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
   例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
   你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
   提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
   ```

   * 单调栈

* 滑动窗口的最大值(https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

  ```
  给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
  ```

  * 单调队列


### * Tree

 * 不同的二叉搜索树Ⅱ(https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)

   ```
   给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
   ```

   * 递归 =》枚举根节点，递归得到可行左右子树集合，对每次枚举的根节点求可行左右子树的笛卡尔积

* 二叉树的镜像(https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

  ```
  请完成一个函数，输入一个二叉树，该函数输出它的镜像。
  ```

  * 递归

* 将有序数组转换为二叉搜索树(https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree)

  ```
  请完成一个函数，输入一个二叉树，该函数输出它的镜像。
  ```

  * 归并递归构建

* 验证二叉搜索树(https://leetcode-cn.com/problems/validate-binary-search-tree/)

  ```
  给定一个二叉树，判断其是否是一个有效的二叉搜索树。
  假设一个二叉搜索树具有如下特征：
  节点的左子树只包含小于当前节点的数。节点的右子树只包含大于当前节点的数。
  所有左子树和右子树自身必须也是二叉搜索树。
  ```

  * 递归 =》 每次递归更新子树的最大最小值
  * 利用 BST 的中序遍历为升序的特点

### * DP

* 最长重复子数组(https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/)

  ```
  给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
  ```

  * dp, 子问题定义
  * 滑动窗口

* 买卖股票的最佳时机(https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

  ```
  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
  注意：你不能在买入股票前卖出股票。
  ```

  * dp, 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
  * 空间优化 =》 单调栈思想

* 连续子数组的最大和(https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

  ```
  输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
  要求时间复杂度为O(n)。
  ```

  * dp, f(k) = max{ f(k-1), 0 } + nums[k-1]

* 最小路径和(https://leetcode-cn.com/problems/minimum-path-sum)

  ```
  给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
  说明：每次只能向下或者向右移动一步。
  ```

  * dp, f(i,j) = grid(i-1,j-1) + Math.min(f(i-1, j), f(i, j-1))

* 打家劫舍(https://leetcode-cn.com/problems/house-robber/)

  ```
  你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
  给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
  ```

  * dp, f(n) = Max(f(n-2) + arr[n-1], f(n-1) )

* 打家劫舍2(https://leetcode-cn.com/problems/house-robber-ii/)

  ```
  你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
  给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况
  ```

  * dp, f(n) = Max(f(n-2) + arr[n-1], f(n-1) ) ==> 分别计算【0..n-1】与 【1...n】，取最大值

* 打家劫舍3(https://leetcode-cn.com/problems/house-robber-iii/)

  ```
  在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
  计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
  ```

  * 递归
    * 由 rest数组表示当前节点偷或不偷两种状态， rest[0]表示当前节点不可以偷， rest[1]表示当前节点可以偷
    * rest[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
    * rest[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;

