package com.ds.Trees;

import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;

public class MyTree {
    //Custom Node - static
    public class MyTreeNode {
        public int val;
        public MyTreeNode left;
        public MyTreeNode right;

        //contructor of custom node
        public MyTreeNode(int value){
            this.val = value;
            left = null;
            right = null;
        }
    }

    //Tree will only have a root node
    MyTreeNode root;

    //Constructor for Tree
    public MyTree(){
        root = null;
    }

    //Insert
    public void insert(int value){
        root = addRecursive(root, value);
    }

    //recursive add
    private MyTreeNode addRecursive(MyTreeNode current, int value) {
        //Base Condition - the current node is empty
        if(current == null) return new MyTreeNode(value);

        //if the value is smaller than current node value
        if(current.val > value )
            current.left = addRecursive(current.left, value);
        //if the value is greater than current node value
        else if (current.val < value)
            current.right = addRecursive(current.right, value);
        else
            //value is already present
            return current;

        return current;
    }

    //Lookup
    public MyTreeNode lookUp(int searchedVal){
        return root = lookUpRecursive(root, searchedVal);
    }

    //recursive Lookup
    private MyTreeNode lookUpRecursive(MyTreeNode current, int value) {
        //Base Condition - the current node is empty
        if(current.val == value) return current;

        //if the value is smaller than current node value
        if(current.val > value )
            current.left = lookUpRecursive(current.left, value);
            //if the value is greater than current node value
        else if (current.val < value)
            current.right = lookUpRecursive(current.right, value);
        else
            //value is already present
            return current;

        return current;
    }

    public void readTree(){
        StringBuilder search = new StringBuilder();
        System.out.println(readTreeNode(root, search));

    }

    private String readTreeNode(MyTreeNode current, StringBuilder result) {
        if (current == null)  result.append("empty ");
        else {
            result.append(current.val + " ");
            readTreeNode(current.left, result);
            readTreeNode(current.right, result);
        }
        return result.toString();
    }
}
