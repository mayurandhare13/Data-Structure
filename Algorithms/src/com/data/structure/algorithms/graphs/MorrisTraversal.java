package com.data.structure.algorithms.graphs;

public class MorrisTraversal {
    public static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    public void inorder(Node root) {
        Node current = root;
        while(current != null) {
            // left null | print node | go right
            if(current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                // find predecessor
                Node predecessor = current.left;
                while(predecessor.right != current && predecessor.right != null)
                    predecessor = predecessor.right;

                if(predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(5);
        Node node3 = new Node(30);
        Node node4 = new Node(-1);
        Node node5 = new Node(60);
        Node node6 = new Node(7);
        Node node7 = new Node(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node5.left = node6;
        node6.right = node7;

        new MorrisTraversal().inorder(node1);
    }
}