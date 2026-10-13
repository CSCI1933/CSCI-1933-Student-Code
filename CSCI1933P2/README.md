# CSCI 1933 Project 2: 2D Arrays, Inheritance, and Chess!

## Table of Contents

* <a href="#csci-1933-project-2-2d-arrays-inheritance-and-chess"><b>Project Write-Up</b></a>

* <a href="#junit-primer"><b>JUnit Primer</b></a>

* <a href="#chess-rules"><b>Chess Rules</b></a>


Welcome to the second CSCI 1933 project! All students are expected to understand the rules listed below. While some rules may seem unforgiving, all guidelines are made to help the TAs grade efficiently and fairly. **As a result, we will generally not make exceptions.** Rules listed in the syllabus also apply but may not be listed here.

### **Make sure you read this entire write-up *carefully* before starting your project.**

### **Do not distribute or post this project outside of the course.**

* **Due Date:** The project is due on **Mon, Nov 2** by **11:55** on **Gradescope**.
    * The project can be submitted up to two days late, with a penalty: -10% for each day late.

* **Identification:** Place you and your partner's x500 in a comment near the top of all files you submit. Failure to do so may result in a penalty.

* **Partners:**  You may work alone or with **one** partner. Failure to tell us who is your partner is indistinguishable from cheating and you will both receive a zero. Ensure all code shared with your partner is private.

* **Code:** You must use the **EXACT** class and method signatures we ask for. This is because we may use a program to evaluate your code. Code that doesn't compile will receive a significant penalty. Credit **ALL** outside references used in completing this project both in the INFO.txt and within the code that utilizes the referenced material.

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

### IMPORTANT: You are NOT permitted to use ANY built-in libraries, classes, etc... EXCEPT `java.util.Scanner`. Double check that you have NO import statements in your code, except for those explicitly permitted.

## Code Style (10 Points)
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


## Local Compilation & Run Instructions
* In your terminal make sure that you are in the `CSCI-1933-Student-Code` directory NOT the `CSCI1933P2` directory.
    * If you are inside of the `CSCI1933P2` directory, type `cd ..` into the terminal and press enter.
* To compile your code locally type `javac CSCI1933P2/Game.java` into the terminal and press enter.
* To run your code locally type `java CSCI1933P2.Game` into the terminal and press enter.
* **IMPORTANT: Do not submit any .class files to gradescope, the only files you should submit are found below.**

## Project Submission Structure
### Inside of the project02 repository, you are given these files:
* Pawn.java
* Fen.java (DO NOT EDIT)
* Piece.java
* Board.java
* These JUnit test files (DO NOT EDIT OR SUBMIT THESE):
    * Category.java
    * ScoringRule.java
    * TestAllMoves.java
    * WorthPoints.java
    * bools.txt

### Your project submission must adhere to the following rules. Failure to do so will impact your grade.
* Your submission should be one ZIP file named ```<partner1 x500>_<partner2 x500>_Project2.zip```
    * This ZIP file should contain **ONLY** these files:
        * Pawn.java
        * Bishop.java
        * Knight.java
        * Rook.java
        * Queen.java
        * King.java
        * Fen.java (DO NOT EDIT)
        * Piece.java
        * Board.java
        * Game.java
        * **INFO.txt**

### For example, this is a valid project submission:
* kvant003_balle137_Project2.zip
    * Pawn.java
    * Bishop.java
    * Knight.java
    * Rook.java
    * Queen.java
    * King.java
    * Fen.java (DO NOT EDIT)
    * Piece.java
    * Board.java
    * Game.java
    * **INFO.txt**

## Pulling the Project Files

Git is a version control system that helps you track changes to files in a project. We have been using it in labs for a while now, and cloning this project will follow the same steps as a lab.

Open your terminal/command line, and navigate to the top of the `CSCI-1933-Student-Code` directory using the `cd` command. Now, type the following:

```bash
  git pull
```

#### Note: If you want to set up your own repository for this project, you will need to move the `project02` directory into your new repository. Make sure your new repository is PRIVATE, so your work is not visible to others (besides you and your partner).



## Chess Introduction
Chess is a centuries-old game of logic and skill originating from India. The game is played on an 8x8 grid between two players. Each player has 16 pieces: 8 Pawns, 2 Rooks, 2 Knights, 2 Bishops, 1 Queen, and 1 King. Traditionally, one player’s pieces are white and the other’s are black. Each piece has its own set of rules about where it can move, and how it can ”capture” the other player’s pieces. The goal of the game is to capture your opponent’s King.

Chess is a game of many rules, but we have reduced it slightly to a set of rules which we think you can implement. We will discuss the specific rules that must be followed in section 3. Unless a rule is specifically mentioned in this writeup, assume that you need not implement it.

#### Note: If you are unfamiliar with Chess, there is a <a href="https://github.umn.edu/CSCI-1933/project02#chess-rules">SECTION</a> at the bottom of this document that contains a brief overview of Chess basics.

# Project Structure

This section outlines the overall structure of the chess app you will be writing.

### IMPORTANT, READ ALL OF THESE POINTS:

* #### IntelliJ will be required for this project, as you will be creating a project file and running JUnit tests on your code. If you need to review how to create a new project in IntelliJ, please refer to the “Setting up IntelliJ” section from the Lab 4 document. Also, please read the testing document at the bottom on how to install and run JUnit tests on IntelliJ.

* #### Things to keep in mind: IntelliJ **DARK MODE** will make the **white pieces appear black** and **black pieces appear white** in the terminal. Also, for the sake of testing and grading, **white pieces** will be required to go **UPWARD** and **black pieces** will be required to go **DOWNWARD** (in terms of how they appear on screen).

### EXTREMELY IMPORTANT: `package CSCI1933P2;` should be on the FIRST LINE of all java files you submit. This is necessary for the autograder to work.

## Board.java (35 Points)

For this project you will be required to implement a class called `Board.java`. This class will serve as the representation of a chess board. Your board must be represented as a 2-Dimensional array of type `Piece`. Using this structure allows us to keep each piece on the board while representing them with different classes, but more on that in the next section.

We have already given you method signatures for this class, but it will be your job to implement algorithms that achieve their stated goals. You are welcome to create your own helper methods if you want, but you **should not modify the existing method signatures** as this will interfere with any tests we run as part of grading this project.

#### Note: Specific method definitions, hints, and constraints for the aforementioned functions can be seen in the given Board.java file.

### As a part of ``Board.java``, there are several functions that you will need to implement:

* `public Board()`: Constructor that initializes the 2D Piece array representing the board.

* `public Piece getPiece(int row, int col)`: Gets the piece at a location in the 2D board array.

* `public void setPiece(int row, int col, Piece piece)`: Sets the piece at a location in the 2D board array.

* `public boolean movePiece(int startRow, int startCol, int endRow, int endCol)`: Moves the piece at the start location to the end location, provided it is legal to do so. Make sure you call the isMoveLegal() method here.
    * **Note: `Piece` objects have an internal positon (their own row and col variables) make sure to update these. Make sure to clear the starting location on the 2D board array.**

* `public boolean isGameOver()`: Checks if the board is in a game over state or not (if the board does not contain a King of each color or the board has fewer than two kings), then the game is over.

* `public void clear()`: Sets every square in the board equal to null.

### In addition to the above methods, you will also implement several methods that will be useful in your piece classes to determine the legality of a move.

* `public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack)`: This function performs verification checks on the source and destination of a move and returns `true` if all of the checks pass.
    * **Note: Look at the comment above this method and the other methods in this section. They may be helpful in implementing these methods.**

* `public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol)`: This function verifies that the source and destination of a move are adjacent squares (within 1 square of each other). For example, this is how the King moves.

* `public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol)`: his function performs verification checks for horizontal movement and returns `true` if all of the checks pass.

* `public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol)`: Similar to `verifyHorizontal`, but for vertical moves.

* `public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol)`: Similar to `verifyHorizontal` and `verifyVertical`, but for diagonal moves.

    * **Hint: The pattern for detecting whether two squares are on the same diagonal can be difficult to spot if you’ve never seen it before. The pattern is different, but related, for diagonals going one direction vs. diagonals going the other direction. Consider the following two examples. What patterns do you notice between the row number and the column number?**

        * <table border="1"><tr><td>row</td><td>0</td><td>1</td><td>2</td><td>3</td><td>4</td></tr><tr><td>col</td><td>4</td><td>3</td><td>2</td><td>1</td><td>0</td></tr></table>

        * <table border="1"><tr><td>row</td><td>3</td><td>4</td><td>5</td><td>6</td><td>7</td></tr><tr><td>col</td><td>0</td><td>1</td><td>2</td><td>3</td><td>4</td></tr></table>

#### Note: While not required, it can often be helpful to use `Math.min`, `Math.max`, and `Math.abs` to take advantage of the inherently symmetrical nature of many of these checks. You are encouraged to use these functions to reduce the amount of code you need to write.

## Piece.java (Abstract Class) (2 Points)

The `Piece` abstract class is very important for the operation of this project. As you’ve learned in lecture, Java arrays cannot be defined to have more than one type. This presents a problem for us, as we want to represent 6 different types of piece on the board at once. 

The `Piece` abstract class allows us to create this array of 6 different types. An abstract class in Java is half `class` and half `interface`; some methods in an abstract class are defined, while some are only declared.

Defined methods must have their bodies of their methods completed by you. Defined methods exist in the `Piece` abstract class because they are methods whose functionality is needed in every `Piece` subclass.

Declared methods are method stubs that have no body (notice the `abstract` keyword in the `isMoveLegal` method stub). This method needs to be **defined** in every subclass that `extends` the `Piece` abstract class.

The `Piece` abstract class also contains some instance variables that relate to the subclass's internal attributes (``row``, ``col``, ``isBlack``, ``representation``). These will be set in the subclass's constructor using the ``super.<insert variable name here>`` keyword. For example, in the `Pawn` class's constructor, ``super.row = row;`` assigns the `row` variable in the `Pawn` class's instance of the parent class (`Piece`). The `super.` keyword is essentially the same as `this.`, but it accesses the **Parent** class of the current instance, rather than the current instance.

#### IMPORTANT: Once you’ve downloaded the code pack, notice how in `Board.java` you are tasked with implementing `movePiece()`. While this function should updates the state of the board if a move is valid, it should also be updating the piece’s **instance variables!** What function from `Piece.java` updates the position of the piece object? This function should be used in `movePiece()`

## Game.java
`Game.java` is the class which contains this project’s `main` method. Within this `main` method you must create an interactive terminal experience for the players to interact with throughout the game. This class will instantiate the `Board` object and prompt the user for input. A visual representation of the board must be printed at the beginning of each player’s turn (Hint: use the `Board` class's `toString()` or `display()` methods). The user should enter a starting point and an ending point for a piece of their color. For example, when it’s **white’s turn**, only **white pieces** can move. All other work to execute the user’s turn should happen elsewhere. The game should end when one player’s King has been "captured".

### As a sample of what a turn could look like, consider this position which begins in the final state of the famous "Immortal Game" and, in this case, ends when the white bishop captures the opponents King.
<img src="/images/example.png" alt="An example of this project's user interface.">

## FEN.java
We have supplied you with a class called `Fen.java` which is a tool for both setting the board to its starting state, and testing your work. It is based on Forsyth-Edwards Notation which is a method for saving the position of every piece on a chess board in 71 characters or less (usually much less). Understanding the way it works isn’t critical for the project, but you can read more about it <a href="https://en.wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation">HERE</a>.

### The class contains only one method:

* `public static void load(String fen, Board b)`: **Input:** A FEN code in `String` format, and an instance of the `Board` class.

### Because this method is static, you will need to reference the entire class when calling it. To initialize starting position, this may look like:

`Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", myBoard)`

#### Note: Don’t worry if that string looks a little scary, we have included a handful of useful strings that you can use when testing. They are found at the TOP of the `Fen.java` file in the comments. You do not need to know how to make FEN strings yourself.

## Chess Piece Classes (Pawn.java, Bishop.java, King.java, Queen.java, Rook.java, Knight.java)

### Pawn.java and promotePawn

The Pawn.java class is nearly complete, and shows how the other classes listed above should be created.

If you are stuck while making another one of these piece classes, refer back to the `Pawn` class.

#### IMPORTANT: The only thing you need to edit in `Pawn.java` is the `promotePawn` method.

The `promotePawn` method should verify that the `Pawn` object is at the end of its opponent's side of the `Board`. If the `Pawn` object is at the end of its opponent's board, then the method should prompt for user input. The user can input their choice for their newly promoted piece (`Bishop`,`Knight`,`Rook`, or `Queen`). The pawn should then be replaced with the new piece instance inside of the board. **Remember to set the new piece's instance variables properly!**

#### Other Piece Classes (Bishop.java, King.java, Queen.java, Rook.java, Knight.java) (35 Points)

#### These piece classes will all follow a similar structure, with:

* A **constructor**, which takes in parameters: `(int row, int col, boolean isBlack)`

* `public boolean isMoveLegal(Board board, int endRow, int endCol)`
    * **Input:** The state of the board, the destination row of the move, and the destination column of the move.
    * **Output:** Whether the piece can move from its current location to the destination provided, given the current board state.


#### IMPORTANT: Please look at the <a href="https://github.umn.edu/CSCI-1933/project02#chess-rules">RULES</a> document for more information on how to implement certain pieces, especially the pawn with its pawn promotion. The rules document can be found at the bottom of this file.

#### Note: In general, `isMoveLegal` functions for the chess piece classes, i.e Queen, Rook, Bishop or etc, should use `Board.java`’s `verifySourceAndDestination()` and any respective movement verification, i.e `verifyVertical()`, `verifyHorizontal()`, `verifyDiagonal`, etc. Although `Pawn.java` offers some good insight to the project in general, it shouldn’t necessarily be the basis for other chess piece class implementations.

### Unicode for the Other Piece Classes
Unicode characters are very important for this project, as they give us a very easy was to represent the chess pieces in terminal. Unicode is an expanded library of characters designed to make up for ASCII’s lack of support for non-Latin alphabets. On top of supporting many languages, Unicode also has many miscellaneous symbols. Luckily for us this includes both white and black chess pieces! 
#### Here are the Unicode "codepoints" for each white and black piece, respectively:

<table border="1">
<tr><th>Piece</th> <th>White</th> <th>Black</th></tr>
<tr><td>King</td> <td>\U2654</td> <td>\U265A</td></tr>
<tr><td>Queen</td> <td>\U2655</td> <td>\U265B</td></tr>
<tr><td>Rook</td> <td>\U2656</td> <td>\U265C</td></tr>
<tr><td>Bishop</td> <td>\U2657</td> <td>\U265D</td></tr>
<tr><td>Knight</td> <td>\U2658</td> <td>\U265E</td></tr>
<tr><td>Pawn</td> <td>\U2659</td> <td>\U265F</td></tr>
</table>

When using Unicode characters in Java, we define a variable of type char, and initialize it with the codepoint. For example, to initialize a white pawn we say: `char pawn = '\u2659'`. Your computer’s terminal may not support Unicode right out of the box, but IntelliJ should and is easy to configure if not. 

One thing to note when printing the board to the terminal is that the Unicode chess pieces do not occupy the same spacing as a typical "space" character. Instead, we will use one of the Unicode space characters, `'\u2001'`, which has the same spacing as the pieces. You may also take advantage of special unicode characters for the row and column numbers. Integers 0...9 are coded with `'\uFF10'...'\uFF19'`.

#### Note: There are two bugs to look out for with these Unicode characters. One bug is that since Unicode also encodes emojis, the black pawn occasionally prints as an emoji instead of the plain text character. This is problematic because the emoji occupies more horizontal space than the plain text pieces. This throws the spacing of our board off by a bit, but you WILL NOT be penalized for that. Another bug is that because you are required to use IntelliJ, most students uses its "dark mode" feature. This will make white pieces appear black and black pieces to appear white, please keep this in mind when displaying your chess board, but you WILL NOT be penalized for this either.

# Unit Tests
As mentioned at the beginning of this project document, you will be using JUnit tests to test your code. A <a href="#junit-primer">DOCUMENT</a> below will explain how to run these tests.

### ALL TESTS MUST BE RUN AT ONCE, NOT INDIVIDUALLY.

### IMPORTANT: Please make sure to to test all of your code, as a good portion of this project’s grade will depend on your JUnit tests passing or failing.

### DO NOT include the JUnit test files with your submission (Category.java, ScoringRule.java, TestAllMoves.java, WorthPoints.java, bools.txt)

# Grading

* **Code Style:** 10%

* **JUnit Tests:** 70% (2 * 35%)

* **Game Implementation:** 20%


# JUnit Primer

## Introduction
This document is intended to give you the information necessary to run the provided unit tests
against your project. It is not intended to be a comprehensive guide on JUnit or unit tests in
general. If you want to learn more, please visit the <a href="https://junit.org/junit4/">JUnit Documentation</a>. The provided test files are what your TAs will be using to grade your project, and the tests will contribute a significant portion of your grade for Project 3, so it is obviously in your best interests to make sure your project passes as many tests as possible.

The files you will need to run the tests are `Category.java`, `ScoringRule.java`, `TestAllMoves.java`, `WorthPoints.java`, and `bools.txt`. All of these files should be placed in your source code folder (the src folder in IntelliJ). Do not modify any of the provided files.

## Getting Started with JUnit

After adding the test files to your src folder, you will need to add the JUnit testing libraries to
your project. In IntelliJ, this is as simple as putting your cursor over one of the statements importing a JUnit library in one of the test files (these statements should be red at first), pressing
`ALT+ENTER`, then selection **version 4** of JUnit from the drop down menu. **Only version 4 of
JUnit will work with the tests given.**

If you have any issues with import the JUnit library, you can start by looking at the <a href="https://www.jetbrains.com/help/idea/testing.html#add-testing-libraries">official IntelliJ article </a> for importing the library for testing.

## What to Understand

The only code you need to understand is in the `TestAllMoves.java` file.
Each test method in the files will be marked with an `@Test` flag. Tests that contribute to your score will have a `@WorthPoints` flag as well, indicating how many points that test is worth. Inside each method, there will be some statements calling methods of the `List` interface that you implemented and some **Assertions**. A test only passes if all of the assertions in the definition pass.

#### Note: The `sourceAndDestination()` test has been obfuscated. You don't need to try and understand this code. All other tests in this folder are easily human-readable.

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

### ALL TESTS MUST BE RUN AT ONCE, NOT INDIVIDUALLY.

To run the tests in IntelliJ, click the green circle to the left of the class declaration in the`TestAllMoves.java` file. This runs all tests in that class. Each test should have an identical green circle to the left of it. Click that circle to only run that test. After running any test(s), any failed assertions are underlined in red, which should help in debugging. You can also use the debugger in test classes to further assist in your debugging efforts. If you want to run the tests in some IDE other than IntelliJ or without an IDE at all, you will unfortunately have to do some research and figure out how to do this on your own, as the TAs are only knowledgeable about IntelliJ.

# Chess Rules
For the following piece sections we will be using the notation (row, column) instead of
(x-pos, y-pos) because it reflects the convention that a 2D array is referenced as `arr[row][column]`.

#### Note: In the `Board.java` class, you will be implementing several helper functions that account for common ways that pieces can move. These helper functions should be called in many of the piece classes in the `isMoveLegal` function.

## Starting Positon

The starting position of the game should look like the following diagram. The movement of each piece will be described in further detail later in this writeup. Remember that the provided `Fen` class will be useful for setting up the board to a specific state.

<img src="/images/starting_position.png" alt="Image of the starting position in Chess.">

## Pawn
The Pawn is the most simple piece on the board. It can move only one position at a time, and
only forwards vertically or diagonally. If it is making its very first move, however, it may move two positions straight forward. This makes it a less useful piece than the other listed below, but it has one ace up its sleeve. If a player’s pawn reaches the opposite end of the board before being captured, then it is promoted. In this situation, the pawn can be turned into any other piece aside from a king (and a pawn). This makes it quite a powerful piece... if you can cross the entire board one square at a time that is. While we have given you a filled out `Pawn.java` class, **you must implement pawn promotion yourself.**

#### Hint: Pawn promotion will be most easily implemented within Pawn.java. Pawn promotion should occur when a player’s pawn reaches the first or last “row” of the 2D Array, when this happens, you will prompt the player using Scanner to enter the name of the piece they want to promote it to besides the king (and pawn).

## Rook

The Rook is one of the most powerful pieces in the game, with the ability to move both **horizontally and vertically**, provided that no other pieces (of either color) are obstructing its path. 

Below are some examples of the rook’s movement. Note that the rook is on location (2, 3). 

Not pictured in the diagram is that it would be legal for the rook to “capture” the black pawn on location (4, 3), but it would not be legal for the rook to move to the white pawn at location (2, 6).

<img src="/images/rook_obstructed.png" alt="Rook Diagram 1.">
<img src="/images/rook_unobstructed.png" alt="Rook Diagram 2.">

## Bishop

The Bishop is another powerful piece, as it can move any distance. However, this piece moves only **diagonally**. Like the rook, it can only move provided its path is not blocked by another piece. 

Below are some examples of the bishop’s movement. Note that the bishop is on location (2, 3). 

Not pictured in the diagram is that it would be legal for the bishop to “capture” the black pawn on location (4, 5), but it would not be legal for the bishop to move to the white pawn at location (4, 1).

<img src="/images/bishop_obstructed.png" alt="Bishop Diagram 1.">
<img src="/images/bishop_unobstructed.png" alt="Bishop Diagram 2.">

## Knight
The Knight is a bit of a wildcard compared to the other pieces in chess. All of the other pieces move linearly, but the knight moves in what is often referred to as an “L” shape. This means that it **moves 2 squares out (either horizontally or vertically)** from its place, and then **1 additional square out perpendicular to the direction of the first movement**. **The knight is also the only piece which can skip over another piece.** This means it may move to a new position even if there is another piece blocking the direct path. 

Below are some examples of the knight’s movement. Note that the knight is on location (2, 3). 

Not pictured in the diagram is that it would be legal for the knight to “capture” any piece of the opponent’s color **iff** it is in the position the knight is moving to. The knight may not move to a position which has a friendly piece.

<img src="/images/knight_obstructed.png" alt="Knight Diagram 1.">
<img src="/images/knight_unobstructed.png" alt="Knight Diagram 2.">

## Queen
The Queen is the most powerful piece on the board, as it can move **any distance in any direction.** Unlike the knight, it can only move provided its path is not blocked by another piece.

Below are some examples of the queen’s movement. Note that the queen is on location (2, 3).

Not pictured in the diagram is that it would be legal for the queen to “capture” the black pawns at locations (1, 3) & (4, 3), but it would not be legal for the queen to move to the white pawns at locations (2, 6) & (4, 1).

<img src="/images/queen_obstructed.png" alt="Queen Diagram 1.">
<img src="/images/queen_unobstructed.png" alt="Queen Diagram 2.">

## King
The King is not a particularly powerful piece, but is arguably the most important. Like the queen, it may move in any direction. Unlike the queen, it may only move one position away from where it stands. This is the only requirement we are enforcing for the king’s movement. However, if player’s king is “captured” they lose the game. You must also implement this feature.

Below are some examples of the king’s movement. Note that the king is on location (2, 3).

Not pictured in the diagram is that it would be legal for the king to “capture” the black pawns at locations (1, 3) & (2, 2) & (3, 4), but it would not be legal for the king to move to the white pawn at location (1, 2).

<img src="/images/king_obstructed.png" alt="King Diagram 1.">
<img src="/images/king_unobstructed.png" alt="King Diagram 2.">

# Acknowledgements

* Chess Project and Unit Tests created by UTA, Tom Gordon - Fall 2022

* Chess Project, Unit Tests, and Write-Up updated, revised for inheritance, and ported to Gradescope by UTA, Adam Kvant - May 2024

* Project ported to GitHub - UTAs: Samantha Ballesteros, Adam Kvant - May 2024

* Project maintained by TAs: gordo846, angar016, chen7756, burch244, moren380, and kvant003
