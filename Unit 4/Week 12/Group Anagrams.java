Question 4 – Group Anagrams 
Inspired by LeetCode 49 
Problem 
Given a list of strings, group strings that are anagrams of one another. 
Two strings are anagrams if they contain the same characters with the same frequencies.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, List<String>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = sc.next();
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);

            map.computeIfAbsent(key, x -> new ArrayList<>())
               .add(word);
        }

        System.out.println(new ArrayList<>(map.values()));
        sc.close();
    }
}
Input
6
eat tea tan ate nat bat
Output
[[eat, tea, ate], [tan, nat], [bat]]
