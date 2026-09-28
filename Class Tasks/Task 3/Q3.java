3. Merge Two Sorted Linked Lists
Problem Statement
You are given two singly linked lists containing integers sorted in ascending order.
Write a Java program to merge the two linked lists into one sorted linked list.
The resulting list should contain all elements from both lists.
Input Format
The first line contains an integer N.
The second line contains N sorted integers.
The third line contains an integer M.
The fourth line contains M sorted integers.
Constraints
1 ≤ N, M ≤ 100000
-10⁵ ≤ value ≤ 10⁵
Both input lists are sorted in ascending order.
Sample Input
5
10 20 30 40 50
4
15 25 35 45
Sample Output
10 15 20 25 30 35 40 45 50
Explanation
First linked list:
10 → 20 → 30 → 40 → 50
Second linked list:
15 → 25 → 35 → 45
After merging:
10 → 15 → 20 → 25 → 30 → 35 → 40 → 45 → 50
Concepts Tested:
Singly linked list, node creation, traversal, comparison, merging, references, sorted insertion.


  import java.util.*;

class Main {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null)
            tail.next = a;
        else
            tail.next = b;

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head1 = null, tail1 = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

            if (head1 == null) {
                head1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        int m = sc.nextInt();

        Node head2 = null, tail2 = null;

        for (int i = 0; i < m; i++) {
            Node newNode = new Node(sc.nextInt());

            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        Node head = merge(head1, head2);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

Input
5
10 20 30 40 50
4
15 25 35 45
Output
10 15 20 25 30 35 40 45 50
