Remove Duplicate Characters
Problem Statement:
Given a string, remove duplicate characters while maintaining the original order of occurrence.
Input:
programming
Output:
progamin
Concepts: LinkedHashSet, StringBuilder, character processing.

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        StringBuilder result = new StringBuilder();

        for (char ch : set) {
            result.append(ch);
        }

        System.out.println(result);
    }
}

Input
programming
Output
progamin
