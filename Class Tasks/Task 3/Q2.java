2. Detect a Cycle in a Linked List
Problem Statement
You are given a singly linked list. The last node may point back to one of the previous nodes, creating a cycle.
Write a Java program to determine whether the linked list contains a cycle.
Use Floyd's Cycle Detection Algorithm (slow and fast pointers).
Input Format
The first line contains an integer N.
The second line contains N space-separated integers.
The third line contains an integer P.
P represents the position of the node to which the last node points.
P = -1 means the last node points to NULL.
0 ≤ P < N means the last node points to the node at index P.
Constraints
1 ≤ N ≤ 100000
-10⁵ ≤ value ≤ 10⁵
Sample Input
5
10 20 30 40 50
2
Sample Output
Cycle Detected
Explanation
The linked list is:
10 → 20 → 30 → 40 → 50
          ↑         |
          |_________|
The last node 50 points back to the node at index 2, which contains 30.
Therefore, a cycle exists.
For:
5
10 20 30 40 50
-1
Output:
No Cycle
Concepts Tested:
Singly linked list, node references, slow pointer, fast pointer, cycle detection, Floyd's algorithm.
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
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.nextInt());
        }

        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        int p = sc.nextInt();

        if (p != -1) {
            nodes[n - 1].next = nodes[p];
        }

        Node slow = nodes[0];
        Node fast = nodes[0];

        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle)
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}

Input:

5
10 20 30 40 50
-1

Output:

No Cycle
