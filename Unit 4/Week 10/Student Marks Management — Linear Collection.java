Question: 4 - Student Marks Management — Linear Collection
A teacher does not know the number of students in advance. Student marks need to be 
stored dynamically.
Question
Write a Java program using an ArrayList to:
 Store marks. 
 Display marks. 
 Find the highest mark. 
 Calculate the average.
  
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark: ");
            marks.add(sc.nextInt());
        }

        int highest = marks.get(0);
        int sum = 0;

        System.out.println("Student Marks: " + marks);

        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
            sum += mark;
        }

        double average = (double) sum / marks.size();

        System.out.println("Highest Mark: " + highest);
        System.out.printf("Average Mark: %.2f%n", average);

        sc.close();
    }
}


Enter number of students: 5
Enter mark: 85
Enter mark: 90
Enter mark: 78
Enter mark: 95
Enter mark: 82

  
Student Marks: [85, 90, 78, 95, 82]
Highest Mark: 95
Average Mark: 86.00
