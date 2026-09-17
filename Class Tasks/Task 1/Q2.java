uestion 2 – Analyze Lambda Expressions and Stream Processing
Consider the following list of student marks:
List<Integer> marks = Arrays.asList(45, 78, 32, 90, 65, 88, 40, 95);
Write a Java program using Lambda expressions and Stream API to:
Display only marks greater than or equal to 60.
Add 5 bonus marks to each selected mark.
Find the average of the updated marks.
Display the marks in descending order.
Think & Analyze:
1.Which Stream operations will you use for filtering and transformation?
2.Where will you use a lambda expression?
3.Why is map() suitable for adding bonus marks?
4.Which operation can be used to calculate the average?
5.Explain the difference between filter() and map() in your solution.
6.Can the same task be solved without Stream API? Explain briefly.
Expected concepts: Lambda expressions, functional programming, filter(), map(), sorted(), average(), Stream pipeline.

  Java Program using Lambda Expressions and Stream API
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(45, 78, 32, 90, 65, 88, 40, 95);

        List<Integer> updatedMarks = marks.stream()
                .filter(m -> m >= 60)
                .map(m -> m + 5)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Updated marks: " + updatedMarks);

        double average = updatedMarks.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println("Average: " + average);
    }
}
Output
Updated marks: [100, 95, 93, 83, 70]
Average: 88.2
Think & Analyze

1. Which Stream operations are used?

filter() → selects marks ≥ 60
map() → adds 5 bonus marks
sorted() → sorts marks in descending order
average() → calculates the average

2. Where is a lambda expression used?

.filter(m -> m >= 60)
.map(m -> m + 5)

Here, m -> m >= 60 and m -> m + 5 are lambda expressions.

3. Why is map() suitable for adding bonus marks?

map() transforms each element into a new value.

.map(m -> m + 5)

For example, 78 → 83 and 90 → 95.

4. Which operation calculates the average?

.average()

  5. Difference between filter() and map()

filter()	map()
Selects elements	Transforms elements
May reduce the number of elements	Usually keeps the same number
m -> m >= 60	m -> m + 5

6. Can it be solved without Stream API?

Yes. We can use a normal for loop to check each mark, add 5 bonus marks, store the results, calculate the sum, and sort the list. Stream API makes the processing shorter, cleaner, and more functional.

Stream Pipeline
marks
  ↓
filter(m >= 60)
  ↓
map(m + 5)
  ↓
sorted(descending)
  ↓
updated marks
  ↓
average()
