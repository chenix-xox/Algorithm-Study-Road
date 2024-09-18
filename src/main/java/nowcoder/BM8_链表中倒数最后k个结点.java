package nowcoder;

import model.ListNode;

/**
 * @author Chenix
 * @create_date 2024/4/5 1:26
 */
public class BM8_链表中倒数最后k个结点 {
    /**
     * 其他思路：快慢指针，快指针先行k步
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null){
            return null;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        int i = 1;
        // 统计链表长度
        while (pHead.next != null){
            pHead = pHead.next;
            i++;
        }
        // 链表长度小于倒数，则返回
        if (i < k){
            return null;
        }else if(i == k){
            // 说明就是从头开始！
            return head.next;
        }

        // 链表总长度，减去 从哪个倒数开始，则为倒数开始的下标
        int findFirst = i - k;
        int n = 1;
        head = head.next;
        while (head.next != null) {
            if (n == findFirst){
                break;
            }
            head = head.next;
            n++;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        BM8_链表中倒数最后k个结点 bm8 = new BM8_链表中倒数最后k个结点();
        ListNode resultNode = bm8.FindKthToTail(listNode, 2);
        if (resultNode != null){

            System.out.println(resultNode.val);;
        }else {
            System.out.println("null");
        }
    }
}
