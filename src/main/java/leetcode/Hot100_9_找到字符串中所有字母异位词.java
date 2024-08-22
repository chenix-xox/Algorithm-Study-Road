package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenix
 * @date 2024.08.22 20:41
 * @description
 */
public class Hot100_9_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // 先把所需的内容存储起来，need中包含所需的每个字符及每个字符所需的数量
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            // 如果不存在，就取0 + 1，如果存在就在原有基础上+1
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 定义窗口map
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        // valid表示窗口中已经满足need的个数
        int valid = 0;
        // 遍历 母字符串
        while (right < s.length()) {
            // 获取当前字符
            char currentChar = s.charAt(right);
            // 窗口右边++
            right++;
            if (need.containsKey(currentChar)) {
                // 是我要的数据，放入窗口
                window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);
                if (window.get(currentChar).equals(need.get(currentChar))) {
                    // 当前字符已经达到要求了，valid++
                    valid++;
                }
            }

            // 左-右，如果长度超过了希望得到的结果长度，需要移动左指针
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    // 验证数量达到要求，将左指针添加到结果中
                    result.add(left);
                }
                //  取左指针指向的字符，并移动左指针
                char currentLeftChar = s.charAt(left);
                left++;
                // 如果此次移除的是需要的，需要从窗口中移除该元素，即：窗口中只会放入需要的元素
                if (need.containsKey(currentLeftChar)) {
                    // 如果此时所需和已有的数量是相等的，还需要--
                    if (need.get(currentLeftChar).equals(window.get(currentLeftChar))) {
                        valid--;
                    }
                    // 从窗口中移除
                    window.put(currentLeftChar, window.get(currentLeftChar) - 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = new Hot100_9_找到字符串中所有字母异位词().findAnagrams("baa", "aa");
        System.out.println(JSON.toJSONString(result));
    }
}
