QUESTION 10 – SMART TRAFFIC NAVIGATION 
Lab Manual Based – Task 8 
Problem Description 
A smart city application stores road connectivity information using nested collections. Given 
city junctions and roads, determine whether a route exists between two junctions using graph 
representation with collections. 
Input Format 
 First line contains integers N and M. 
 Next M lines contain connected junction pairs. 
 Last line contains source and destination. 
Output Format 
Print YES if route exists, otherwise NO. 
Constraints 
 1 ≤ N ≤ 10^5 
 1 ≤ M ≤ 2×10^5 
Sample Input 
5 4 
1 2 
2 3 
3 4 
4 5 
1 5 
Sample Output 
YES

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int source = sc.nextInt();
        int destination = sc.nextInt();

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                System.out.println("YES");
                sc.close();
                return;
            }

            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println("NO");
        sc.close();
    }
}
Input
5 4
1 2
2 3
3 4
4 5
1 5
Output
YES
