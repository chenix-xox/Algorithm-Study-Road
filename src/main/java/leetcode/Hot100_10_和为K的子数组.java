package leetcode;

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
    public int subarraySum(int[] nums, int k) {
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

    public static void main(String[] args) {
        System.out.println(new Hot100_10_和为K的子数组().subarraySum(new int[]{1, 2, 3}, 3));
    }
}
