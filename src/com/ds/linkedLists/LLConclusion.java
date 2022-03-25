package com.ds.linkedLists;

public class LLConclusion {
    public static void main(String[] args) {
        MyLinkedList linkedList1 = new MyLinkedList();
        linkedList1.addAtHead(1);
        linkedList1.addAtIndex(1, 9);
        linkedList1.addAtIndex(2, 1);
        linkedList1.showLinkedList();

        MyLinkedList linkedList2 = new MyLinkedList();
        linkedList2.addAtHead(2);
        linkedList2.addAtIndex(1, 2);
        linkedList2.addAtIndex(2, 4);
        linkedList2.showLinkedList();

        MyLinkedListChild childNodeList = new MyLinkedListChild();

        //1 Merge Two Sorted Arrays
        System.out.println("The sorted merged LLs are - " +
                sortMergedLLs(linkedList1.getNode(0), linkedList2.getNode(0)));

        //2 Add Two Numbers in LL
        System.out.println("Add two numbers from 2 LLs - " +
                addTwoNumbersLL(linkedList1.getNode(0), linkedList2.getNode(0)));

        //3 Flatten Multinode LL - Create Child Nodes later
        System.out.println("Flatter the list - " + "Insert flatten method");

    }

    //3 Flatten Multinode LL
    private static MyLinkedListChild.Node flatterMultiLevel(MyLinkedListChild.Node head) {
        if (head == null) return head;
        MyLinkedListChild.Node pointer = head;

        while (pointer != null) {
            //Till you find a child
            if (pointer.child == null) {
                pointer = pointer.next;
                continue;
            }

            //Find end of child level
            MyLinkedListChild.Node temp = pointer;
            while (temp.next != null) {
                temp = temp.next;
            }

            //Last of child level should point to previous level next
            temp.next = pointer.next;
            //Manage next of current and prev of next
            if (pointer.next != null) pointer.next.previous = temp;

            // Now Manage the child parent relationship
            pointer.next = pointer.child;
            pointer.child.previous = pointer;
            pointer.child = null;

        }

        return head;
    }

    //2 Add Two Numbers in LL
    private static MyLinkedList.Node addTwoNumbersLL(MyLinkedList.Node l1, MyLinkedList.Node l2) {
        MyLinkedList.Node dummy = new MyLinkedList.Node(0);
        MyLinkedList.Node curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.value;
                l1 = l1.next;

            }
            if (l2 != null) {
                sum += l2.value;
                l2 = l2.next;

            }

            sum += carry;
            carry = sum / 10;
            MyLinkedList.Node node = new MyLinkedList.Node(sum % 10);
            curr.next = node;
            curr = curr.next;
        }

        return dummy.next;
    }

    //1 Merge Two Sorted Arrays
    private static MyLinkedList.Node sortMergedLLs(MyLinkedList.Node l1, MyLinkedList.Node l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        MyLinkedList.Node dummy = new MyLinkedList.Node(0);
        MyLinkedList.Node curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

}
