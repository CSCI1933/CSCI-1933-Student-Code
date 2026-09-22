# 1933 Homework 2: Iteration vs Recursion
Iteration and Recursion are two techniques that allow you to write code that repeats itself. This is very important, because much of Computer Science involves performing similar actions many times.

Iteration means a block of code is repeatedly executed using a loop.

Recursion means a function calls itself to repeat its execution.

Any problem that can be solved using a loop can be transformed to use recursion, and vice versa-- but for certain problems, one technique might be much more intuitive or efficient than the other. It is important to understand how both techniques work so you can choose the best approach to any problem.
### Associated zyBooks Reading
- 5.1 Illustrative examples of recursion

In this assignment, you will write three methods that calculate factorials-- one will be iterative, one will be recursive, and one will be *tail* recursive, which is like a combination of the two techniques that implements an iterative process using recursion. 

The factorial for a number `n` is written as `n!`, and is defined as the product of all the positive whole numbers less than or equal to that number. For example, `5! = 5 * 4 * 3 * 2 * 1 = 120`. 

Note that the factorial operation is NOT defined for negative numbers, and for this assignment you may assume that negative numbers will never be passed into your methods.

Create a file called `Factorial.java` that defines a `Factorial` class.
## 1. Iterative Factorial
Add the following method signature to `Factorial.java`:
```Java
public static int factorialIterative(int n){

}
```

Add the logic to compute factorials using a `for` or `while` loop. 

You should consider creating a new variable that you can continuously multiply by each number to track your computation. To determine the value to start this variable at, consider the fact that `0!=1`. (If you are curious why `0!=1`, you can read this short article from [themathdoctors.org](https://www.themathdoctors.org/zero-factorial-why-does-0-1/)).

Your loop should go from `1` to `n` (inclusive) to access all of the numbers that need to be multiplied. Finally, don't forget to return an integer at the end of this method.

You can test your method by adding this main method:
```Java
public static void main(String[] args){
	System.out.println("ITERATIVE TESTS");
	System.out.println("Iterative Factorial of 3 = " + factorialIterative(3) + " (expecting 6)");
	System.out.println("Iterative Factorial of 5 = " + factorialIterative(5) + " (expecting 120)");
	System.out.println("Iterative Factorial of 8 = " + factorialIterative(8) + " (expecting 40320)");
}
```
## 2. Recursive Factorial
An interesting pattern appears when you inspect the computation behind adjacent factorials:
- `3! = 3 * 2 * 1`
- `4! = 4 * (3 * 2 * 1) = 4 * 3!`
- `5! = 5 * (4 * 3 * 2 * 1) = 5 * 4!`

This is because the factorial operation can actually be mathematically defined recursively as `n! = n * (n - 1)!`. A factorial computation can be thought of as a slight extension to a slightly easier factorial computation. Whenever a problem can be solved by breaking it into smaller subproblems, a recursive solution presents itself.

Add the following method signature to `Factorial.java`:
```Java
public static int factorialRecursive(int n){

}
```

A recursive algorithm requires two components:
1. **Base Case(s)**: the simplest case(s) of the problem. There should be no recursive call in a base case.
2. **Recursive Case(s)**: the case(s) of the problem that need to be broken into further subproblems. A recursive case needs to make a recursive call that moves closer to a base case.

Let's start by writing the base cases. The simplest cases for factorial are when `n` is `0` or `1`, both of which evaluate to `1`. Add a base case that checks if `n` is `0` or `1` and returns `1` if true.

For factorials, if we aren't in the base case then we know we are in the recursive case. Outside of your base case, write a return statement that makes a recursive call to perform the computation `n * (n-1)!`. How would it look to translate this recursive mathematical expression into our Java code?

Test your method by adding these test cases to your main method:
```Java
System.out.println("\nRECURSIVE TESTS");
System.out.println("Recursive Factorial of 3 = " + factorialRecursive(3) + " (expecting 6)");
System.out.println("Recursive Factorial of 5 = " + factorialRecursive(5) + " (expecting 120)");
System.out.println("Recursive Factorial of 8 = " + factorialRecursive(8) + " (expecting 40320)");
```

## 3. Tail Recursive Factorial
Tail Recursion can be thought of a way to directly translate an iterative loop into a recursive process. This can be extremely useful in other programming languages, because not all languages have loops! In fact, recursion is the only way to create repetition in many useful programming languages called Functional Languages (which you can learn about in CSCI 2041!)

It is called Tail Recursion when the recursive call is always the last step before returning out of a method. It takes place at the *tail* end of the method.

This is in contrast to Non-Tail Recursion, like what you wrote for `factorialRecursive`, where at least one computation has to take place between the recursive call completing and returning out of the method. Even though the recursive call took place within the return statement in your implementation for `factorialRecursive`, notice that it still had to perform the final computation of multiplying that value by `n`.

Since we are simulating the iterative implementation of the method, it is helpful to look at our `factorialIterative` solution from the first part of the assignment. You had a loop variable that iterated through the numbers from `1` to `n`, and an accumulator variable that kept track of your product. 

Since the iterative implementation needed to keep track of two pieces of information, our tail recursive implementation needs to as well. Since we cannot keep variables in scope between method calls, in recursion we need to carry values with us by passing them in as parameters. This means we actually need to have two parameters in our Tail Recursive method-- one to act as a counter, and another to store the product so far.

But for the first two parts of this assignment, we were able to compute factorials by only passing in *one* parameter. We don't want to have to write code that has to remember to pass in a second parameter whenever we want to use our tail recursive implementation!

The solution to this issue is to use a **helper method**. There will be a primary method that can be called, and this will only take in one parameter like the other implementations of factorial. This primary method's only job is to call the helper method. Then the helper method will have the extra parameter, and this performs the tail recursive process.

Add the following method signatures to `Factorial.java`:
```Java
public static int factorialTailRecursive(int n){
	return ???;
}

private static int factorialHelper(int n, int product){

}
```

Start by replacing the `???` in `factorialTailRecursive` to complete the return statement. You will need to pass in a starting value for product. Remember, what value did you initialize the product variable to in `factorialIterative`?

Now we can move on to writing the tail recursive algorithm in `factorialHelper`. 

We once again need a base case and a recursive case. The base cases can be the same as in `factorialRecursive`, where if `n` is `0` or `1` it should evaluate to `1`.

Outside of the base case, our recursive case will simply be a return statement that makes a recursive call. We just need to figure out the arguments to pass in for the recursive call. 

`n` is acting as our counter variable, and we should iterate on this variable by making sure it moves closer to the base case. How can we pass a new value in for `n` that does this?

`product` is our accumulator variable, so it should keep track of the product so far. What computation should we perform to figure out the new value for `product`?

Test your method by adding these test cases to your main method:
```Java
System.out.println("\nTAIL RECURSIVE TESTS");
System.out.println("Tail Recursive Factorial of 3 = " + factorialTailRecursive(3) + " (expecting 6)");
System.out.println("Tail Recursive Factorial of 5 = " + factorialTailRecursive(5) + " (expecting 120)");
System.out.println("Tail Recursive Factorial of 8 = " + factorialTailRecursive(8) + " (expecting 40320)");
```

## Submission
Go to the Homework 2 submission on Gradescope, and add `Factorial.java` to the submission.

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
