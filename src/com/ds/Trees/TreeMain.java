package com.ds.Trees;

public class TreeMain {
    public static void main(String[] args) {
        MyTree tree = new MyTree();
        tree.insert(14);
        tree.insert(5);
        tree.insert(16);
        tree.insert(7);
        tree.insert(22);
        tree.insert(15);

        tree.readTree();

    }
}
