Question 1 – Hashtag Frequency Counter 
Problem 
A social media platform receives N hashtags. Count the frequency of each hashtag and 
display the hashtags along with their frequencies. 
If multiple hashtags have the same frequency, display them in lexicographical order.

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String tag = sc.next();
            freq.put(tag, freq.getOrDefault(tag, 0) + 1);
        }

        List<String> tags = new ArrayList<>(freq.keySet());

        tags.sort((a, b) -> {
            int cmp = Integer.compare(freq.get(b), freq.get(a));
            return cmp != 0 ? cmp : a.compareTo(b);
        });

        for (String tag : tags) {
            System.out.println(tag + " " + freq.get(tag));
        }

        sc.close();
    }
}
Input
6
#java #ai #java #python #ai #java
Output
#java 3
#ai 2
#python 1
