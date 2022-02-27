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
        System.out.println("This linked list is a cycle - " + nodeLinkedCycle(linkedList.getNode(0)));

    }

    private static MyLinkedList.Node nodeLinkedCycle(MyLinkedList.Node head) {
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
                while(tortoise != hare){
                    tortoise = tortoise.next;
                    hare = hare.next;
                }
                return tortoise;
            }
        }

        return null;
    }

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