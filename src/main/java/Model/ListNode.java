package Model;

/**
 * @author Chenix
 * 链表：存值 及 下一个链表
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {

    }
}
