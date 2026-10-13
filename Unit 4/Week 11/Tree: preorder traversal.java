QUESTION 7 – TREE: PREORDER TRAVERSAL 
Inspired by HackerRank 
Problem 
Complete the function in the editor below, which has parameter: a pointer to the root of a 
binary tree. It must print the values in the tree's preorder traversal as a single line of space
separated values. 
Input Format 
Our test code passes the root node of a binary tree to the preOrder function. 
Constraints 
Nodes in the tree 
Output Format 
Print the tree's preorder traversal as a single line of space-separated values. 


import java.util.*;

public class Main {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            if (value != -1) {
                nodes[i] = new Node(value);
            }
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < n) nodes[i].left = nodes[left];
                if (right < n) nodes[i].right = nodes[right];
            }
        }

        if (n > 0) preOrder(nodes[0]);
        System.out.println();
        sc.close();
    }
}
Input
7
1 2 3 4 5 6 7
Output
1 2 4 5 3 6 7
