package com.srihari.data_structures.b_non_linear.a_binary_trees.excercise;

public class F_NodesAtDistance {
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);

        bst.printNodesAtDistance(2);
    }
}
