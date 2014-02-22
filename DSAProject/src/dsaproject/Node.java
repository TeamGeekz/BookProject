package dsaproject;

public class Node {

    Book data;   // Realistic case, this could be quite large
    int height; // Height of THIS NODE
    int size;   // Number of nodes in this (sub)tree
    int util;   // Generic utility area for an int value
    Node left, // "<" subtree
            right;  // ">" subtree

    Node(Book data) // Constructor for leaf node
    {
        this.data = data;
        this.height = 0;         // Leaf node has height zero
        this.size = 1;
        this.left = null;
        this.right = null;
    }

}
