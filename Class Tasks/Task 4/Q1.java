Reverse a String Without Using reverse()

Problem Statement:
Given a string, write a Java program to reverse the string without using the built-in reverse() method.

Input:
Tech Mahindra
Output:
arnihdaM hceT

Concepts: Strings, loops, charAt()

// for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);//
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);
        }

        System.out.println(reversed);
    }
}

Input
Tech Mahindra
Output
arnihdaM hceT
