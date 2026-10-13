Question 5 – Frequency Queries 
Inspired by HackerRank – Frequency Queries 
Problem 
Maintain a collection of integers and support three operations: 
1 x → Insert x 
2 x → Delete one occurrence of x 
3 f → Check whether any number occurs exactly f times 
Print 1 if an element has frequency f, otherwise print 0.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> freqCount = new HashMap<>();

        while (q-- > 0) {
            int type = sc.nextInt();
            int x = sc.nextInt();

            if (type == 1) {
                int old = freq.getOrDefault(x, 0);

                if (old > 0) {
                    freqCount.put(old, freqCount.get(old) - 1);
                }

                freq.put(x, old + 1);
                freqCount.put(old + 1,
                    freqCount.getOrDefault(old + 1, 0) + 1);

            } else if (type == 2) {
                int old = freq.getOrDefault(x, 0);

                if (old > 0) {
                    freqCount.put(old, freqCount.get(old) - 1);
                    freq.put(x, old - 1);

                    if (old > 1) {
                        freqCount.put(old - 1,
                            freqCount.getOrDefault(old - 1, 0) + 1);
                    }
                }

            } else if (type == 3) {
                System.out.println(
                    freqCount.getOrDefault(x, 0) > 0 ? 1 : 0);
            }
        }

        sc.close();
    }
}
Input
8
1 5
1 6
1 5
3 2
1 6
3 2
2 5
3 2
Output
1
1
0
