package leetcode;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Chenix
 * @create_date 2024/4/13 23:50
 * @description <a href="https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked">三数之和</a>
 * 给你一个整数数组 nums
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * -----------------------------
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class Hot100_6_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        // step1. 排序
        Arrays.sort(nums);
        System.out.println(JSON.toJSONString(nums));
        // 定义返回结果
        List<List<Integer>> result = new ArrayList<>();

        // 开始循环
        for (int i = 0; i < nums.length; i++) {
            // 指定初始指针位置从头开始，并且值必须<=0
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 定义两端双指针
            int head = i + 1, tail = nums.length - 1;
            int target = -nums[i];
            while (head < tail) {
                if (nums[head] + nums[tail] < target) {
                    // 小于目标值就变大
                    head++;
                    while (head < tail && nums[head - 1] == nums[head]) {
                        head++;
                    }
                } else if (nums[head] + nums[tail] > target) {
                    // 大于目标值就变小
                    tail--;
                    while (head < tail && nums[tail + 1] == nums[tail]) {
                        tail--;
                    }
                } else {
                    // 等于目标值
                    result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    head++;
                    tail--;
                    while (head < tail && nums[head - 1] == nums[head]) {
                        head++;
                    }
                    while (head < tail && nums[tail + 1] == nums[tail]) {
                        tail--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        System.out.println(new Hot100_6_三数之和().threeSum(nums));
    }
}
