package nowcoder;

import model.ListNode;
import utils.LinkListUtils;

/**
 * @author Chenix
 * @create_date 2024/3/26 17:59
 * @description 牛客 BM1 反转链表
 */
public class BM2_链表内指定区间反转 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (m == n) {
            return head;
        }

        // 思路，取出要反转的链表
        ListNode node = new ListNode(-1);
        node.next = head;

        // 先整一个前指针，指到要被反转部分的最左侧的前一个
        // 用于接反转后的链表
        ListNode pre = node;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
//        System.out.println(pre.val);

        // 再来个右指针，指到要被反转部分的最右侧
        ListNode rightNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rightNode = rightNode.next;
        }

        // 左指针，知道被反转部分的最左侧
        ListNode leftNode = pre.next;

        // 后指针，为被反转部分的后一个节点
        ListNode after = rightNode.next;

        // 切断要被反转的部分
        // 即：使前指针的下一个元素为null
        // 被反转部分的下一个元素为null
        pre.next = null;
        rightNode.next = null;

        // 这样就分成了三个部分
        // pre ~ left - 1
        // left ~ right
        // after ~ ...

        // 开始反转截取出的部分
        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = after;
        return node.next;

//
//        System.out.println(leftNode.val);
//        System.out.println(rightNode.val);
//        System.out.println(after.val);
//        System.out.println(leftNode.val);
//        LinkListUtils.printLinkList(leftNode);
    }

    //反转局部链表
    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            //Cur_next 指向cur节点的下一个节点
            ListNode Cur_next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = Cur_next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        BM2_链表内指定区间反转 bm2 = new BM2_链表内指定区间反转();
        // 取出3 4 5
        LinkListUtils.printLinkList(bm2.reverseBetween(listNode, 3, 5));
    }
}
