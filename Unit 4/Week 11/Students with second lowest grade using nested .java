QUESTION 4 –STUDENTS WITH SECOND LOWEST GRADE USING NESTED 
LIST 
Inspired by HackerRank 
Problem 
Given the names and grades for each student in a class of students, store them in a nested list 
and print the name(s) of any student(s) having the second lowest grade. 
Note: If there are multiple students with the second lowest grade, order their names 
alphabetically and print each name on a new line. 
Example 
The ordered list of scores is, so the second lowest score is. There are two students 
with that score: Ordered alphabetically, the names are printed as: 
alpha 
beta 
Input Format 
The first line contains an integer, , the number of students. 
The subsequent lines describe each student over lines. 
- The first line contains a student's name. 
- The second line contains their grade. 
Constraints 
 There will always be one or more students having the second lowest grade. 
Output Format 
Print the name(s) of any student(s) having the second lowest grade in. If there are multiple 
students, order their names alphabetically and print each one on a new line. 


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Object>> students = new ArrayList<>();
        TreeSet<Double> grades = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            double grade = sc.nextDouble();
            students.add(Arrays.asList(name, grade));
            grades.add(grade);
        }

        double secondLowest = grades.higher(grades.first());
        List<String> names = new ArrayList<>();

        for (List<Object> student : students) {
            if ((double) student.get(1) == secondLowest) {
                names.add((String) student.get(0));
            }
        }

        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }

        sc.close();
    }
}
Input
5
Harry
37.21
Berry
37.21
Tina
37.2
Akriti
41
Harsh
39
Output
Berry
Harry
