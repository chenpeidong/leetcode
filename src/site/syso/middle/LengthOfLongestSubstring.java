package site.syso.middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Object> map = new HashMap<>();
            int temp = 0;

            for (int j = i; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    break;
                }
                map.put(s.charAt(j), null);
                temp++;
            }
            max = temp > max ? temp : max;
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

}






























