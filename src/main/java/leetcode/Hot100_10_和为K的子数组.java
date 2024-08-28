package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenix
 * @date 2024.08.23 23:11
 * @description 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * -------------
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * --------------
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class Hot100_10_和为K的子数组 {
    public int subarraySum_bak(int[] nums, int k) {
        int result = 0;
        // 思路整理
        // 暴力枚举？滑动窗口？
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 起始点为每一个下标的值
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                System.out.println(j);
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    private int[] preSums;

    public int subarraySum(int[] nums, int k) {

        // 前缀和思想：题目说是一段连续的数、并且要求连续的数=固定值 前缀和秒了！
        // 什么是前缀和呢
        // 比如一个数组是：[3,6,-2,3,7,1]
        // 前缀和就是   [0,3,9,7,10,17,18]

       /* // so， step1：计算出所有前缀和
        //        preSums = new int[nums.length + 1];
        //        for (int i = 1; i <= nums.length; i++) {
        //            preSums[i] += preSums[i - 1] + nums[i - 1];
        //        }
        //
        //        // step2.*/
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // {1, 2, 3}
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 为什么使用sum - k判断？
            // 1. sum是不断计算累积的和，并且每次会把每一项累积的前缀和，存储到map里面去，并存储其出现的次数
            if (map.containsKey(sum - k)) {
                // sum - k 可以得到什么？当前所有前缀和 - 目标值，可以的得到之前某个位置的前缀和
                // 例如{1，2，3}的前缀和（实时sum及map存储）为{0，1，3，6}，代表着{初始值、[0~1)的前缀和、[0~2)的前缀和、[0~3)的前缀和}
                // 用当前和，减去目标值，如果能得到之前的某个前缀和（sum-k=s），s代表之前的前缀和
                // 说明什么？sum-s = 当前位置-某个前缀和 = 当前位置到某个前缀和中间这一段的和（即：子数组）
                // 所以，sum - s = k，说明找到了等于目标值的子数组和，反推就是sum - k找之前的前缀和（s）
                // [0~j) = s, [j+1~i) = k, [0~i) = sum
                System.out.println(JSON.toJSONString(map));
//                result += map.get(sum - k);
                result++;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    private int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }

    public static void main(String[] args) {
        System.out.println(new Hot100_10_和为K的子数组().subarraySum(new int[]{1, -1, 1, -1, 1, -1, 1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0));
    }
}
