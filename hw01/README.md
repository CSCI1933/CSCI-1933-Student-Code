# 1933 Homework 1: Java Syntax
"Syntax" refers to the rules regarding the structure of a language, which determine the correctness of any excerpt written (or spoken) in that language. Just like human languages, programming languages are also governed by syntax, with different syntactic rules applying to different languages.

Java is a language that happens to have stricter syntax rules compared to a language like Python, which has relatively limited syntax. This can take getting used to! Luckily, like with human languages, with enough practice it will become like second-nature to write fluently in a new programming language. 

It helps to understand *why* some of the syntax rules exist. In this homework you will write a simple Java program, paying close attention to the syntax.
### Associated zyBooks Reading
- 1.5 Control flow

## 1. The Task
Your task is to write a Java method called `countdown` prints a countdown to the terminal.

A method is a block of code that can be called by other code. Note that a "method" is nearly identical to the concept of a "function", with the only difference between these two terms being that a method is a function that inside of a Class. Recall that all Java code *must* be inside of a class, which means all functions in Java are actually called methods. 

Methods can take in arguments to change their behavior. In this case, your `countdown` method will take in an integer that tells the method where to start the countdown.

Methods can also return values to where they were called. Your `countdown` method will return the sum of all the numbers in the countdown.

Here are a couple examples of how this method should work:
### `countdown(3)`
Prints:
```
3
2
1
```
Returns:
`3 + 2 + 1 = 6`


### `countdown(7)`
Prints:
```
7
6
5
4
3
2
1
```
Returns:
`7 + 6 + 5 + 4 + 3 + 2 + 1 = 28`

## 2. Method Signature
Create a new file called `Program.java`. Remember that your code needs to be placed inside of a class with the same name as the file, so start by adding this class definition:
```Java
public class Program {

}
```
Our `countdown` method will be inside of this class. To define a method, you need to first write a **method signature**. This is like a header that tells Java all of the important information it needs to know about your method.

For example, this could be the method signature for a method called `isEnglish` which returns `true` if the argument is a valid English word, and `false` if not:
```Java
public static boolean isEnglish(String word) {
	// Code goes here
}
```
Let's take a look at the components of this method signature!
- `public`: this is called the **access modifier** which parts of your program can use this method. Your `countdown` method should also be `public`
- `static`: this indicates that the method belongs to the Class instead of instances of the class. We will talk about this more as the course goes on, but your `countdown` method should also be `static`.
- `boolean`: this tells Java the data type that this method will return. Consider, what data type do we want `countdown` to return?
- `isEnglish`: this is the name that the programmer has chosen to give the method. It is good style to choose a name that logically describes the purpose of the method.
- `String`: this is the data type of the parameter. Consider, what should be the data type of `countdown`'s parameter?
- `word`: this is the name that the programmer has chosen to give the parameter. It is good style to choose names for variables that describe the data that they represent.

Based on this, your `countdown` method should have a signature that looks like this. Add this to your `Program` class and replace each `???` with the proper values.
```Java
public static ??? countdown(??? ???){

}
```

## 3. Method Logic
Now we can add the actual logic inside of the `countdown` method!

#### Creating a Variable
Since we want to eventually return the sum of all the numbers in the countdown, it makes sense to start by creating a variable that we will continuously add to.

This is an example of initializing a variable named `favClass` that has the `String` data type:

```Java
String favClass = "CSCI 1933!";
```

Use this example to initialize your sum variable. What data type should it be? What name would make sense? What value should it start at?

Notice that there is a semicolon `;` at the end of the line. Since Java doesn't care about whitespace, the semicolon is used to tell Java where the end of each instruction is. This means there will typically need to be a semicolon at the end of every line of code except for when a new code block is being defined.

#### Looping
It makes sense to use a loop structure since we are trying to repeatedly preform an action, that being printing out a number.

For Loops in Java are made up of three statements. The first statement can set up a variable to use in the loop, the second tells the loop when to keep running, and the third tells the loop what to change at the end of each iteration.

This is an example of a loop that iterates from 0 to 9:

```Java
for (int i = 0; i < 10; i++){
	// loop code goes here
}
```

- `int i = 0;` sets up a new variable named `i` that starts at `0`
- `i < 10;` says to keep running the loop as long as `i` is less than `10`
- `i++` means the loop will increment `i` at the end of each loop iteration. This is equivalent to writing `i += 1`

Ask yourself, for the `countdown` method, what value should `i` start at? What is the condition for which the loop should keep running? How should we change `i` at the end of each iteration?

Add this loop structure and replace each `???` with the proper value:

```Java
for (int i = ???; ???; ???){

}
```

#### Loop Instructions
You should place two statements inside of your for loop. First, we need to print out the current number in the countdown. Remember the syntax for printing in Java is `System.out.println(printThis)`.

We should also add to the sum variable that we created earlier. Add another line inside of your for loop to add the current value to your sum.
#### Returning
Don't forget to `return` the sum variable at the end of the method. Which variable do we want to return? Do we want to return inside or outside of the for loop?

## 3. Testing your Code
We can add a `main` method to our `Program` class to test out our `countdown` method.

Add this code inside of the `Program` class (meaning it should be inside of the outer-most curly brackets). Convention is to place the main method at the bottom of a class definition, so it should be underneath your `countdown` method definition.

```Java
public static void main(String[] args){
	int returnedSum = countdown(10);
	System.out.println("Return Value: " + returnedSum);
}
```

Test your code by compiling it with `javac Program.java`, then running it with `java Program`.

Try changing the argument that gets passed in to `countdown`, and ensure the output is correct for a few different values. Remember to recompile with `javac` every time you make a change, otherwise you will be running an out-of-date version of the code!
## Submission
Go to the Homework 1 submission on Gradescope, and add `Program.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
