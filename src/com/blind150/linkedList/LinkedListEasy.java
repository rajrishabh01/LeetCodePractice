package com.blind150.linkedList;

import com.ds.linkedLists.MyLinkedList;

public class LinkedListEasy {

    public static void main(String[] args) {
        //Reverse a LL
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtIndex(1, 4);
        list.addAtIndex(2, 6);
        list.addAtIndex(3, 44);
        list.addAtIndex(4, 5);
        list.addAtIndex(5, 46);
        list.showLinkedList();
        //reverseList(list.getNode(0));
        list.showLinkedList();

        MyLinkedList list2 = new MyLinkedList();
        list2.addAtHead(1);
        list2.addAtIndex(1, 2);
        list2.addAtIndex(2, 3);
        list2.addAtIndex(3, 4);
        list2.addAtIndex(4, 55);
        list2.addAtIndex(5, 24);
        list2.showLinkedList();
        mergedSLL(list.getNode(0), list2.getNode(0));
    }

    //Merge 2 Sorted LL
    private static MyLinkedList.Node mergedSLL(MyLinkedList.Node head1, MyLinkedList.Node head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        MyLinkedList.Node dummy = new MyLinkedList.Node(0);
        MyLinkedList.Node curr = dummy;
        while(head1 !=null && head2!=null){
            if(head1.value <= head2.value){
                curr.next = head1;
                head1 = head1.next;
            } else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if(head1 != null) curr.next = head1;
        if(head2 != null) curr.next = head2;

        return dummy.next;
    }


    //Reverse an LL
    public MyLinkedList.Node reverseList(MyLinkedList.Node head) {
        MyLinkedList.Node previous = null;
        while(head != null){
            MyLinkedList.Node nextOne = head.next;
            head.next = previous;
            previous = head;
            head = nextOne;
        }

        return previous;
    }

}
