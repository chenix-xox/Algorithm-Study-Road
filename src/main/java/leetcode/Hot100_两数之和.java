package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chenix
 * @create_date 2024/4/11 21:41
 */
public class Hot100_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        // 存储： key为nums的遍历值，value为nums的下标
        Map<Integer, Integer> valueAndIndex = new HashMap<>();
        int need = 0;
        for (int i = 0; i < nums.length; i++) {
            need = target - nums[i];
            if (valueAndIndex.containsKey(need)) {
                return new int[]{i, valueAndIndex.get(need)};
            }
            valueAndIndex.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        Hot100_两数之和 twoSum = new Hot100_两数之和();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
