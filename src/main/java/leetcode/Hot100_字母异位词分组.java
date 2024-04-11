package leetcode;

import java.util.*;

/**
 * @author Chenix
 * @create_date 2024/4/11 21:58
 */
public class Hot100_字母异位词分组 {
    // 自己想的：计算各个ASCII码值的和，计算，可能存在三个字母ASCII值相同的情况
    public List<List<String>> groupAnagramsTest(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        // key为 ASCII的和，value为下标
        Map<Integer, List<String>> valAndIndex = new HashMap<>();
        char[] charArray = null;
        int i = 0;
        for (int j = 0; j < strs.length; j++) {
            i = 0;
            charArray = strs[j].toCharArray();
            for (char c : charArray) {
                // 拆解字符串 并计算每个字符的ASCII总和
                i += (int) c;
            }
            if (valAndIndex.containsKey(i)) {
                // 说明遇到一样的了
                valAndIndex.get(i).add(strs[j]);
            } else {
                // 没有遇到一样的，就put 新的key
                // i 是ASCII的和，j 是下标
                List<String> list = new ArrayList<>();
                list.add(strs[j]);
                valAndIndex.put(i, list);
            }

        }
        valAndIndex.forEach((k, v) -> result.add(v));
        return result;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> codeToGroup = new HashMap<>();
        for (String str : strs) {
            String code = encode(str);
            codeToGroup.putIfAbsent(code, new LinkedList<>());
            codeToGroup.get(code).add(str);
        }
        codeToGroup.forEach((k,v) -> result.add(v));
        return result;
    }

    String encode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        return new String(count);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Hot100_字母异位词分组 groupAnagrams = new Hot100_字母异位词分组();
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
