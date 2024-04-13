package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chenix
 * @create_date 2024/4/13 23:50
 * @description
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class Hot100_6_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
    }
}
