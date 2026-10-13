QUESTION 3 – DEGREE OF ARRAY 
Inspired by HackerRank 
Problem 
Given a non-empty array of non-negative integers nums, the degree of this array is defined as 
the maximum frequency of any one of its elements. 
Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has 
the same degree as nums. 


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int degree = 0, minLength = n;

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            first.putIfAbsent(nums[i], i);
            degree = Math.max(degree, freq.get(nums[i]));
        }

        for (int i = 0; i < n; i++) {
            if (freq.get(nums[i]) == degree) {
                minLength = Math.min(minLength,
                    i - first.get(nums[i]) + 1);
            }
        }

        System.out.println(minLength);
        sc.close();
    }
}
Input
6
1 2 2 3 1 4
Output
2
