import java.util.Scanner;

class Solution {
    public static int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }
        return nums;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] nums= new int[n];
        for(int i=0;i<n;i++){
            nums[i]= sc.nextInt();
        }
        System.out.println("["+runningSum(nums)+"]");
        sc.close();
    }
}
Input
nums =
[1,2,3,4]
Output
[1,3,6,10]
Expected
[1,3,6,10]
