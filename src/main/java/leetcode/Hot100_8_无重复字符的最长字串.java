package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenix
 * @date 2024.08.22 17:57
 * @description
 */
public class Hot100_8_无重复字符的最长字串 {
    public int lengthOfLongestSubstring(String s) {
        // step1. 初始化最长字串 = 0
        int maxLen = 0;
        List<String> maxStrings = new ArrayList<>();
        int currentLen = 0;

        // 双指针
        int head = 0;
        int next = 0;
        while (head < s.length() && next < s.length()) {
            String currentChar = s.substring(next, next + 1);
            System.out.println(currentChar + ",head:" + head + ",next:" + next);
            if (!maxStrings.contains(currentChar)) {
                // 没有重复的
                maxStrings.add(currentChar);
                currentLen++;
                // 快指针++
                next++;
            } else {
                // 慢指针++
                head++;
                next = head;
                currentLen = 0;
                maxStrings.clear();
            }
            // 有重复的，记录为maxLen
            if (maxLen < currentLen) {
                maxLen = currentLen;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int result = new Hot100_8_无重复字符的最长字串().lengthOfLongestSubstring("dvdf");
        System.out.println(result);
    }
}
