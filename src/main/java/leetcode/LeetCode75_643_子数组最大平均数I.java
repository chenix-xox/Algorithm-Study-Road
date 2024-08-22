package leetcode;

/**
 * @author chenix
 * @date 2024.08.22 23:43
 * @description <a href="https://leetcode.cn/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75">643. 子数组最大平均数 I</a>
 * <br>
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。<br>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。<br>
 * 任何误差小于 10-5 的答案都将被视为正确答案。<br>
 * ------------<br>
 * 示例 1：<br>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4<br>
 * 输出：12.75<br>
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75<br>
 * ------------------<br>
 * 示例 2：<br>
 * 输入：nums = [5], k = 1<br>
 * 输出：5.00000<br>
 */
public class LeetCode75_643_子数组最大平均数I {

    public double findMaxAverage(int[] nums, int k) {
        // 定义指针
        int left = 0, right = left + k - 1;
        double result = 0;
        double currentAvg = 0;
        // 先计算第一波的值，给result加上初始值
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        result = sum / k;
        right = right + 1;
        left = left + 1;
        while (right < nums.length) {
            System.out.println("当前指针：" + left + "," + right);
            sum = sum + nums[right] - nums[left - 1];
            System.out.println("当前计算总值" + sum);
            currentAvg = sum / k;
            System.out.println("当前计算平均值" + currentAvg);
            result = Math.max(result, currentAvg);
            left++;
            right = left + k - 1;
            System.out.println();
        }
        System.out.println("结果？");
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode75_643_子数组最大平均数I().findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
