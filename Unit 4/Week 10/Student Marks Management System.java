**Question: 2 - Student Marks Management System**
A teacher wants to create a Java program to store the marks of students in a class. The 
number of students is **not known in advance**, so the program should use a **dynamic array**
The teacher can add marks one by one, and the array should automatically increase its size
when it becomes full.
  
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[2];
        int size = 0;

        while (true) {
            System.out.print("Enter student marks (-1 to stop): ");
            int mark = sc.nextInt();

            if (mark == -1) {
                break;
            }

            if (size == marks.length) {
                int[] newMarks = new int[marks.length * 2];
                for (int i = 0; i < marks.length; i++) {
                    newMarks[i] = marks[i];
                }
                marks = newMarks;
            }

            marks[size] = mark;
            size++;
        }

        System.out.println("Student Marks:");
        for (int i = 0; i < size; i++) {
            System.out.println(marks[i]);
        }

        sc.close();
    }
}

Enter student marks (-1 to stop): 85
Enter student marks (-1 to stop): 90
Enter student marks (-1 to stop): 78
Enter student marks (-1 to stop): 95
Enter student marks (-1 to stop): -1

Student Marks:
85
90
78
95
