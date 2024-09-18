package nowcoder;

import model.ListNode;

import java.util.*;


/**
 * @author Chenix
 * @create_date 2024-03-26
 * @description 牛客 BM1 反转链表
 */
public class BM1_反转链表 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode ReverseList(ListNode head) {
        // 定义一个栈，放链表
        // 栈是先进后出，把链表的内容依次放入栈中
        // 创建新链表，从栈中取出来，就是逆向的了
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        // 栈为空，说明链表为空
        // 链表为空返回null
        if (stack.isEmpty()) {
            return null;
        }

//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop().val);
//        }
        ListNode newList = stack.pop();
        ListNode result = newList;
//        System.out.println(newList.val);
        while (!stack.isEmpty()){
            newList.next = stack.pop();
            newList = newList.next;
//            System.out.println(newList.val);
        }
        newList.next = null;

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 1;
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode listNode1 = new BM1_反转链表().ReverseList(listNode);
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
//        ListNode head = listNode;
//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }
//        System.out.println(listNode.next.next.val);
    }
}