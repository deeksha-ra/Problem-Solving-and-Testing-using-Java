QUESTION 8 – TWO SUM 
Problem 
Find two numbers in an array whose sum equals a target value. 
Example 
Input: nums = [2, 7, 11, 15] 
Target = 9 
Output: [0, 1] 


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                System.out.println("[" + map.get(complement)
                    + ", " + i + "]");
                sc.close();
                return;
            }

            map.put(nums[i], i);
        }

        sc.close();
    }
}
Input
4
2 7 11 15
9
Output
[0, 1]
