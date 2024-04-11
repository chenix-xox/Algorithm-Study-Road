package nowcoder;

import Model.ListNode;
import utils.LinkListUtils;

/**
 * @author Chenix
 * @create_date 2024/3/27 1:31
 * @description 牛客 BM4 合并两个排序的链表
 */
public class BM4_合并两个排序的链表 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead1 ListNode类
     * @param pHead2 ListNode类
     * @return ListNode类
     */
    public ListNode Merge(ListNode pHead1, ListNode pHead2) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead1;
        while (pHead1.next != null) {
            pHead1 = pHead1.next;
        }
        pHead1.next = pHead2;
        LinkListUtils.printLinkList(dummy);
        return bubbleSort(dummy.next);
    }

    //冒泡排序
    public static ListNode bubbleSort(ListNode head) {
        if (head == null || head.next == null)  //链表为空或者仅有单个结点
            return head;

        ListNode cur = null, tail = null;

        cur = head;

        while (cur.next != tail) {
            while (cur.next != tail) {
                if (cur.val > cur.next.val) {
                    int tmp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = tmp;
                }
                cur = cur.next;
            }

            tail = cur;  //下一次遍历的尾结点是当前结点(仔细琢磨一下里面的道道)
            cur = head;     //遍历起始结点重置为头结点
        }

        return head;


    }

    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        ListNode pHead2 = new ListNode(2);

        pHead1.next = new ListNode(3);
        pHead2.next = new ListNode(4);
        pHead1.next.next = new ListNode(5);
        pHead2.next.next = new ListNode(6);
        pHead1.next.next.next = new ListNode(7);
        pHead2.next.next.next = new ListNode(18);
        pHead1.next.next.next.next = new ListNode(9);
        pHead2.next.next.next.next = new ListNode(21);
        BM4_合并两个排序的链表 bm4_合并两个排序的链表 = new BM4_合并两个排序的链表();
        bm4_合并两个排序的链表.Merge(pHead1, pHead2);
    }
}
