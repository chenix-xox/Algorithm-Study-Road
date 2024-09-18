package utils;

import model.ListNode;

import java.util.Stack;

/**
 * 链表工具类
 *
 * @author Chenix
 * @create_date 2024/3/26 18:35
 */
public class LinkListUtils {

    /**
     * 打印链表
     * @param head
     */
    public static void printLinkList(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }

    /**
     * 循环打印栈
     *
     */
    public static <E> void printStack(Stack<E> stack){
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
