Question 10 – Product Inventory and Low-Stock Analysis 
Problem 
A supermarket maintains product information: 
Product ID 
Product Name 
Stock 
Price 
Perform the following: 
1. Update stock after sales. 
2. Find products whose stock is below a given threshold. 
3. Display products sorted by remaining stock. 
4. Efficiently retrieve products using their ID.

import java.util.*;

public class Main {
    static class Product {
        int id, stock;
        String name;
        double price;

        Product(int id, String name, int stock, double price) {
            this.id = id;
            this.name = name;
            this.stock = stock;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Product> products = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int stock = sc.nextInt();
            double price = sc.nextDouble();

            products.put(id, new Product(id, name, stock, price));
        }

        int sales = sc.nextInt();

        for (int i = 0; i < sales; i++) {
            int id = sc.nextInt();
            int quantity = sc.nextInt();

            Product p = products.get(id);

            if (p != null && quantity >= 0 && quantity <= p.stock) {
                p.stock -= quantity;
            }
        }

        int threshold = sc.nextInt();

        System.out.println("Low Stock Products:");

        List<Product> list = new ArrayList<>(products.values());

        list.sort(Comparator.comparingInt(p -> p.stock));

        for (Product p : list) {
            if (p.stock < threshold) {
                System.out.println(p.id + " " + p.name + " " + p.stock);
            }
        }

        System.out.println("Products Sorted by Stock:");

        for (Product p : list) {
            System.out.println(p.id + " " + p.name + " "
                + p.stock + " " + p.price);
        }

        sc.close();
    }
}
Input
3
101 Pen 20 10.0
102 Book 5 50.0
103 Bag 12 300.0
2
101 8
102 2
10
Output
Low Stock Products:
102 Book 3
Products Sorted by Stock:
102 Book 3 50.0
101 Pen 12 10.0
103 Bag 12 300.0
