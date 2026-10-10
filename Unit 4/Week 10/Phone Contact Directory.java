Question 10 - Phone Contact Directory
Scenario
A mobile application stores people's names and phone numbers. Users can search for a 
contact or update an existing phone number.
  
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> contacts = new HashMap<>();

        System.out.print("Enter number of contacts: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();

            contacts.put(name, phone);
        }

        System.out.print("Enter name to search: ");
        String searchName = sc.nextLine();

        if (contacts.containsKey(searchName)) {
            System.out.println("Phone Number: " + contacts.get(searchName));

            System.out.print("Enter new phone number: ");
            String newPhone = sc.nextLine();

            contacts.put(searchName, newPhone);
            System.out.println("Contact updated successfully.");
            System.out.println("Updated Phone Number: " + contacts.get(searchName));
        } else {
            System.out.println("Contact not found.");
        }

        sc.close();
    }
}

2
Arun
9876543210
Priya
9123456780
Arun
9988776655

Phone Number: 9876543210
Contact updated successfully.
Updated Phone Number: 9988776655
