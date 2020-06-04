package com.srihari.data_structures.b_non_linear.a_binary_trees.excercise;

public class D_BinaryTreeEquality {
    public static void main(String[] args) {
        Tree bst1 = new Tree();
        bst1.insert(7);
        bst1.insert(4);
        bst1.insert(9);
        bst1.insert(1);
        bst1.insert(6);
        bst1.insert(8);
        bst1.insert(10);

        Tree bst2 = new Tree();
        bst2.insert(4);
        bst2.insert(9);
        bst2.insert(1);
        bst2.insert(7);
        bst2.insert(6);
        bst2.insert(8);
        //bst2.insert(10);

        System.out.println(bst1.isTreeEqual(bst2));
    }
}
