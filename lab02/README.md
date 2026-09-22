# 1933 Lab 2: Basic Java Skills

Welcome to lab! Today, you will be introduced to some basic Java concepts. You saw a few of these last week, and you will continue to use them throughout the semester. We'll review creating a class, compiling your code, and running your code in the terminal. You will also be introduced to the **Scanner** class that is used for reading user input in your programs.

## Milestone 1

### Introduction to Object-Oriented Programming

In your daily life, you encounter thousands of **objects**: dogs, people, trees, cars, and so on. Almost every one of these objects has a **state** and **behavior**. *An object's state describes the object*. Take dogs for example. Their name, age, weight, breed, etc. are part of their state. *An object's behavior describes what the object can do*. Barking, walking, eating, sleeping, etc. are part of a dog's behavior.

Since Java is an **object-oriented** language, we can model these real-world objects via code. To model these objects, Java requires us to write classes. A class is like a blueprint for an object. It lays out **instance variables** (state) and **methods** (behaviors) for an object. An object is an **instance** of a class — the actual model built from the class.

### BankAccount

Let's create a BankAccount class. Create a file called "BankAccount.java" (the file name should be the same as the class name). In the real world, almost every object has instance variables (state) and methods (behaviors). To make our BankAccount useful, let's keep track of its name, password, and balance ... if you think these sound like instance variables, you're 100% right!

```Java
public class BankAccount {
    String name;
    String password;
    double balance;
}
```

If you're coming from a Python background, these variables might look a little weird. Java is a **statically-typed** language. This means you have to explicitly give your variables their type before you can use them. This is incorrect:

```Java
name;
```

It should be:

```Java
String name;
```

Another thing to note is that every line in Java must end in a semicolon or a curly brace. This might take some getting used to.

Next, you need to be able to *withdraw* and *deposit* money into your **BankAccount**; Those sound like methods! It is good Java style to write method and variable names in camel case. **thisIsAnExampleOfCamelCase**. Your BankAccount class should look something like this:

```Java
public class BankAccount {
    String name;
    String password;
    double balance;

    // Method to withdraw from a BankAccount
    public void withdraw(String enteredPassword, double amount) {
        // Only withdraw if the password is correct and there are sufficient funds
        if (password.equals(enteredPassword) && balance >= amount) {
            balance = balance - amount;
        }
    }

    // Method to deposit into a BankAccount
    public void deposit(String enteredPassword, double amount) {
        // Must have the correct password
        if (password.equals(enteredPassword)) {
            balance = balance + amount;
        }
    }
}
```

Lines that begin with "//" are comments, and do not affect how your code runs.

### Comparing Objects in Java

You'll notice that .equals() is used to compare the Strings for password and enteredPassword. You've likely seen == to check for equality in Python. In Java, be sure to only use == if you're using primitives (int, boolean, char, byte, long, short, float, and doubles), and .equals() for comparing objects. What happens if you run the following code?

```Java
String a, b;
a = new String("hi");
b = new String("hi");
System.out.println("Does a equal b? " + (a == b));
```

The output will be false. For non-primitive data types, the memory addresses are compared. a.equals(b) will return true. In this course, the ONLY reason you should use == for objects is to check if that object is null. If you try to call a method on an object that is null, you will get the infamous null pointer exception (NPE) which will cause your program to break.

### Milestone 1 Checkoff

> Show a TA your BankAccount class. No need to run anything.

## Milestone 2

Congratulations! You now have a BankAccount class. It's time to **instantiate** (create/model) our bank accounts.

### Instantiating BankAccount

Instantiating primitive and String variables are simple. It is the type of that variable, followed by the variable name, the assignment operator, and the value. Instantiating an object is almost identical, it is the name of the class you want to instantiate, followed by the variable name, the assignment operator (=), the keyword **new** (used when creating an instance of a class), and the class name again followed by (). Instantiating a bank account would look like this:

```Java
BankAccount myAcc = new BankAccount();
```

Recall, the portion of your code that executes is in the main method inside the class that looks like this:

```Java
public static void main(String[] args) {
    // Your code goes here
}
```

Now that we have our first object, we can access its instance variables using the dot operator. If you type in myAcc followed by a dot, you can use any instance variables and methods from the BankAccount class.

To set the password:

```Java
myAcc.password = "Java is fun!";
```

To deposit into myAcc:

```Java
myAcc.deposit("Java is fun!", 100.50);
```

To print the balance and verify the correct amount was deposited:

```Java
System.out.println("My account's balance: " + myAcc.balance);
```

If you create another BankAccount, let's call it **otherAcc**, and withdraw and deposit from it, you will see that the two accounts behave independently of each other.

### Construction Ahead

If you were to print out the instance variables of myAcc before setting any of them, you would see something weird for the String variables. They will be null. The reason is that we have not given myAcc's instance variables their initial values, so they default to some preset value. Numbers default to 0, and for Objects, like Strings, it's null. In the real world, when someone opens a bank account, the name, password, and balance are already known. Up to this point, we've been creating BankAccounts without a name, password, or balance, and setting these values **after** the BankAccount's creation.

There is a way to have our objects take specific values upon instantiation. This is done with **constructor methods** aka **constructors**. The signature for constructors is rather simple:

```Java
[access modifier] [name of your class] ([Type] [parameter], ...) {
    // Any initialization goes here
}
```

This is how we could initialize all three instance variables upon creation of a BankAccount:

```Java
public BankAccount(String name, String password, double balance) {
    this.name = name;
    this.password = password;
    this.balance = balance;
}
```

Two things to note:

1. For this course, the constructors you write will ALWAYS be public (more on access modifiers later).
2. Why do we need the `this` keyword here? To avoid ambiguity! Java needs to know which name, password, and balance you are referring to. Here is an example where you wouldn't need the `this` keyword:

```Java
public BankAccount(String initName, String initPass, double initBal) {
    name = initName;
    password = initPass;
    balance = initBal;
}
```

Using one of the above constructors, you can now have every BankAccount instance take on initial values upon creation. If you go back to your main method, you have to fill in values inside the parenthesis when instantiating BankAccount like this:

```Java
BankAccount myAcc = new BankAccount("Java", "java1234!", 238.57);
```

If you then print out each attribute of **myAcc** after this line, you will see that they have the values you passed into the constructor.

### Note

If you don't have a custom constructor, Java, by default, will implicitly include a null constructor. It is like the constructor you just wrote but without any parameters or code in its body. Java also allows for multiple custom constructors alongside the null constructor so long as they meet the overloading constraint. We will touch on this in a future lab, but feel free to look this up on your own time. Why might having multiple constructors be beneficial?

### Access Modifiers

There is something odd about our BankAccount class. It's great that we added a layer of security by requiring a password to withdraw and deposit from our accounts. What would happen if someone tried to do this?

```Java
myAcc.password = "1 h4cked y0ur pazwrd n00b!";
```

Unfortunately for us, this would work! This would be very bad, but what can we do about it? It was mentioned previously, but Java has something called **access modifiers**.

- public: Anyone can access and use this instance variable/class/method.
- private: Only the class itself can access and use this instance variable/method.
- protected - Only classes within the same package or sub-classes can access and use this instance variable/class/method.
- package-protected - Only classes within the same package, excluding sub-classes, can access and use this instance variable/class/method.

For this course, you only have to know the first two.

Since we don't want our BankAccount's name, password, or balance to be open to the public, we need to make them private. It is good practice (and **strongly** recommended) to make all instance variables private. It is as simple as typing in the keyword **private** before the type of each instance variable, e.g. `private String password`.

Make all your instance variables in the BankAccount class private. If you go back to your main method, you will see that you cannot publicly access your private **member variables** (instance and member variables are interchangeable).

You might be wondering, "If my member variables are private, how do I use them in the first place?". We do this with **getter** and **setter** methods (formally known as **accessor** and **mutator** methods, respectively). Here are two examples:

```Java
// getter for the balance instance variable
public double getBal(String enteredPassword) {
    if (password.equals(enteredPassword)) {
        return balance;
    } else {
        return -1;
    }
}

// setter for the password instance variable
public boolean setPass(String oldPassword, String newPassword) {
    if (password.equals(oldPassword)) {
        password = newPassword;
        return true;
    } else {
        return false;
    }
}
```

A few things to keep in mind:

1. You don't need getters and setters for each instance variable. Use them when it makes sense to.
2. For the majority of this course, your getters and setters will be as simple as this:

```Java
public void setName(String newName) {
    this.name = newName;
}
public String getName() {
    return this.name;
}
```

### Milestone 2 Checkoff

> Show a TA your BankAccount class with the appropriate getters and setters, an updated main method, and run your main method.
>
> **Sample Output**:
> "Your account's balance is 238.57"

## Milestone 3

During this lab, you may have been slightly bothered by how often you need to recompile. Even if it's just a slight change, say, your BankAccount password, you have to recompile. Fortunately, there is a better way to do this using the **Scanner** class.

### Working with Scanner

To use the Scanner class, you need to import the Scanner class which is part of the java.util package. At the *very* top of your file, even above  `public class BankAccount {`, you should add this line:

```Java
import java.util.Scanner;
```

This tells your computer to add the Scanner class to the resources available to your program. Let's try something simple with the Scanner class. We'll instantiate Scanner, take user input, and print out that input. Add this code to your main method:

```Java
// 1. Instantiate Scanner
Scanner s = new Scanner(System.in);
// Print a prompt to the user
System.out.println("Type something, then hit enter!");
// 2. Read user input
String input = s.nextLine();
// Print the input
System.out.println("This was your input: " + input);
```

This might not make a lot of sense, but let's break some of it down.

1. **Instantiate Scanner**: This looks like what we've done with BankAccount except for one thing. The System.in argument tells the Scanner object to read from the user's input. We'll cover other uses of Scanner later, but this is the only argument you need to pass in.
2. **Read user input**: The program will wait on the nextLine() method until it finds a '\n', the newline character (aka the user hits enter). The nextLine() method returns a String, and it is stored in the input variable.

### Milestone 3 Checkoff

> Modify your main method to ask a user for their password using the Scanner class. Use your **getBal()** method and attempt to print out the balance. Show a TA your main method with a correct password and an incorrect password.
>
> **Sample Output with Correct Password**
> *"Enter your password: "* <br>
> \> java1234!
>
> *"Your account's balance is 238.57"*
>
> **Sample Output with Incorrect Password**
> *"Enter your password: "* <br>
> \> python4321!
>
> *"Your account's balance is -1"*
>
> *Your output doesn't need to match exactly, but it must have the correct output depending on whether the password is correct or not.*

## Milestone 4

In this lab, you were required to create a class that represents a bank account. In the real world, most people have at least two accounts: Checkings and Savings. Sometimes you may need to transfer money between accounts. Write a function called transfer that takes in a different BankAccount object, an enteredPassword, and an amount to transfer from this BankAccount to the other BankAccount:

```Java
// Transfer 'amount' from this account to otherAcc if enteredPassword 
// matches this account's password
public void transfer(BankAccount other, String enteredPassword, double amount) {
    // 1. Check that enteredPassword matches
    // 2. Use the Scanner class to get the password for otherAcc
    // 3. Take money out of 'this' account (HINT: you have a method that does this)
    // 4. Put money into otherAcc (HINT: you have a method that does this)
}
```

### Milestone 4 Checkoff

> Complete the transfer method. Use it in your main method, and show a TA how it functions with the correct password and incorrect password (for 'this' account or the other account)
>
>// myAcc - Name: Java, Balance: 238.57, Password: java1234!
> // otherAcc - Name: Python, Balance: 61.43, Password: python4321!
>
> **Sample Output with Correct Password**
> myAcc.transfer(otherAcc, "java1234!", 38.57);
>
> "Enter the other account's password: "
> *python4321!*
>
> "Java balance: 200"
> "Python balance: 100"
>
> **Sample Output with Incorrect Password**
> myAcc.transfer(otherAcc, "java1234!", 38.57);
>
> *"Enter the other account's password: "*
> I love C!
>
> *"Java balance: 238.57"*
> *"Python balance: 61.43"*
>
> *Again, your output doesn't need to match exactly, but it must have the correct output depending on whether the password is correct or not.*
