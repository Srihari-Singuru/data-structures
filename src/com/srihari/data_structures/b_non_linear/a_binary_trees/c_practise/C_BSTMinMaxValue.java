package com.srihari.data_structures.b_non_linear.a_binary_trees.c_practise;

public class C_BSTMinMaxValue {
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);

        System.out.println(bst.bstMin());
        System.out.println(bst.bstMax());
    }
}
