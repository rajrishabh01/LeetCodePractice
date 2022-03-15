package com.ds.linkedLists;

public class DoublyLinkedList {
    static class Node{
        int val;
        Node next;
        Node previous;

        Node(int value) {
            this.val = value;
        }
    }

    Node head;
    Node tail;
    int size;
    public DoublyLinkedList(){
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.previous = head;
    }

    public int getVal(int index){
        if(index < 0 || index > size){
            return -1;
        }
        Node node = head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }
}


