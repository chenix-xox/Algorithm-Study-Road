package leetcode;

import java.util.Arrays;

/**
 * @author Chenix
 * @create_date 2024/4/14 12:24
 * @description
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Hot100_4_移动零 {
    public void moveZeroes(int[] nums) {
        int val = 0;
        int tail = removeVal(nums, val);
        System.out.println(tail);
        while (tail < nums.length){
            nums[tail++] = val;
        }
        System.out.println(Arrays.toString(Arrays.stream(nums).toArray()));
    }


    public static int removeVal(int[] nums,int val){
        // 双指针
        int fast = 0, slow = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                // 快指针指到的不为目标值，慢指针就需要移动了
                // 慢指针要让自己的数组内永远为 不为目标值的值
                // 因此如下
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        Hot100_4_移动零 h4 = new Hot100_4_移动零();
        h4.moveZeroes(nums);
    }
}
