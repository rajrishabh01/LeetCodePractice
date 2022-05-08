package com.blind150.trees;

import com.ds.Trees.MyTree;
import com.ds.Trees.TreeNode;


public class TreesEasy {
    public static void main(String[] args) {
        //1 Invert Binary Tree
        MyTree tree = new MyTree();
        tree.insert(50);
        tree.insert(75);
        tree.insert(25);
        tree.insert(30);
        tree.insert(1);
        tree.insert(80);
        tree.insert(51);

        tree.readTree();
        //invertBinaryTree(tree);

        //2 Maximum Depth of a Binary Tree
        //maxDepth(tree);
    }

    //1 Invert Binary Tree
    private static MyTree.MyTreeNode invertBinaryTree(MyTree.MyTreeNode treeNode) {
        if (treeNode == null) return null;

        MyTree.MyTreeNode left = invertBinaryTree(treeNode.left);
        MyTree.MyTreeNode right = invertBinaryTree(treeNode.right);

        treeNode.left = right;
        treeNode.right = left;

        return treeNode;
    }

    //2 Maximum Depth of a Binary Tree
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return Math.max(left, right)+1;
    }

}
