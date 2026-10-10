Question: 9 - Student Marks Using HashMap
Scenario: 
A teacher wants to store the marks of students using their roll numbers as keys. Write a Java 
program to display the marks of a particular student

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> students = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter roll number and marks: ");
            int roll = sc.nextInt();
            int mark = sc.nextInt();
            students.put(roll, mark);
        }

        System.out.print("Enter roll number to search: ");
        int searchRoll = sc.nextInt();

        if (students.containsKey(searchRoll)) {
            System.out.println("Student Marks: " + students.get(searchRoll));
        } else {
            System.out.println("Student not found");
        }

        sc.close();
    }
}


3
101 85
102 90
103 78
102

  
Student Marks: 90
