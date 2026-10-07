Problem Statement
Design a Payment Processing System using a Java interface and an abstract class.
Create an interface:
interface Payment {
    void pay(double amount);
}
Implement this interface using three classes:
CreditCardPayment 
UPIPayment 
NetBankingPayment 
Each payment method should implement the pay() method.
Create an abstract class PaymentProcessor containing:
abstract double processPayment(Payment payment, double amount);
Create a concrete class 
OnlinePaymentProcessor that extends PaymentProcessor.

The processing rules are:
Credit Card: 2% processing fee 
UPI: 1% processing fee 
Net Banking: 1.5% processing fee 

The program should calculate the final amount paid, including the processing fee.
The design should allow a new payment method to be added without modifying the existing PaymentProcessor class.

Input Format
The first line contains an integer N, representing the number of transactions.
Each of the next N lines contains:
paymentType amount
where:
1 → Credit Card 
2 → UPI 
3 → Net Banking 

Output Format
For each transaction, print:
paymentType finalAmount
Print the final amount rounded to two decimal places.

Constraints
1 ≤ N ≤ 100 
100 ≤ amount ≤ 1000000 

Sample Input
3
1 1000
2 2000
3 5000

Sample Output
CreditCard 1020.00
UPI 2020.00

  ```java
import java.util.*;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Credit Card payment: " + amount);
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("UPI payment: " + amount);
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Net Banking payment: " + amount);
    }
}

abstract class PaymentProcessor {
    abstract double processPayment(Payment payment, double amount);
}

class OnlinePaymentProcessor extends PaymentProcessor {

    double processPayment(Payment payment, double amount) {
        double fee;

        if (payment instanceof CreditCardPayment) {
            fee = amount * 0.02;
        } else if (payment instanceof UPIPayment) {
            fee = amount * 0.01;
        } else {
            fee = amount * 0.015;
        }

        payment.pay(amount + fee);
        return amount + fee;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        PaymentProcessor processor = new OnlinePaymentProcessor();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            double amount = sc.nextDouble();

            Payment payment;
            String name;

            if (type == 1) {
                payment = new CreditCardPayment();
                name = "CreditCard";
            } else if (type == 2) {
                payment = new UPIPayment();
                name = "UPI";
            } else {
                payment = new NetBankingPayment();
                name = "NetBanking";
            }

            double finalAmount = processor.processPayment(payment, amount);

            System.out.printf("%s %.2f%n", name, finalAmount);
        }

        sc.close();
    }
}
```
Input
3
1 1000
2 2000
3 5000

Output
CreditCard 1020.00
UPI 2020.00
NetBanking 5075.00
