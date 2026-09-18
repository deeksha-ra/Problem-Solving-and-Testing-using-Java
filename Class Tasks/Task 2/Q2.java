Question 2 – Analyze Lambda Expressions and Stream Processing
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
Java Program
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

1. Which Stream operations are used for filtering and transformation?

filter() → selects marks ≥ 60.
map() → adds 5 bonus marks.
sorted() → arranges marks in descending order.
average() → calculates the average.

2. Where is the lambda expression used?

Lambda expressions are used here:

.filter(m -> m >= 60)
.map(m -> m + 5)

m -> m >= 60 means: check whether the mark is at least 60.

m -> m + 5 means: add 5 to the mark.

3. Why is map() suitable for adding bonus marks?

map() transforms each element into a new value.

For example:

78 → 83
90 → 95
65 → 70

So map(m -> m + 5) is suitable.

4. Which operation calculates the average?

The average() operation calculates the average.

.average()

It is used after converting the Stream<Integer> to an IntStream using:

.mapToInt(Integer::intValue)
Loading

5. Difference between filter() and map()

filter()	map()
Selects elements	Transforms elements
May reduce the number of elements	Usually keeps the same number
m -> m >= 60	m -> m + 5
Removes marks below 60	Adds bonus marks

Example:

Original: 45 78 32 90 65 88 40 95

filter():
       78 90 65 88 95

map():
       83 95 70 93 100

6. Can this be solved without Stream API?

Yes. We can use a traditional for loop, if condition, a list, and sorting methods.

However, the Stream API provides a shorter and more functional way to perform filtering, transformation, sorting, and aggregation as a pipeline.

Stream Pipeline
marks
  ↓
filter(m -> m >= 60)
  ↓
map(m -> m + 5)
  ↓
sorted(reverse order)
  ↓
updated marks
  ↓
average()
