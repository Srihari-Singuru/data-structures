package com.srihari.data_structures.b_non_linear.a_binary_trees.d_exercise;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
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
    private int size;

    public void insert(int value) {
        Node node = new Node(value);
        size++; // increasing the size

        if(root == null){
            root = node;
            return;
        }

        var current = root;
        while(true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = node;
                    return;
                }
                current = current.leftChild;
            } else{
                if(current.rightChild == null){
                    current.rightChild = node;
                    return;
                }
                current = current.rightChild;
            }
        }
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node root){
        if(root == null){
            return;
        }

        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }

    public int size(){
        return size;
    }

    public int countLeaves(){
        return countLeaves(root);
    }
    private int countLeaves(Node root){
        if(root == null){
            return 0;
        }
        if(root.leftChild == null && root.rightChild == null){
            return 1;
        }

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max(){
        if(root == null){
            throw new IllegalStateException();
        }
        return max(root);
    }
    private int max(Node root){
        // Iterative way
        /*var current = root;
        var value = current.value;
        while(current.rightChild != null){
            current = current.rightChild;
            value = current.value;
        }
        return value;*/

        // Recursive way
        if(root.rightChild == null){
            return root.value;
        }
        return max(root.rightChild);
    }

    public boolean contains(int value){
        if(root == null){
            throw new IllegalStateException();
        }
        return contains(root, value);
    }
    private boolean contains(Node root, int value){
        if(root == null){       // if value was not found
            return false;
        }
        if(value == root.value){    // if value found
            return true;
        }
        if(value < root.value){
            return contains(root.leftChild, value);
        } else {
            return contains(root.rightChild, value);
        }
    }

    public boolean areSiblings(int first, int second){
       return areSiblings(root, first, second);
    }

    private boolean areSiblings(Node root, int first, int second){
        if(root == null){
            return false;
        }
        if(root.leftChild == null || root.rightChild == null){
            return false;
        }

        return (root.leftChild.value == Math.min(first, second)
                && root.rightChild.value == Math.max(first, second))
                || areSiblings(root.leftChild, first, second)
                || areSiblings(root.rightChild, first, second);
    }

    public List<Integer> ancestors(int value){
        List<Integer> list = new ArrayList<>();
        return ancestors(root, value, list);
    }
    private List<Integer> ancestors(Node root, int value, List<Integer> list){
        if(root == null){
            list.clear();
            return list;
        }
        if(value == root.value){
            return list;
        }

        list.add(root.value);
        if(value < root.value){
            return ancestors(root.leftChild, value, list);
        } else{
            return ancestors(root.rightChild, value, list);
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}
