Question 1: Advanced Problem-Solving Approach using linear and non-linear 
collections.
An online shopping system must maintain products, quickly search products by ID, and 
process orders according to priority


import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        HashMap<Integer, Product> productMap = new HashMap<>();
        PriorityQueue<Product> orderQueue =
            new PriorityQueue<>((a, b) -> Double.compare(a.price, b.price));

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();

            Product p = new Product(id, name, price);
            products.add(p);
            productMap.put(id, p);
            orderQueue.add(p);
        }

        int searchId = sc.nextInt();

        if (productMap.containsKey(searchId)) {
            System.out.println("Product Found: " + productMap.get(searchId));
        } else {
            System.out.println("Product not found");
        }

        System.out.println("All Products:");
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("Priority Order:");
        while (!orderQueue.isEmpty()) {
            System.out.println(orderQueue.poll());
        }

        sc.close();
    }
}


3
101 Laptop 55000
102 Mouse 500
103 Keyboard 1500
102

Product Found: ID: 102, Name: Mouse, Price: 500.0
All Products:
ID: 101, Name: Laptop, Price: 55000.0
ID: 102, Name: Mouse, Price: 500.0
ID: 103, Name: Keyboard, Price: 1500.0
Priority Order:
ID: 102, Name: Mouse, Price: 500.0
ID: 103, Name: Keyboard, Price: 1500.0
ID: 101, Name: Laptop, Price: 55000.0

