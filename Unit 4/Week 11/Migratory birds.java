QUESTION 9 – MIGRATORY BIRDS 
Inspired by HackerRank 
Problem 
Given an array of bird sightings where every element represents a bird type id, determine the 
id of the most frequently sighted type. If more than 1 type has been spotted that maximum 
amount, return the smallest of their ids.Example 
There are two each of types and , and one sighting of type . Pick the lower of the two types 
seen twice: type . 
Function Description 
Complete the migratoryBirds function in the editor below. 
migratoryBirds has the following parameter(s): 
 int arr[n]: the types of birds sighted 
Returns 
 int: the lowest type id of the most frequently sighted birds 
Input Format 
The first line contains an integer, , the size of . 
The second line describes as space-separated integers, each a type number of the bird 
sighted. 


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] freq = new int[6];

        for (int i = 0; i < n; i++) {
            freq[sc.nextInt()]++;
        }

        int result = 1;

        for (int i = 2; i <= 5; i++) {
            if (freq[i] > freq[result]) {
                result = i;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
Input
6
1 4 4 4 5 3
Output
4
