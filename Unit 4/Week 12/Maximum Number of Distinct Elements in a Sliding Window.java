Question 6 – Maximum Number of Distinct Elements in a Sliding Window 
Problem 
Given an array and a window size K, find the maximum number of distinct elements present 
in any contiguous window of size K.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        if (k < 1 || k > n) {
            System.out.println("Invalid window size");
            sc.close();
            return;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int distinct = 0;
        int maxDistinct = 0;

        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

            if (freq.get(arr[i]) == 1) {
                distinct++;
            }

            if (i >= k) {
                int removed = arr[i - k];
                freq.put(removed, freq.get(removed) - 1);

                if (freq.get(removed) == 0) {
                    freq.remove(removed);
                    distinct--;
                }
            }

            if (i >= k - 1) {
                maxDistinct = Math.max(maxDistinct, distinct);
            }
        }

        System.out.println(maxDistinct);
        sc.close();
    }
}
Input
7
1 2 1 3 4 2 3
4
Output
4
