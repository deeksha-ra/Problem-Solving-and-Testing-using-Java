First Non-Repeating Character

Problem Statement:
Given a string, find the first character that occurs only once. If no such character exists, print -1.

Input:
swiss

Output:
w

Constraints:
1 ≤ length of string ≤ 10⁵
String contains lowercase English letters.

Concepts: HashMap, character frequency, string traversal

  import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                System.out.println(ch);
                return;
            }
        }

        System.out.println(-1);
    }
}
Input
swiss
Output
w
