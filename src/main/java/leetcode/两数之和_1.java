package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Chenix
 * @create 2023-10-08 21:48
 */
public class 两数之和_1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        ;
    }

    public static int[] twoSum(int[] nums, int target) {
        // 求解两数之和
        // 要求 如果数组中有 可以相加等于target的数，返回其下标
        // 用hashmap的键值对存储
        // 存储什么？存储键值对的下标及值.
        HashMap<Integer, Integer> hashTable = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]),i};
            }
            // 存储key为值，value为下标。为什么？因为map里的get方法是通过key得到value
            // value = map.get(key)
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }
}
