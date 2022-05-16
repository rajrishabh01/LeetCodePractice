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
        //1 invertBinaryTree(tree);

        //2 Maximum Depth of a Binary Tree
        //maxDepth(tree);

        //3 Diameter of a Binary Tree
        //diameterTree(tree);
    }

    //4 Balanced Tree
    static class balTree {
        boolean result;
        public boolean isBalanced(TreeNode root) {
            result = true;
            maxDepthBal(root);
            return result;

        }

        public int maxDepthBal(TreeNode root){
            if(root == null || !result) return 0;

            int left = maxDepthBal(root.left);
            int right = maxDepthBal(root.right);

            if(Math.abs(left - right) > 1)
                result = false;

            return Math.max(left, right) +1;
        }
    }

    //3 Diameter of tree
    static class Diameter{
        int max;
        public int diameterTree(TreeNode root){
            max = 0;
            maxDepthDia(root);
            return max;
        }

        private int maxDepthDia(TreeNode root) {
            if(root == null) return 0;

            int left = maxDepthDia(root.left);
            int right = maxDepthDia(root.right);

            max = Math.max(max, left+right);

            return Math.max(left, right) +1;
        }
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
