package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Chenix
 * @create_date 2024/4/14 11:42
 * @description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Hot100_3_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int res = 0;

        for (int num : numsSet) {
            // 找最小的数字
            if (numsSet.contains(num - 1)) {
                // 如果set集合中还含有比当前数字更小的，就跳过此次循环
                // 直到找到最小的那个，作为子序列初始第一个
                continue;
            }

            // 到这，就是初始数字了
            // 开始找向上计数
            // 初始步长
            int curLen = 1;

            // 如果当前集合包含当前数字 + 当前长度，说明确有这个数字，长度增加
            while (numsSet.contains(num + curLen)) {
                curLen++;
            }
            res = Math.max(curLen, res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Hot100_3_最长连续序列 h3 = new Hot100_3_最长连续序列();
        h3.longestConsecutive(nums);
    }
}
