1. Reverse a Singly Linked List
Problem Statement
You are given a singly linked list containing N integers. Write a Java program to reverse the linked list without creating a new linked list.
Input Format
The first line contains an integer N.
The second line contains N space-separated integers.
Constraints
1 ≤ N ≤ 100000
-10⁵ ≤ value ≤ 10⁵
Output Format
Print the elements of the linked list after reversing it.
Sample Input
5
10 20 30 40 50
Sample Output
50 40 30 20 10
Explanation
Original list:
10 → 20 → 30 → 40 → 50 → NULL
After reversal:
50 → 40 → 30 → 20 → 10 → NULL
Concepts Tested:
Node, singly linked list, pointers/references, traversal, reversal, next reference.

  import java.util.*;

class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
Input
5
10 20 30 40 50
Output
50 40 30 20 10
