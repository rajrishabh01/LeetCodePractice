package com.ds.linkedLists;


public class MyLinkedListRevision {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public MyLinkedListRevision() {
        head = null;
        tail = null;
        length = 0;
    }

    public int get(int index) {
        if (index >= length) {
            return -1;
        }

        Node node = head;
        while (index > 0) {
            node = node.next;
            index--;
        }
        return node.value;
    }

    public void addAtHead(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }

        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        length++;
    }

    public void addAtTail(int value){
        if(head == null){
            addAtHead(value);
            return;
        }

        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void addAtIndex(int value, int index){
        if(index == length){
            addAtTail(value);
            return;
        }

        if(index == 0){
            addAtHead(value);
            return;
        }

        if(index > length){
            return;
        }

        Node newNode = new Node(value);
        Node node = head;
        while (null != node && index > 1){
            node = node.next;
            index--;
        }
        newNode.next = node.next;
        node.next = newNode;
        length++;
    }

    public void deleteAtIndex(int index){
        if(index >= length){
            return;
        }
        if(index == 0){
            deleteAtHead();
            return;
        }

        Node node = head;
        while (null != node && index > 1){
            node = node.next;
            index--;
        }

        node.next = node.next.next;
        if(node.next == null){
            tail = node;
        }
        length--;
    }

    public void deleteAtHead() {
        head = head.next;
        length--;
    }

}
