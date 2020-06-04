package com.srihari.data_structures.b_non_linear.a_binary_trees.a_binary_search_tree.b_traverse.a_dfs;

public class BSTApplication {
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);

        bst.traversePreOrder();
        bst.traverseInOrder();
        bst.traversePostOrder();
    }
}
