package com.ds.linkedLists;

public class LinkedListClassics {
    public static void main(String[] args) {

        //Create a LL
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtIndex(1, 2);
        list.addAtIndex(2, 3);
        list.addAtIndex(3, 4);
        list.addAtIndex(4, 5);
        list.showLinkedList();

        //1 Reverse the LL
        System.out.println("Reversing the given list -" + reverseLL(list.getNode(0)));

    }

    // Reverse LL - Iterative
    private static MyLinkedList.Node reverseLL(MyLinkedList.Node head) {
        MyLinkedList.Node previous = null;
        while(head != null) {
            MyLinkedList.Node next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    // Reverse LL - Recursive
    private static MyLinkedList.Node reverseLLRecursive(MyLinkedList.Node head) {

        return recursiveCallLLReverse(head ,null);
    }

    private static MyLinkedList.Node recursiveCallLLReverse(MyLinkedList.Node head, MyLinkedList.Node dummy) {
        if (head == null){
            return dummy;
        }
        MyLinkedList.Node next = head.next;
        head.next = dummy;
        return recursiveCallLLReverse(next, head);
    }
}
