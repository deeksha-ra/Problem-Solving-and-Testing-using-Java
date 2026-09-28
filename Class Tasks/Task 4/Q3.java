Count the Frequency of Each Element in an Array
Problem Statement:
Given an integer array, count how many times each element occurs.
Input:
2 3 2 5 3 2 4 5
Output:
2 -> 3
3 -> 2
5 -> 2
4 -> 1
Concepts: Arrays, HashMap, frequency counting

  import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (String s : input) {
            int num = Integer.parseInt(s);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

Input
2 3 2 5 3 2 4 5
Output
2 -> 3
3 -> 2
5 -> 2
4 -> 1
