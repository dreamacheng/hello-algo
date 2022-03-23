package exm.algo.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcbbcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println("-----------------------------");
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcbbcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("a"));
    }

    // map -> 滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int result = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (window.containsKey(ch)) {
                start = Math.max(window.get(ch), start);
            }
            result = Math.max(result, end - start + 1);
            window.put(ch, end + 1);
        }
        return result;
    }

    // sb -> 滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        StringBuilder window = new StringBuilder();
        int result = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            int index = window.indexOf(String.valueOf(ch));
            if (index > -1) {
                result = Math.max(result, window.length());
                window.delete(0, index + 1);
            }
            window.append(ch);
        }
        return Math.max(result, window.length());
    }
}
