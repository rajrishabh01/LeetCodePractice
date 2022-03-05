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
        list.addAtIndex(5, 4);
        list.showLinkedList();

        //1 Reverse the LL
        /*System.out.println("Reversing the given list -" + reverseLL(list.getNode(0)));
        list.showLinkedList();*/

        //2 Remove Linked List Element
        System.out.println("Removing the val from LL - " + removeValLL(list.getNode(0), 5));
        list.showLinkedList();
    }

    //2 Remove Linked List Element - Iterative
    private static MyLinkedList.Node removeValLL(MyLinkedList.Node head, int val) {
        if(head != null && head.value == val)
            head = head.next;

        MyLinkedList.Node pointer = head;
        while(pointer != null && pointer.next != null){
            if(pointer.next.value == val)
                pointer.next = pointer.next.next;
            else
                pointer = pointer.next;

        }
        return head;
    }

    //2 Remove Linked List Element - Recursive
    private static MyLinkedList.Node removeValLLRecursive(MyLinkedList.Node head, int removeVal) {
        if(head == null){
            return null;
        }
        MyLinkedList.Node next = removeValLLRecursive(head.next, removeVal);
        if(head.value == removeVal) return next;
        head.next = next;
        return head;
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
