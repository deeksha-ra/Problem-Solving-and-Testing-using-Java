Question 3 – Top K Frequent Elements 
Inspired by LeetCode 347 
Problem 
Given an integer array and an integer K, find the K most frequently occurring elements
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        int k = sc.nextInt();
        List<Integer> list = new ArrayList<>(freq.keySet());

        list.sort((a, b) -> {
            int cmp = Integer.compare(freq.get(b), freq.get(a));
            return cmp != 0 ? cmp : Integer.compare(a, b);
        });

        System.out.println(list.subList(0, k));
        sc.close();
    }
}
Input
6
1 1 1 2 2 3
2
Output
[1, 2]
