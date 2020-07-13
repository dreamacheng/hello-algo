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

* 滑动窗口的最大值(https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

  ```
  给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
  ```

  * 单调队列

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
