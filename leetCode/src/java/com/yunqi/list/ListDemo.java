package com.yunqi.list;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yunqi
 * @createdTime: 2019-10-01
 * 描述
 */
public class ListDemo {

   static ListNode head = new ListNode(0);

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(0);
        head.next = node;
     //   ListNode reverseNode = reverseNode(node);
     //   iterationInvertLinkedList();
        printListNode(head.next);
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    // 链表插入
    public static void headInsert(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head.next;
        head.next = newNode;
    }

    // 删除结点
    public static void deleteNode(ListNode deleteNode, ListNode head) {
        // 如果删除的是尾结点，则需要遍历到尾部
        if (deleteNode.next == null) {
            ListNode newNode = head;
            while (newNode.next != deleteNode) {
                newNode = newNode.next;
            }
            newNode.next = null;
        } else {
            ListNode nextNode = deleteNode.next;
            deleteNode.value = nextNode.value;
            deleteNode.next = nextNode.next;
            nextNode.next = null;
        }
    }

    // 递归翻转链表

    public static ListNode reverseNode(ListNode node) {
        if (node.next == null) {
            return node;
        }
        //
        ListNode newNode = reverseNode(node.next);
        node.next.next = node;
        node.next = null;
        return newNode;
    }

    public static void iterationInvertLinkedList() {
        ListNode pre = head.next;
        ListNode cur = pre.next;
        pre.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = pre;
    }

    // 翻转部分链表
    public static void reverseListNode(int from, int to) throws Exception {
        ListNode fromPreNode = null;
        ListNode fromNode = null;
        ListNode toNode = null;
        ListNode toNextNode = null;
        int curIndex = 1;
        ListNode temp = head.next;
        while (temp != null) {
            if (curIndex == from - 1) {
                fromPreNode = temp;
            } else if (curIndex == from) {
                fromNode = temp;
            } else if (curIndex == to) {
                toNode = temp;
            } else if (curIndex == to + 1) {
                toNextNode = temp;
            }
            temp = temp.next;
            curIndex++;
        }
        if (fromNode == null || toNode == null) {
            throw new Exception("from 或者 to 超过 尾结点 不翻转");
        }

        ListNode pre = fromNode;
        ListNode cur = pre.next;
        pre.next = null;
        while (cur != toNextNode) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (fromPreNode != null) {
            fromPreNode.next = toNode;
        } else {
            head.next = toNode;
        }
        fromNode.next = toNextNode;

    }


    /**
     * 这样可以当找到f（n） 如果有，可以重复利用已经查过的，避免多次占用内存
     * 变态青蛙跳台阶，一次跳一个，或者一次跳2个台阶
     * @param n
     * @return
     */
    public static int f(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = f(n - 1) + f(n - 2);
        map.put(n, res);
        return res;
    }
    //非递归
    public static int fun(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre = 1;
        int next = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = pre + next;
            pre = next;
            next = res;
        }
        return res;
    }

}
