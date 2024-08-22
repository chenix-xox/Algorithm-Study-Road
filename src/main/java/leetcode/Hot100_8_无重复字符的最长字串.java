package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenix
 * @date 2024.08.22 17:57
 * @description
 */
public class Hot100_8_无重复字符的最长字串 {
    public int lengthOfLongestSubstring_bak(String s) {
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

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // 初始化最大长度
        int maxLen = 0;
        // 创建Map存储每个字符及其对应的位置
        Map<Character, Integer> map = new HashMap<>();
        // 初始化左指针为0
        int left = 0;

        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 如果是已经重复的，就移动左指针，到重复的那一个字符串右边来，作为第二段字串的起始字符串
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 每个元素都往map里面塞
            map.put(s.charAt(i), i);
            // 根据左指针最新值，计算当前位置到左指针的长度是多少，例如左指针指向第一个字符，下标为0，left 为0，当前遍历到了第十个字符，i=9，总体长度为i-left+1 = 9-0+1= 10
            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int result = new Hot100_8_无重复字符的最长字串().lengthOfLongestSubstring("dvdf");
        System.out.println(result);
    }
}
