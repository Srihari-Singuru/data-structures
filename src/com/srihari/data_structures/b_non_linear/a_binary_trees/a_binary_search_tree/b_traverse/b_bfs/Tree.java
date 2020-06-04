package com.srihari.data_structures.b_non_linear.a_binary_trees.a_binary_search_tree.b_traverse.b_bfs;

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

    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }
    private void traverseInOrder(Node root){
        if(root == null){
            return;
        }

        // This will print the values in ascending order (exchange the left with right for descending order)
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }
    private void traversePostOrder(Node root){
        if(root == null){
            return;
        }

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }
    private int height(Node root){      // height of a tree - (1 + max(height(left), height(right)) - This is like postOrderTraversal
        if(root == null){   // null child
            return -1;
        }
        if(root.leftChild == null && root.rightChild == null){      // leaf child
            return 0;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));   // height
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
