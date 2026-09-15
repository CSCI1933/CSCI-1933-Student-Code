# 1933 Lab 1: Getting Started

Welcome to the first lab of CSCI 1933! Today you will be introduced to Git, creating a simple program, and some problems to re-familiarize you with several programming concepts.

## Lab Procedures

### These procedures apply to ALL labs this semester

Lab attendance is a requirement for this course. Except for special circumstances (e.g. illness), please plan to attend your scheduled lab section. It is strongly encouraged that you work with a partner within your lab section. If needed, TAs will assist you in finding one.

Labs are composed of various "Milestones", with Milestone 0 being your attendance point. As you complete Milestones in lab, raise your hand to be checked off. Milestones MUST be checked off in person by a TA. If you are unable to complete all Milestones by the end of lab, you will have up to **the end of office hours that Friday** to get any remaining Milestones checked off by a TA. We suggest you get your Milestones checked off as soon as possible since Friday office hours tend to become extremely crowded. As stated in the syllabus, your two lowest lab scores are dropped at the end of the semester.

**Note: Milestone 0 will be checked off in lab once your first Milestone is checked off. Credit will NOT be granted during office hours.**

## Let's Clone a GitHub Repository

Git is a version control system that helps you track changes to files in a project. It keeps track of all changes made, and it lets multiple people work on projects without overwriting each other's work. GitHub is a platform that lets you store Git repositories (projects) with additional features and tools. Git is a full-featured revision system that is very helpful for programming as a team. However, in the course of this semester, you will only be required to `pull` labs/projects from the provided GitHub.

Cloning a repository makes a copy of it onto your local machine. After this, you can make changes to the repository, commit the changes, and push them back up to the repository on GitHub (we will not be doing those in this lab). Let's begin!

First, you'll want to make sure you have git installed on your computer. Enter this into your terminal:

```bash
  git --version
```

If you get something like " git version 2.43.0 ..." you're good to proceed! If that command gives you errors, then follow [THIS](https://git-scm.com/downloads) link and follow the instructions for your operating system.

Open your terminal/command line, and navigate to the directory you want to put the lab repository. Now, type the following:

```bash
  git clone https://github.umn.edu/CSCI-1933/CSCI-1933-Student-Code.git
```



## Milestone 1

### Creating A Simple Java Program

Every Java application you write in this course will need a main method. You can treat a main method as the scripting portion of the Java file. In other words, the program executes what is in the main method.

1. Type out the following in **Application.java**.

```Java
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

2. Compile your program.

In the terminal/command line, make sure you're in the lab01 directory. Compile the program by using

```bash
javac Application.java
```

3. Finally, run it by using

```bash
java Application
```

### Milestone 1 Checkoff
>
> Show a TA your Application class, and run it in the terminal.

## Note

**Complete Milestones 2-4 in whatever language you feel comfortable in. Milestones 2 & 3 are much easier in Python. This is the only lab that will not exclusively be in Java.**

## Milestone 2

Write a function called **mostCommonChar()** that takes a string in as input and returns the most common character, and the number of times it appears.

- mostCommonChar("data") should return "a", 2.
- mostCommonChar("noon") can return either "n", 2 or "o", 2 (both are correct).

### Milestone 2 Checkoff
>
> Show a TA your function, and that it has the correct output for a few different strings.

## Milestone 3

Write a function called **isPalindrome()** that takes in a string, and returns true if it is a palindrome and false otherwise.

- isPalindrome("racecar") should return true.
- isPalindrome("pineapple") should return false.

### Milestone 3 Checkoff
>
> Like Milestone 2, show a TA your function, and that it has the correct output for a few different strings.

## Milestone 4

For this Milestone, use an object-oriented programming language (Java, Python, etc.). You will create a Circle class. As you may recall, objects usually have attributes that store useful information. A BankAccount class would have a balance attribute, a Car class would have a miles-driven attribute, and so on. Our Circle class will have only a radius attribute. It should have the following methods/constructors:

- A constructor that takes in and sets the radius
- getRadius(), which returns the radius of the circle
- setRadius(), which sets the radius of the circle
- getArea(), which calculates and returns the area of the circle (you can use 3.14 for pi)
- getDiameter(), which calculates and returns the diameter of the circle
- getCircumference(), which calculates and returns the circumference of the circle
- If it is possible in the language you're using, override the equality operator (==). In Python:

```Python
def __eq__(self, other):
  ...
```

- In Java, you cannot override operators. Instead, you need to override the **equals()** method.

```Java
public boolean equals(Circle other) {
  ...
}
```

### Milestone 4 Checkoff
>
> Create two Circle objects with different radii, and use print statements to verify your methods work. In Java, you can try something like this in your main method.

```Java
Circle c = new Circle(22);
Circle b = new Circle(22);
System.out.println(c.getRadius());
System.out.println(c.equals(b));
c.setRadius(13);
System.out.println(c.getRadius());
System.out.println(c.equals(b));
System.out.println(c.getArea());
System.out.println(c.getDiameter());
System.out.println(c.getCircumference());
```
