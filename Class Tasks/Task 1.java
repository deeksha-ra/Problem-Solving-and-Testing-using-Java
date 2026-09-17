Consider the following Java program:
class Employee {
    void calculateSalary() {
        System.out.println("Employee salary");
    }
}

class Developer extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Developer salary");
    }
}

class Manager extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Manager salary");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Developer();
        Employee e2 = new Manager();

        e1.calculateSalary();
        e2.calculateSalary();
    }
}
Think & Analyze:
1.What will be the output?
2.Why can an Employee reference hold a Developer or Manager object?
3.Which version of calculateSalary() is executed and why?
4.Identify the OOP concept demonstrated by this program.
5.Modify the program to add a Tester class with its own salary calculation.
Expected concepts: Inheritance, method overriding, runtime polymorphism, dynamic method dispatch.

  1. What will be the output?
Developer salary
Manager salary
2. Why can an Employee reference hold a Developer or Manager object?

Because Developer and Manager inherit from Employee. A parent-class reference can refer to an object of its child class.

Employee e1 = new Developer();
Employee e2 = new Manager();

This is called upcasting.

3. Which version of calculateSalary() is executed and why?

The overridden method of the actual object is executed:

e1 refers to a Developer object → Developer.calculateSalary()
e2 refers to a Manager object → Manager.calculateSalary()

Java determines this at runtime, through dynamic method dispatch.

4. Identify the OOP concept

The main OOP concept demonstrated is runtime polymorphism.

It uses:

Inheritance – Developer and Manager extend Employee
Method overriding – both classes override calculateSalary()
Upcasting – Employee references hold child objects
Dynamic method dispatch – the appropriate overridden method is selected at runtime
5. Modified program with Tester
class Employee {
    void calculateSalary() {
        System.out.println("Employee salary");
    }
}

class Developer extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Developer salary");
    }
}

class Manager extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Manager salary");
    }
}

class Tester extends Employee {
    @Override
    void calculateSalary() {
        System.out.println("Tester salary");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Developer();
        Employee e2 = new Manager();
        Employee e3 = new Tester();

        e1.calculateSalary();
        e2.calculateSalary();
        e3.calculateSalary();
    }
}

Output:

Developer salary
Manager salary
Tester salary
