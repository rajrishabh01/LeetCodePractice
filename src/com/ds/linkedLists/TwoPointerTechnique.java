package com.ds.linkedLists;

public class TwoPointerTechnique {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        //Set up Linked List
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(14);
        linkedList.addAtIndex(1, 0);
        linkedList.addAtIndex(2, 46);
        linkedList.showLinkedList();

        //1 Linked List Cycle
        MyLinkedList.Node cycleFirst = linkedList.getNode(2);
        cycleFirst.next = linkedList.getNode(0);

        System.out.println("This linked list is a cycle - " + checkForLinkedCycle(linkedList.getNode(0)));

        //2 Find the Linked List cycle source node
        System.out.println("This linked list is a cycle - " + nodeLinkedCycle(linkedList.getNode(0)));

        // Set up 2 LL for Intersection problem (3) - Fix this
        MyLinkedList linkedListA = new MyLinkedList();
        // 14 , 6, 8, 0 - A
        // 1, 8, 0 - B
        linkedListA.addAtHead(14);
        linkedListA.addAtIndex(1, 6);
        linkedListA.addAtIndex(2, 8);
        linkedListA.addAtIndex(3, 0);
        linkedListA.showLinkedList();

        MyLinkedList linkedListB = new MyLinkedList();
        linkedListB.addAtHead(1);
        linkedListB.addAtIndex(1, 8);
        linkedListB.addAtIndex(2, 0);

        linkedListB.showLinkedList();

        System.out.println("The lists are intersecting at node with value " + intersectionLLNode(linkedListA.getNode(0), linkedListB.getNode(0)));

        // 4 Remove Nth node from end of list
        System.out.println("Before removing n " + " After removing Nth from end" + removeNthFromEnd(linkedListA.getNode(0), 2));
    }

    // 4 Remove Nth node from end of list
    public static MyLinkedList.Node removeNthFromEnd(MyLinkedList.Node head, int n) {
        MyLinkedList.Node dummy = new MyLinkedList.Node(0);
        dummy.next = head;
        MyLinkedList.Node slow = dummy;
        MyLinkedList.Node fast = dummy;
        slow.next = head;

        //start a gap
        for(int i=1; i<=n+1; i++){
            fast = fast.next;
        }

        //maintain the gap and iterate till fast is null
        while(fast !=null){
            slow = slow.next;
            fast = fast.next;
        }

        //now skip the Nth element and return header
        slow.next = slow.next.next;
        return dummy.next;
    }

    // 3 Intersection of Nodes from 2 LLs
    public static MyLinkedList.Node intersectionLLNode(MyLinkedList.Node headA, MyLinkedList.Node headB) {
        if (headA == null || headB == null) return null;

        MyLinkedList.Node a = headA;
        MyLinkedList.Node b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    //2 Find the Linked List cycle source node
    public static MyLinkedList.Node nodeLinkedCycle(MyLinkedList.Node head) {
        if (head == null) {
            return null;
        }

        MyLinkedList.Node tortoise = head;
        MyLinkedList.Node hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == tortoise) {
                tortoise = head;
                while (tortoise != hare) {
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                return tortoise;
            }
        }

        return null;
    }

    //1 Linked List Cycle
    public static boolean checkForLinkedCycle(MyLinkedList.Node head) {
        if (head == null) {
            return false;
        }

        MyLinkedList.Node tortoise = head;
        MyLinkedList.Node hare = head;

        while (tortoise != null && hare != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (hare == tortoise) return true;
        }

        return false;
    }


}