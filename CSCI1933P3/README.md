# CSCI 1933 Project 3: ArrayLists vs. LinkedLists
Welcome to the third CSCI 1933 project! All students are expected to understand the rules listed below. While some rules may seem unforgiving, all guidelines are made to help the TAs grade efficiently and fairly. **As a result, we will generally not make exceptions.** Rules listed in the syllabus also apply but may not be listed here.

### **Make sure you read this entire write-up *carefully* before starting your project.**

### **Do not distribute or post this project outside of the course.**

* **Due Date:** The project is due on **Nov, 23** by **11:59** on **Gradescope**.
    * The project can be submitted up to two days late, with a penalty: -10% for each day late.

* **Identification:** Place you and your partner's x500 in a comment near the top of all files you submit. Failure to do so may result in a penalty.

* **Partners:**  You may work alone or with **one** partner. Failure to tell us who is your partner is indistinguishable from cheating and you will both receive a zero. Ensure all code shared with your partner is private.

* **Code:** You must use the **EXACT** class and method signatures we ask for. This is because we may use a program to evaluate your code. Code that doesn't compile will receive a significant penalty. Code should be compatible with Java 19, which is installed on the CSE Labs computers. Credit **ALL** outside references used in completing this project both in the INFO.txt and within the code that utilizes the referenced material.

* **Questions:** Questions related to the project can be discussed on Discord in abstract. This relates to programming in Java, understanding the writeup, and topics covered in lecture and labs. **Do not post any code or solutions on the forum.** Do not e-mail the TAs your questions when they can be asked on Discord via a help ticket.

* **Grading:** Grading will be done by the TAs, so please address grading problems to them privately through the ticket system on Discord.

* **INFO.txt:** Make sure to include a INFO.txt in your submission that contains the following information:
    * Group member's names and x500s
    * Contributions of each partner (if applicable)
    * Any assumptions
    * Additional features that your project had (if applicable)
    * Any known bugs or defects in the program
    * Credit **ALL** outside references used in completing this project both in the INFO.txt file **and** *within the code that utilizes the referenced material*.
    * Include the statement: **“I certify that the information contained in this INFO file is complete and accurate. I have both read and followed the course policies in the ‘Academic Integrity - Course Policy’ section of the course syllabus.”** and type your name(s) underneath.

### IMPORTANT: You are NOT permitted to use ANY built-in libraries, classes, etc for this project.

## Code Style (4 Points)
Part of your grade will be decided based on the "code style" demonstrated by your programming. In general, all projects will involve a style component. This should not be intimidating, but it is fundamentally important. 
<br>
### The following items represent “good” coding style:
* **Use effective comments** to document what important variables, functions, and sections of the code are for. In general, the TA should be able to understand your logic through the comments left in the code.
    * *Try to leave comments as you program, rather than adding them all in at the end. Comments should not feel like arbitrary busy work - they should be written assuming the reader is fluent in Java, yet has no idea how your program works or why you chose certain solutions.*
* **Use effective and standard indentation.**
* **Use descriptive names for variables.** Use standard Java style for your names: ```ClassName```, ```functionName```, ```variableName``` for structures in your code, and ```ClassName.java``` for the file names.

Try to avoid the following stylistic problems:
* Missing or highly redundant, useless comments. ```int a = 5; //Set a to be 5``` is not helpful.
* Disorganized and messy files. Poor indentation of braces (```{``` and ```}```).
* Incoherent variable names. Names such as ```m``` and ```numberOfIndicesToCount``` are not useful. The former is too short to be descriptive, while the latter is much too descriptive and redundant.

The programming exercises detailed in the following pages will both be evaluated for code style. This will not be strict – for example, one bad indent or one subjective variable name are hardly a problem. 
<br>
**However, if your code seems careless or confusing, or if no significant effort was made to document the code, then points will be deducted.**


## Pulling the Project Files

Git is a version control system that helps you track changes to files in a project. We have been using it in labs for a while now, and cloning this project will follow the same steps as a lab.

Open your terminal/command line, and navigate to the top of the `CSCI-1933-Student-Code` directory using the `cd` command. Now, type the following:

```bash
  git pull
```

#### Note: If you want to set up your own repository for this project, you will need to move the `project03` directory into your new repository. Make sure your new repository is PRIVATE, so your work is not visible to others (besides you and your partner).


## Project Structure

### EXTREMELY IMPORTANT: `package CSCI1933P3;` should be on the FIRST LINE of all java files you submit. This is necessary for the autograder to work.

### Inside of the project03 repository, you are given these files:
* List.java (DO NOT EDIT)
* Node.Java (DO NOT EDIT)
* These JUnit test files (DO NOT SUBMIT THESE):
    * ArrayListTest.java
    * LinkedListTest.java
    * ScoringTestRule.java
    * WorthPoints.java

### Your project submission must adhere to the following rules. Failure to do so will impact your grade.
* Your submission should be one ZIP file named ```<partner1 x500>_<partner2 x500>_Project3.zip```
    * This ZIP file should contain **ONLY** these files:
        * ArrayList.java
        * LinkedList.java
        * List.java
        * Node.Java
        * analysis.txt
        * **INFO.txt**

### For example, this is a valid project submission:
* kvant003_balle137_Project3.zip
    * ArrayList.java
    * LinkedList.java
    * List.java
    * Node.Java
    * analysis.txt/pdf
    * **INFO.txt**

# Interfaces and Generic Types

### IMPORTANT: Interfaces AND generics will be utilized in this project. This write-up only contains a brief recap of the main idea behind these concepts. For more information, please see a TA, review lecture material, or review other related literature (e.g. official Java documentation or zyBooks)

Similar to a class, interfaces *declare* methods. However, they never *define* them. They can be
thought of as an *outline* for a class. **ALL** methods declared in an interface must be *implemented*. In this project, `ArrayList.java` and `LinkedList.java` should implement the `List.java` interface.

In addition to interfaces, this project also heavily utilizes generic types (for this project, we will call the generic type `T`). Generic types make it so that we only need to create `ArrayList` and `LinkedList` classes, and we do not need to create separate classes any time we want to create a `List` of a certain type of object (meaning we do **NOT** need to create separate classes for `IntArrayList`, `StringArrayList`, etc.).

# List Implementations (80 Points)

Project 3 involves implementing list structures in two different data structures: `LinkedList` and
`ArrayList`. In addition, you will need to implement other operations on both those data structures.
You will then compare the time complexities of a select few list methods when implemented as an
`ArrayList` vs. a `LinkedList` in analysis.txt or analysis.pdf (either is acceptable).

#### IMPORTANT: Specifications for each method can be found in `List.java`, which is a Java interface.

### The following 17 methods should be implemented in for both ArrayList and LinkedList:
* `boolean add(T element)`

* `boolean add(int index, T element)`

* `void clear()`

* `T get(int index)`

* `int indexOf(T element)`

* `boolean isEmpty()`

* `int size()`

* `void sort()`

* `T remove(int index)`

* `void reverse()` **Note: You must reverse the list IN-PLACE (no intermediate data structures).**

* `void removeDuplicates()`

* `void exclusiveOr(List<T> otherList)`

* `boolean rotate()`

* `T getMin()`

* `T getMax()`

* `String toString()`

* `boolean isSorted()`

### Optimizations (6 Points)

The following methods need to be optimized in your `LinkedList` and `ArrayList` classes. If `isSorted` is true, then there should be an optimized case for these functions:

* `int indexOf(T element)`

* `void sort()`

* `T getMax()`
    * *Hint: Use a tail pointer in your* `LinkedList` *implementation*



## LinkedList Implementation (37 Points)

The first part of this project will be to implement a linked list. Create a class `LinkedList` that
implements all the methods in `List` interface (found in `List.java`). Recall that to implement the
`List` interface and use the generic compatibility with your code.
###  `LinkedList` should have following structure:
```Java
public class LinkedList<T extends Comparable<T>> implements List<T> {
    
...YOUR CODE HERE...

}
```

The underlying structure of a linked list is a node. This means you will have an instance variable
that is the first node of the list. The provided `Node.java` contains a generic node class that you
should use for your linked list implementation.

You may implement your linked list as a *headed* list, i.e., the first node in the list is a ‘dummy’ node and the second node is the first element of the list, or a non-headed list, i.e., the first node is the first element of the list. Depending on how you choose to implement your list, there will be some small nuances.

### Your LinkedList class should have a single constructor:

```Java
public LinkedList() {

...YOUR CODE HERE...

}
```

The constructor initializes the list to an empty list.

### Implementation Details
In addition to the methods described in the `List` interface, the `LinkedList` class should
contain a private class variable `isSorted`. This should be initialized to `true` in the constructor
(because it is sorted if it has no elements) and updated when the list is sorted, more elements
are added, the list is rotated, and more. For the purposes of this class, `isSorted` is only true
if the list is sorted in ascending order. More details about `isSorted` can be found in the
description of methods in the `List` interface.

Initially and after a call to `clear()`, the size should be zero and your list should be empty.

In `sort()`, **do not use an array or ArrayList** to sort the elements. You are required to
sort the values using only the linked list data structure. You can move nodes or swap values
but you cannot use an array to store values while sorting.

Depending on your implementation, remember that after sorting, the former first node may
not be the current first node.

## ArrayList Implementation (37 Points)

The second part of this project will be to implement an array list. Create a class `ArrayList` that
implements all the methods in `List` interface. Recall that to implement the `List` interface and use the generic compatibility with your code. 

### `ArrayList` should have following structure:

```Java
public class ArrayList<T extends Comparable<T>> implements List<T> {
    
...YOUR CODE HERE...

}
```

The underlying structure of an array list is (obviously) an array. This means you will have an
instance variable that is an array. Since our implementation is generic, the type of this array will
be `T[]`. Due to Java’s implementation of generics <a href="https://docs.oracle.com/javase/tutorial/java/generics/erasure.html">(type erasure)</a>, you **CANNOT** simply create a generic array
with: `T[] a = new T[size];`

Rather, you have to create a `Comparable` (since `T extends Comparable`) array and cast it to an
array of type `T`.

```Java
T[] a = (T[]) new Comparable[size];
```

#### Sidenote: Had `T` not extended `Comparable`, you would say `T[] a = (T[]) new Object[size];`

### Your LinkedList class should have a single constructor:

```Java
public ArrayList() {

...YOUR CODE HERE...

}
```

The constructor initializes the underlying array to a length of 2.

### Implementation Details

In addition to the methods described in the `List` interface, the `ArrayList` class should contain
a private class variable `isSorted`. This should be initialized to `true` in the constructor
(because it is sorted if it has no elements) and updated when the list is sorted, more elements
are added, the list is rotated, and more. For the purposes of this class, `isSorted` is only true if the list is sorted in ascending order. More details about `isSorted` can be found in the
description of methods in the `List` interface.

When the underlying array becomes full, both `add` methods will automatically add more
space by creating a new array that is **twice the length of the original array**, copying over
everything from the original array to the new array, and finally setting the instance variable
to the new array. 
<br>
*Hint: You may find it useful to write a separate private method that does the growing and copying*

When calling the `remove` method, the underlying array *should no longer have that spot.* For
example, if the array was `["hi", "bye", "hello", "okay", ...]` and you called `remove` with index 1, the array would be `["hi", "hello", "okay", ...]`. Basically, the only `null` elements of the array should be **after** all the data.

Initially and after a call to `clear()`, the `size` method should return `0`. The "size" refers to
the **number of elements in the list** , **NOT** the length of the *array*. After a call to `clear()`, the underlying array should be reset to a length of `2` as in the constructor.

# Unit Tests

### IMPORTANT: MAKE SURE TO TEST YOUR CODE USING THE GIVEN UNIT TESTS. A VERY LARGE PORTION OF YOUR FINAL GRADE WILL DEPEND ON WHETHER THE UNIT TESTS PASS OR FAIL.

We will be using a program to evaluate your code. Specifically, we will be using JUnit (unit tests)
to test each method that you implement. You will be provided the same tests that will be used for
grading so you can verify the accuracy of the methods you write. At the bottom of this project write-up, a <a href="https://github.umn.edu/CSCI-1933/project03#junit-primer">DOCUMENT</a> discusses how to run these JUnit tests (in IntelliJ).

#### NOTE: Unit tests files should NOT be included in submission

### IMPORTANT: Many of the unit tests rely on more than one of your functions in order to work properly. In particular, all of the tests will fail until `get()` and both `add()` methods are implemented. It is also suggested that you implement methods such as `size()` and `remove()` first since tests for other functions will rely on those methods.

# Runtime Analysis (16 Points)

Now that you have implemented and used both an array list and linked list, which one is better?
Which methods in `List` are more efficient for each implementation?

For a few of the methods (specified below) in `List`, compare the runtime (Big-O) for each method
and implementation. Ignore any increased efficiency caused by the flag `isSorted`. 

### Include an `analysis.txt` or `analysis.pdf` with your submission structured as follows:

```
Method                  ArrayList Runtime       LinkedList Runtime      Explanation
boolean add(T element)  O(...)                  O(...)                  ...
T getMax()              O(...)                  O(...)                  ...    
.                       .                       .                       .
.                       .                       .                       .
```

### Write an analysis of the complexity of these four methods:

* `add(T element)` method

* `getMin()` method

* `removeDuplicates()` method

* `reverse()` method

Your explanation for each method only needs to be a couple sentences briefly justifying your runtimes.

# Grading
### The following weight will be given to each category (NOTICE HOW MUCH OF YOUR GRADE DEPENDS ON THE UNIT TESTS):

* **Unit Tests:** 80%

* **Runtime Analysis:** 16%

* **Code Style:** 4%

# JUnit Primer

## Introduction
This document is intended to give you the information necessary to run the provided unit tests
against your project. It is not intended to be a comprehensive guide on JUnit or unit tests in
general. If you want to learn more, please visit the <a href="https://junit.org/junit4/">JUnit Documentation</a>. The provided test files are what your TAs will be using to grade your project, and the tests will contribute a significant portion of your grade for Project 3, so it is obviously in your best interests to make sure your project passes as many tests as possible.

The files you will need to run the tests are `ArrayListTest.java`, `LinkedListTest.java`, `ScoringTestRule.java`, and `WorthPoints.java`. All of these files should be placed in your source code folder (the src folder in IntelliJ). Do not modify any of the provided files.

## Getting Started with JUnit

After adding the test files to your src folder, you will need to add the JUnit testing libraries to
your project. In IntelliJ, this is as simple as putting your cursor over one of the statements im-
porting a JUnit library in one of the test files (these statements should be red at first), pressing
`ALT+ENTER`, then selection **version 4** of JUnit from the drop down menu. **Only version 4 of
JUnit will work with the tests given.**

If you have any issues with import the JUnit library, you can start by looking at the <a href="https://www.jetbrains.com/help/idea/testing.html#add-testing-libraries">official IntelliJ article </a> for importing the library for testing.

## What to Understand

The only code you need to understand is in the `LinkedListTest.java` and `ArrayListTest.java` files.
Each test method in the files will be marked with an `@Test` flag. Tests that contribute to your score will have a `@WorthPoints` flag as well, indicating how many points that test is worth. Inside each method, there will be some statements calling methods of the `List` interface that you implemented and some **Assertions**. A test only passes if all of the assertions in the definition pass. 
### For example, consider the following test:
```Java
@Test
public void ExampleTest() {
    /*
    Do some stuff here: initialize variables a, b, c, d, and e, call test methods,
    etc.
    */
    assertFalse(a);
    assertTrue(b);
    assertNull(c);
    assertEquals(d, e);
}
```

This test will only pass if **a is false, b is true, c is null, and d and e are equal**. Otherwise, the entire test **fails**. You may also see Strings to be printed if an assertion fails as arguments to an assertion; note that they are only there to help explain why the assertion may have failed and are not part of the actual test.

## Running Tests
To run the tests in IntelliJ, click the green circle to the left of the class declaration in the
`LinkedListTest.java` or `ArrayListTest.java` files. This runs all tests in that class. Each test should have an identical green circle to the left of it. Click that circle to only run that test. After running any test(s), any failed assertions are underlined in red, which should help in debugging. You can also use the debugger in test classes to further assist in your debugging efforts. If you want to run the tests in some IDE other than IntelliJ or without an IDE at all, you will unfortunately have to do some research and figure out how to do this on your own, as the TAs are only knowledgeable about IntelliJ.

# Acknowledgements

* Planets AL vs. LL Project created by Prof. Chad Meyers and TAs - October 2016

* Unit Tests created by hoang159 - Fall 2017

* Project updated by Prof. Chris Dovolis and TAs - Spring 2021

* New Unit Tests created by UTA, Noah Park - Spring 2021

* Project updated, revised, and ported to Gradescope by UTA, Adam Kvant - May 2024

* Project ported to GitHub - UTAs: Samantha Ballesteros, Adam Kvant - May 2024

* Project maintained by TAs: parhi003, snyde479, shino012, kumar093, hoang159, zoell031, hough083, gilbe918, marki039, dieth011, truon351, ulric244, stear137, elgoh003, balle137, moren380, busac016, kelm0041, and kvant003
