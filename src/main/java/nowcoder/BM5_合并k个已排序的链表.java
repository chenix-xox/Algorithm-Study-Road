package nowcoder;

import Model.ListNode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Chenix
 * @create_date 2024/4/4 1:36
 */
public class BM5_合并k个已排序的链表 {
    /**
     * 自己写的合并k个升序链表
     * 缺点：时间复杂度过高
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists1 (ArrayList<ListNode> lists) {
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

    /**
     * 学习后，使用优先队列做
     *
     * @param lists ListNode类ArrayList
     * @return ListNode类
     */
    public ListNode mergeKLists2(ArrayList<ListNode> lists) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        // 创建指针指向虚拟头节点，做移动指针
        ListNode p = dummy;
        // 创建优先队列，并设置为最小堆
        // 优先队列：头部是最值，依次顺序排列
        // 此处设置的a.val-b.val，代表为最小堆
        // 即：最小的在队伍最前面，最先出来
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.size(), (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head!=null){
                pq.add(head);
            }
        }
//        for (ListNode node : pq.stream().toList()){
//            while (node.next != null){
//                System.out.println(node.val);
//                node = node.next;
//            }
//        }
//         只要队列不为空，就一直取出内容
        while (!pq.isEmpty()) {
            // 获取本论最小的链表头节点
            ListNode poll = pq.poll();
            // 加入到要返回的链表中
            p.next = poll;
            if (poll.next != null){
                // 如果本轮最小的链表头节点的下一个节点不为null
                // 就再次放入优先队列中排队
                pq.add(poll.next);
            }
            // 指针后移
            p = p.next;
        }
        return dummy;
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
        ListNode head = bm5.mergeKLists2(lists);
//        while (head.next != null){
//            head = head.next;
//            System.out.println(head.val);
//        }
//        bm5.mergeListNode(head);
    }

    /**
     * 链表排序
     *
     * @param listNode
     */
    public void mergeListNode(ListNode listNode) {
        ListNode cur = listNode,tail = null;
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
            // 尾指针移到当前位置（即本轮最大的元素的位置）
            tail = cur;
            // 当前指针 移到头部去，从头开始继续比较
            cur = listNode;
        }
        while (listNode.next != null) {
            listNode = listNode.next;
            System.out.println(listNode.val);
        }
    }
}
