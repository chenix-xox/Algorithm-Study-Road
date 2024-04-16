package leetcode;

import Model.ListNode;

/**
 * @author Chenix
 * @create_date 2024/4/14 12:24
 * @description
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Hot100_4_移动零 {
    public void moveZeroes(int[] nums) {
        ListNode head = new ListNode(-1);
        ListNode numHead = new ListNode(-1);
        head.next = numHead;
        for (int num : nums){
            numHead.next = new ListNode(num);
            numHead = numHead.next;
        }

        while (head.next != null){
            System.out.println(head.val);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        Hot100_4_移动零 h4 = new Hot100_4_移动零();
        h4.moveZeroes(nums);
    }
}
