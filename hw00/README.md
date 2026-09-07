# 1933 Homework 0: Compilation

Java is called a **compiled language**, which is in contrast to an **interpreted language** like Python. When you run a Python file, your computer runs a program called an interpreter that reads and executes the source code line by line, all while the program is running. A compiled language like Java works differently-- it cannot run on the source code that you write but only can run **machine code**, which is a series of 1s and 0s that represent the exact instructions of the program. This means the programmer needs to "translate" the program from source code to machine code prior to running the program. This translation process is called **compilation**, which produces a new executable file full of machine code that the computer knows how to run.

Compilation has a few benefits. While interpreted languages need to perform this translation to machine code for every line during the runtime of the program, compiled languages have done the translation ahead of time, so the program runs faster. The computer also requires that the code has proper syntax to successfully compile, so the programmer will be made aware of any syntax errors right at compile time instead of having to discover them later at runtime.

In this assignment, you will install Java on your personal machine, write a simple program, and compile this program into an executable file.

### Associated zyBooks Reading
- 1.1 Getting started in Java
- 1.2 Classes and objects

## 1. Getting Set Up
You should install the Java Development Kit, or JDK for short, on your personal computer so your machine is capable of compiling and running Java files. Note that we expect you to use Java 17 or higher for this course. Use the following guide to install it correctly for your machine.

- First, go [HERE](https://www.oracle.com/java/technologies/downloads/) to find the most recent versions of the JDK.
- **What Operating System is your computer?**
    <details>
    <summary>Windows</summary>
    
    - Click on Windows
    - Download `x64 Installer`
    - Double Click on the downloaded file
    - Follow the installation process
    
    </details>
    <details>
    <summary>macOS</summary>
    
    - Click on macOS
    - **What kind of CPU chip do you have?**
      
        <details>
        <summary>M1/M2/M3/M4 (newer, 2020 onward)</summary>
        
        > Download `ARM64 DMG Installer`
        </details>
        
        <details>
        <summary>Intel (older, pre-2020)</summary>
        
        > Download `x64 DMG Installer`
        </details>
    
    - Double Click on the downloaded file
    - Follow the installation process
    
    </details>
    <details>
    <summary>Linux</summary>
    
    - Click on Linux
    - **What kind of Linux distribution (OS) are you running?**
    
        <details>
        <summary>Ubuntu / Debian / Mint / Pop!_OS</summary>
        
        > Download `x64 Debian Package`
        </details>
        
        <details>
        <summary>Fedora / RedHat / Rocky Linux</summary>
        
        > Download `x64 RPM Package`
        </details>
        
        <details>
        <summary>Other (Arch Linux, Raspberry Pi, etc.)</summary>
        
        > Download the `Compressed Archive` that matches your CPU (x64 or ARM64)
        </details>
    - Install the downloaded package using your system's package manager or terminal.
  </details>

## 2. Writing a Java Program

#### File Creation
First you should create a new file, and name it `Hello.java` (make sure it has the capital `H`!). Any files with the `.java` file extension represent source code, where programmers can write and edit their Java code.

#### Class Definition
In Java, all code needs to be placed inside of a class. Every class should be placed in its own `.java` file, and the class needs to have the same name as the file. Add this class definition to `Hello.java`:

```Java
public class Hello {

}
```

The curly brackets `{ }` define code blocks. All of the code that you want to be inside of this class needs to be between the two curly brackets.

#### Main Method
Next we'll create a `main` method, which holds the code that will run every time to execute your program. Add the following code *inside* of the `Hello` class, so the entirety of the main method is between the class's curly brackets:

```Java
public static void main(String args[]){

}
```

#### Print Statement
Now we can add code that we want to execute. For this assignment we'll just print some text to the terminal. Add this print statement inside of your main method, which will output `"Hello!"`.

```Java
System.out.println("Hello!");
```

**Modify the print statement so it outputs** `My name is <YOUR NAME> and I'm taking CSCI 1933!`

#### Indentation
Indentation has no effect on how Java executes code, but it is considered good style to indent code blocks for readability. This makes it much easier to tell which code blocks are nested inside of which other code blocks. 

Since the `main` method is inside of the `Hello` class, make sure it is indented to the right of the class definition. Since the print statement is nested inside of the `main` method, make sure it is indented to the right of the method definition.

Your code should now be structured like this:

```
CLASS {
	MAIN {
		PRINT()
	}
}
```

## 3. Compilation
Now that we have created our source code, we can try compiling it and running the program.

Open a terminal, and navigate to the directory where your `Hello.java` file is located. Remember you can use `cd <directory name>` to change directories, `cd ..` to go up one directory, and `ls` to list all the files in a directory.

#### Compiling with `javac`
Once you are in the proper location, you can compile the file with the following command:

```
javac Hello.java
```

Remember that the `javac` command is how you compile, because it is short for "**Java C**ompile"!

The compilation process will first check for any syntax errors. If it finds any issues, it will print to the terminal telling you where the syntax error is. 

Otherwise if the command runs with no output, that means it has successfully compiled. If you run `ls` you will see that a new file named `Hello.class` has been generated. This is the compiled machine code version of the file, which Java knows how to run.

#### Running a file with `java`
You can execute this file with the following command:

```
java Hello
```

Notice that the command to *run* is just `java`, which doesn't have the `c` at the end like the command to compile.

You should see that this outputs your print statement in the terminal. Java has successfully executed your compiled program!

## Submission
Go to the Homework 0 submission on Gradescope, and add **both** `Hello.java` and `Hello.class`. For most assignments in 1933 you will only need to submit your source code (`.java`), but since this assignment is focused on compilation, you will also submit your compiled file (`.class`).

Gradescope will run the autograder and show you your score. If any of the tests don't pass, read the error messages which indicate what went wrong, update your code to fix the issues, and resubmit to Gradescope as many times as you want before the due date.
