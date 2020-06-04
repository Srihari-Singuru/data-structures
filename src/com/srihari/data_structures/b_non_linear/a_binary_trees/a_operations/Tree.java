package com.srihari.data_structures.b_non_linear.a_binary_trees.a_operations;

public class Tree {
    private static class Node {
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    private Node root;

    public void insert(int value){
        var node = new Node(value);

        if(root == null) {
            root = node;
            return;
        }

        var current = root;
        while(true) {
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if(current.rightChild == null){
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        var current = root;
        while(current != null) {    // cannot use while(true), because the element may not exist in the BST
            if(value == current.value){
                return true;
            }

            if(value < current.value){
                current = current.leftChild;
            } else{
                current = current.rightChild;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
