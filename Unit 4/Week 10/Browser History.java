Question: 3 - Browser History — Linear Collection
A web browser stores recently visited pages. When the user presses the Back button, the most 
recently visited page should be removed first.

  
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter page URL: ");
            history.push(sc.nextLine());
        }

        System.out.println("Browser History: " + history);

        if (!history.isEmpty()) {
            System.out.println("Back button pressed.");
            System.out.println("Removed page: " + history.pop());
        }

        System.out.println("Remaining History: " + history);

        sc.close();
    }
}


Enter number of pages: 3
Enter page URL: google.com
Enter page URL: youtube.com
Enter page URL: github.com

  
Browser History: [google.com, youtube.com, github.com]
Back button pressed.
Removed page: github.com
Remaining History: [google.com, youtube.com]

