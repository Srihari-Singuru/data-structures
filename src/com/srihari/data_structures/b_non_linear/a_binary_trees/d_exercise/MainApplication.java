package com.srihari.data_structures.b_non_linear.a_binary_trees.d_exercise;

public class MainApplication {
    public static void main(String[] args) {
        var binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(20);
        binarySearchTree.insert(10);
        binarySearchTree.insert(30);
        binarySearchTree.insert(6);
        binarySearchTree.insert(14);
        binarySearchTree.insert(24);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(26);

        //System.out.println(binarySearchTree);
        //binarySearchTree.preOrderTraversal();
        //binarySearchTree.inOrderTraversal();
        //binarySearchTree.postOrderTraversal();
        //System.out.println(binarySearchTree.size());
        //System.out.println(binarySearchTree.countLeaves());
        //System.out.println(binarySearchTree.max());
        System.out.println(binarySearchTree.contains(24));
    }
}
