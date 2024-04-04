import Model.ListNode;

/**
 * 牛客面试Top101其一
 * @author Chenix
 * @create_date 2024/4/5 0:53
 */
public class BM6_判断链表是否有环 {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        // 定义快慢指针
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = listNode.next;
        while (listNode.next != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
