package datastructure.linkedlist;

public class LinkedListOpt {

    // 单链表反转
    public static Node reverse(Node list) {
        Node cur = list, pre = null;
        while(cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return null;
    }

    // 检测环
    public static boolean checkCircle(Node list) {
        if(list == null) return false;
        Node fast = list.next;
        Node slow = list;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) return true;
        }
        return false;
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        Node soldier = new Node(0, null); //利用哨兵结点简化实现难度
        Node p = soldier;

        while (l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                p.next = l1;
                l1.next = l1;
            } else {
                p.next = l2;
                l2.next = l2;
            }
            p = p.next;
        }

        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return soldier.next;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while(fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        if(fast == null) return null;
        Node slow = list, prev = null;
        while(fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if(prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }

        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;
        Node fast = list, slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node node) {
            this.data = data;
            this.next = node;
        }

        /**
         * @return the data
         */
        public int getData() {
            return data;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }
    }


}