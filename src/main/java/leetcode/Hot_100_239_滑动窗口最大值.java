package leetcode;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenix
 * @date 2024.09.18 22:39
 * @description 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * ========================
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * ========================
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class Hot_100_239_滑动窗口最大值 {
    // 单调队列
    static class MonoQueue {
        LinkedList<Integer> maxQueue = new LinkedList<>();

        public void push(int n) {
            // 最后的元素比当前push的小，那么就移除最后一个元素
            while (!maxQueue.isEmpty() && maxQueue.getLast() < n) {
                maxQueue.pollLast();
            }
            // 直到遇到比自己大的，就加入尾部。此时就可以保证是由大到小的单调递减队列
            maxQueue.addLast(n);
        }

        // 移除最大值使用
        public void pop(int n) {
            // 如果要弹出的元素是队列的第一个元素，那么就移除。
            if (n == maxQueue.getFirst()) {
                maxQueue.pollFirst();
            }
        }

        public int max() {
            // 第一个就是最大的
            return maxQueue.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 定义单调队列做窗口
        MonoQueue window = new MonoQueue();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                window.push(nums[i]);
            } else {
                window.push(nums[i]);
                result.add(window.max());
                window.pop(nums[i - k + 1]);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++){
            res[i] = result.get(i);
        }

        return res;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k > nums.length) {
            int max = nums[0];
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return new int[]{max};
        }
        int[] result = new int[nums.length - k + 1];
        // 左指针
        int left = 0;
        // 右指针
        int right = k - 1;
        while (right < nums.length) {
            int max = nums[left];
            for (int i = left; i <= right; i++) {
                max = Math.max(max, nums[i]);
            }
            result[left++] = max;
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = new Hot_100_239_滑动窗口最大值().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
