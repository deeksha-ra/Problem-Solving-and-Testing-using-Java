Question: 8 Find Common Subjects Between Two Students
Scenario: 
Two students have selected different subjects. Write a Java program using retainAll() to find 
the subjects common to both.
  
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> student1 = new ArrayList<>();
        ArrayList<String> student2 = new ArrayList<>();

        System.out.print("Enter number of subjects for Student 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n1; i++) {
            student1.add(sc.nextLine());
        }

        System.out.print("Enter number of subjects for Student 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n2; i++) {
            student2.add(sc.nextLine());
        }

        student1.retainAll(student2);

        System.out.println("Common Subjects: " + student1);
        sc.close();
    }
}

3
Java
Python
DBMS
3
Python
Java
OS

Common Subjects: [Java, Python]
