import Model.ListNode;

import java.util.ArrayList;

/**
 * @author Chenix
 * @create_date 2024/4/4 1:36
 */
public class BM5_合并k个已排序的链表 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        ListNode head = new ListNode();
        head.next = lists.get(0);
        int i = 0;
        while (true){
//            System.out.println(i);
            ListNode listNode = lists.get(i);
            while (listNode.next != null){
                listNode = listNode.next;
//                System.out.println(listNode.val);
            }
            if (i == lists.size() - 1){
                listNode.next = null;
                break;
            }
            listNode.next = lists.get(++i);
        }

        return head;
    }

    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(2);
        listNode2.next.next = new ListNode(3);
        listNode2.next.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(1);
        listNode3.next = new ListNode(2);
        listNode3.next.next = new ListNode(3);
        listNode3.next.next.next = new ListNode(4);

        lists.add(listNode);
        lists.add(listNode2);
        lists.add(listNode3);

        BM5_合并k个已排序的链表 bm5 = new BM5_合并k个已排序的链表();
        ListNode head = bm5.mergeKLists(lists);
//        while (head.next != null){
//            head = head.next;
//            System.out.println(head.val);
//        }
        bm5.mergeListNode(head);
    }

    /**
     * 链表排序
     *
     * @param listNode
     */
    public void mergeListNode(ListNode listNode) {
        ListNode cur = null,tail = null;
        cur = listNode;
        while (cur.next != tail) {
            while (cur.next != tail){
                if (cur.val >= cur.next.val) {
                    int temp = cur.val;
                    cur.val = cur.next.val;
                    cur.next.val = temp;
                }
                cur = cur.next;
            }

            // 说明一轮排序完毕，进行下一轮
            tail = cur;
            cur = listNode;
        }
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}
