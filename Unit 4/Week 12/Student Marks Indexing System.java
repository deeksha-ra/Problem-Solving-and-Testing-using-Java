Question 9 – Student Marks Indexing System 
Problem 
A university stores student records containing: 
Student ID 
Student Name 
Marks 
Given multiple queries containing a student ID, efficiently retrieve the corresponding 
student's name and marks. 
The solution must avoid scanning all student records for each query

import java.util.*;

public class Main {
    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Student> students = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int marks = sc.nextInt();

            students.put(id, new Student(name, marks));
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            int id = sc.nextInt();
            Student s = students.get(id);

            if (s != null) {
                System.out.println(s.name + " " + s.marks);
            } else {
                System.out.println("NOT FOUND");
            }
        }

        sc.close();
    }
}
Input
3
101 Ravi 85
102 Priya 92
103 Arun 78
2
102
103
Output
Priya 92
Arun 78
