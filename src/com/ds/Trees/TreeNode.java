package com.ds.Trees;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(){
    }

    public TreeNode(int value){
        this.val = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right){
        this.val = value;
        this.left=left;
        this.right=right;
    }
}
