package com.blind150.linkedList;

import com.ds.linkedLists.MyLinkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListEasy {

    public static void main(String[] args) {
        //Reverse a LL
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtIndex(1, 2);
        list.addAtIndex(2, 3);
        list.addAtIndex(3, 4);
        list.addAtIndex(4, 5);
        list.addAtIndex(5, 4);
        list.showLinkedList();
        //reverseList(list.getNode(0));
        list.showLinkedList();
    }

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
