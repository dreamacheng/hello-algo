package exm.algo.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {

    /**
     *
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 示例：
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return s.indexOf(ch);
            }
        }
        return -1;
    }

    public int firstUniqChar2(String s) {
        short[] position = new short[26];
        for (char ch : s.toCharArray()) {
            position[ch - 'a']++;
        }
        for (char ch : s.toCharArray()) {
            if (position[ch - 'a'] == 1) return s.indexOf(ch);
        }
        return -1;
    }
}
