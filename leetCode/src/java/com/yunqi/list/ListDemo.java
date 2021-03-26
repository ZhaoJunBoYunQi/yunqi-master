package com.yunqi.list;

import com.sun.org.apache.xerces.internal.util.SAXLocatorWrapper;
import sun.security.util.Length;

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

    public static void main(String[] args) throws Exception {
        ListNode node = new ListNode(4);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(0);
        head.next = node;
     //   ListNode reverseNode = reverseNode(node);
     //   iterationInvertLinkedList();
     //    reverseListNode(1, 4);
     //   reverseKListNode(2);
     //   ListNode middleNode = findKthToTail(3);
      //  reverseKthToTail(3);
        ListNode listNode = detectCrossNode();
        System.out.println(listNode);
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

    // 以k为一组，进行链表翻转
    public static void reverseKListNode(int k) {
        ListNode startKPre = head; // 链表的前置节点
        ListNode startK = null;
        ListNode endK = null;

        ListNode temp = head.next;
        int step = 0;
        while (temp != null) {
            ListNode tempNext = temp.next;
            if (step == 0) {
                startK = temp;
                step++;
            } else if (step == k - 1) {
                endK = temp;
                ListNode pre = startK;
                ListNode cur = startK.next;
                if (cur == null) {
                    break;
                }
                ListNode endKNext = endK.next;
                while (cur != endKNext) {
                    ListNode next = pre.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                startKPre.next = endK;
                startK.next = endKNext;

                // 当前k个一组翻转完毕，进行下一组的翻转
                startKPre = startK;
                step = 0;
            }else {
                step++;
            }
            temp = tempNext;
        }
    }

    // 获取链表的中间结点
    public static ListNode findMiddleNode() {
        ListNode node = head.next;
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        node = head.next;
        int middle = length/2;
        while (middle > 0) {
            node = node.next;
            middle--;
        }
        return node;
    }

    // 方法二 快慢指针 当链表长度为奇数时，fast=null时，slow为中间结点，
    // 当为偶数时，fast.next = null slow为中间结点
    public static ListNode findMiddleNode2() {
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 求倒数第k个结点
    public static ListNode findKthToTail(int k) {
        ListNode slow = head.next;
        ListNode fast = head.next;
        int len = k;
        while (len > 0 && fast != null) {
            fast = fast.next;
            len--;
        }
        if (fast == null) {
            return null;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 给定一个单链表，设计一个算法实现链表向右旋转 K 个位置。
    // 举例： 给定 head->1->2->3->4->5->NULL, K=3,右旋后即为 head->3->4->5–>1->2->NULL
    public static void reverseKthToTail(int k) {
        // 1、先找到 倒数k+1 结点
        // 2、然后让head指向 k结点
        // 3、让 last结点指向 head。next
        ListNode kPreNode = findKthToTail(k + 1);
        ListNode kNode = kPreNode.next;
        ListNode headNext = head.next;
        kPreNode.next = null;
        head.next = kNode;
        ListNode temp = kNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = headNext;

    }

    // 找到两个链表相交的部分
    public static ListNode detectCommonNode(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        while (node1 != node2) {
            node1 = node1 == null ? node2 : node1.next;
            node2 = node2 == null ? node1 : node1.next;
        }
        return node1;
    }

    // 判断链表是否有环，快的和慢的一起走，快的走两步每次，如果，相等则说明有环
    public static ListNode detectCrossNode() {
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == null) {
                return null;
            }
            if (fast.value == slow.value) {
                return slow;
            }
        }
        return null;
    }

    // 获得环形入口
    public static ListNode getRingEntryNode() {
        ListNode node = detectCrossNode();
        if (node == null) {
            return null;
        }
        ListNode temp1 = node;
        ListNode temp2 = head.next;
        while (temp1.value != temp2.value) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }



}
