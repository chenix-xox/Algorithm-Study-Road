import Model.ListNode;

import java.util.HashSet;

/**
 * @author Chenix
 * @create_date 2024/4/5 1:05
 */
public class BM7_链表中环的入口结点 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        // 创建哈希set，存储不重复的结点
        HashSet<ListNode> visited = new HashSet<>();

        // 遍历该链表，存储到HashSet，如果HashSet中包含，说明有重复的，直接返回
        while (pHead.next != null){
            if (visited.contains(pHead)){
                return pHead;
            }else {
                visited.add(pHead);
            }
            pHead = pHead.next;
        }
        return null;
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
