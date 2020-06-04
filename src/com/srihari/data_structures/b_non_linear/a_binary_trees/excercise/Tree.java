package com.srihari.data_structures.b_non_linear.a_binary_trees.excercise;

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
        if(isLeaf(root)){      // leaf child
            return 0;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));   // height
    }

    // If tree is not Binary Search Tree
    // O(n)
    public int min(){
        return min(root);
    }
    private int min(Node root){ // We need to compare the left value and right value and then propagate till root, so it is also kind of post order traversal
        if(root == null){
            throw new IllegalStateException();
        }
        if(isLeaf(root)){
            return root.value;
        }
        return Math.min(
                root.value,
                Math.min(
                        min(root.leftChild),
                        min(root.rightChild)
                )
        );
    }

    // If tree is Binary Search Tree
    //O(log(n))
    public int bstMin(){
        return bstMin(root);
    }
    private int bstMin(Node root){
        if(root == null){
            throw  new IllegalStateException();
        }

        var current = root; // do not loose root
        int value = current.value;

        while (current.leftChild != null){
            current = current.leftChild;
            value = current.value;
        }
        return value;
    }

    public int bstMax(){
        return bstMax(root);
    }
    private int bstMax(Node root){
        if(root == null){
            throw new IllegalStateException();
        }

        var current = root;
        var value = current.value;

        while (current.rightChild != null){
            current = current.rightChild;
            value = current.value;
        }
        return value;
    }

    public boolean isTreeEqual(Tree other){
        if(other == null){
            return false;
        }
        return isTreeEqual(this.root, other.root);
    }
    private boolean isTreeEqual(Node first, Node second){
        if(first == null && second == null){
            return true;
        }
        if(first != null && second != null){        // this is pre-order traversal
            return first.value == second.value
                    && isTreeEqual(first.leftChild, second.leftChild)
                    && isTreeEqual(first.rightChild, second.rightChild);
        }
        return false;
    }

    private boolean isLeaf(Node node){
        return node.leftChild == null && node.rightChild == null;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
