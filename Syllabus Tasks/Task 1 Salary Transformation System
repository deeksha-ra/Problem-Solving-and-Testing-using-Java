import java.util.Scanner;
import java.util.Arrays;
public class Sts{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] sal=new int[n];
    Arrays.setAll(sal,i->sc.nextInt());
    Arrays.stream(sal)
          .map(a->a+(a*10/100))
          .forEach(System.out::println);
    sc.close();
  }
}
Sample Input
5
1000 2000 3000 4000 5000
Sample Output
1100 2200 3300 4400 5500
