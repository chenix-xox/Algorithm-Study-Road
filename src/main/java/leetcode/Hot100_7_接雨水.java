package leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenix
 * @date 2024.08.21 22:16
 * @description <a href="https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked">接雨水</a>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：需看图！！！
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class Hot100_7_接雨水 {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0;
        int sufMax = 0;

        // 思路整理：
        // step1. 左右定义两端指针
        // 得到正在移动过程中的每一端的最大值（最大高度）
        // 如果左侧当前最大高度，小于右侧当前最大高度，说明右边绝对可以挡住左侧当前水槽的水量
        // 那么使用 左侧最大值 - 左侧当前高度，即可计算当前槽位的储水量
        // 为什么 左侧最大值 - 左侧当前高度的 得到水量？
        // 因为左侧最大值表示左侧可阻拦的最大高度，拦住左边，例如左挡板最大高度为2，当前高度为0，那么当前储水量，左边可以帮你的挡住2，因为右边是必挡住的
        // 右边同理
        // 计算完当前储水量后需移动指针
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            result += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Hot100_7_接雨水().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
