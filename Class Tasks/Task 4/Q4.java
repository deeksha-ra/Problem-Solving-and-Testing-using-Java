Move All Zeros to the End
Problem Statement:
Given an integer array, move all 0s to the end while maintaining the relative order of non-zero elements.
Input:
7
0 5 0 3 8 0 2
Output:
5 3 8 2 0 0 0
Requirement:
Do this without creating another array.
Concepts: Arrays, two-pointer technique, in-place modification, problem solving.
  import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

Input
7
0 5 0 3 8 0 2
Output
5 3 8 2 0 0 0
