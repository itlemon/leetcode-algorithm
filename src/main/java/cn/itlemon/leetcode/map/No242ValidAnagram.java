package cn.itlemon.leetcode.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * No.242 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-23
 */
public class No242ValidAnagram {

    /**
     * 排序: O(nlogn)
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 是否是有效的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    /**
     * 哈希法：O(n)
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 是否是有效的字母异位词
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

}
