# CSCI 1933 Lab 5: Arrays, Sorting, and More File I/O

For this lab, you MUST be using an IDE (IntelliJ, Visual Studio Code, etc.).

Let's begin!

```bash
git pull
```
*Note: In the terminal, navigate to the top of the `CSCI-1933-Student-Code` directory using the `cd` command.*

## Milestone 1

As a college student, you might have a lot of books. For this lab, you will be creating a representation of a collection of books via a bookshelf. You have been provided with a Book class. *Please take a look at it before you begin*. It has 3 private instance variables: a title, an author, and a rating. It has getters, setters, a `toString()` (which should allow you to print a book), and a `compareTo()` method. This will be important later.

### Create a Bookshelf

We will be using a Bookshelf class to store our Books. Like the data[] array in lab 4 that contained Owl objects, your Bookshelf class will have an array of Book objects. It should contain two constructors:

- A *default* constructor that takes in no arguments, and initializes the Book array to a size of 20.
- A second constructor that takes in an integer as an argument, and initializes the Book array to be the size of that integer.
- This part is *optional*, but you can also make a constructor that takes in a Book array to use as the member Book array.

It should have the following methods:

- `public boolean add(Book newBook)` — This method must have a time complexity of O(1). Attempt to add a Book to the first empty slot in the Bookshelf. If it is successful, it will return true and false otherwise. Do NOT allow books to be added if the Bookshelf is full. (HINT: to maintain a constant time complexity, O(1), you might want to use an instance variable that keeps track of the next open spot in the bookshelf, such as `private int nextEmpty`).
- `public Bookshelf getBooksByAuthor(String author)` — This will return a **new** Bookshelf object containing only the books that were written by the given author. If no books were written by that author, the Bookshelf that gets returned should be empty.
- `public String toString()` — Returns a string of the Book objects in the array. Each Book should be separated by a single newline character.

### Milestone 1 Checkoff

> Create a Bookshelf, add a few books, then print it out. Now write a test your `getBooksByAuthor()` method and print out the result. Show a TA your Bookshelf class. Here is an example:

```Java 
Bookshelf bs = new Bookshelf(5);
bs.add(new Book("Eragon", "Christopher Paolini", 5.0));
bs.add(new Book("Eldest", "Christopher Paolini", 5.0));
bs.add(new Book("Brisingr", "Christopher Paolini", 5.0));
bs.add(new Book("Inheritance", "Christopher Paolini", 5.0));
bs.add(new Book("Dracula", "Bram Stoker", 4.2));
Bookshelf goodbooks = bs.getBooksByAuthor("Christopher Paolini");
System.out.println(goodbooks);
```

> The expected output is: <br>
> Eragon, Christopher Paolini, 5.0 <br>
> Eldest, Christopher Paolini, 5.0 <br>
> Brisingr, Christopher Paolini, 5.0 <br>
> Inheritance, Christopher Paolini, 5.0 <br>

## Milestone 2

Our bookshelf might be functional, but it may as well not even be called a shelf. There’s no order to it! This could be a pile of books and no one could tell the difference. Therefore, we need to sort it.

Handily enough, our Book class comes with a special `compareTo()` method. You’ve probably used operators like < or > all the time. These operators, unfortunately, can’t be used on objects. This is where methods such as compareTo come into play. compareTo is very similar to the equals method, except it returns an int based on how the two objects compare. Suppose you run `a.compareTo(b)`. This will return:

- A negative number if a < b.
- A positive number if b < a
- 0 if a == b;

Take a look at the Book class. There are two `compareTo()` methods provided for Book:

- `public int compareTo(Book other)` — This compares two books based on the title.
- `public int compareTo(Book other, char compareBy)` — If the compareBy character is 'a', it will compare the books based on the author. If the compareBy character is 't', it will compare the books based on the title. Finally, if the compareBy character is 'r', it will compare the books based on the rating.

Implement this method in your Bookshelf class:

- `public void sort(char sortBy)` — This method re-orders the bookshelf into ascending order. The sortBy argument will determine what characteristic the books will be sorted by (author, title, or rating). sortBy should be used when you are calling `compareTo()`. You can use any of the algorithms you have seen in class. You can find them [HERE](https://github.umn.edu/CSCI-1933/Student-Resources/tree/main/Sorting%20Algorithms). **Be sure not to sort any null items at the end of the Book array. (HINT: your nextEmpty variable should help with this)**.

### Milestone 2 Checkoff

> Write three tests to verify your sort method works for the three different options. Show this to a TA. Here is one test provided for you:

```Java
Bookshelf bs = new Bookshelf(5);
bs.add(new Book("Eragon", "Christopher Paolini", 5.0));
bs.add(new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 5.0));
bs.add(new Book("Twilight", "Stephenie Meyer", 0.0));
bs.add(new Book("The Diary of a Wimpy Kid", "Jeff Kinney", 0.0));
bs.add(new Book("Dracula", "Bram Stoker", 4.2));
bs.sort('a');
System.out.println(bs);
```

> The expected output is:
> Dracula, Bram Stoker, 4.2
> Eragon, Christopher Paolini, 5.0
> The Fellowship of the Ring, J.R.R. Tolkien, 5.0
> The Diary of a Wimpy Kid, Jeff Kinney, 0.0
> Twilight, Stephenie Meyer, 0.0

### Milestone 3

Now you have a working Bookshelf class! However, hardcoding every title, author, and rating and then recompiling every time we want to make a change is incredibly time-consuming. This is where file I/O comes in handy. Instead of hardcoding every book’s information into our BookShelf, we can simply create a method that reads in that information from a file.

Navigate to the BookshelfReader.java file. This class doesn't need a constructor, just the two methods listed below.

- `public static Bookshelf readBooksFromFile(String fileName)` — This method will read a CSV file and populate the Book array. This will look *very* similar to populateData() from last week's lab.
- `public static void writeShelfToFile(Bookshelf b, String fileName)` — This method will take an existing Bookshelf and a file name (such as **output.txt**), and print out all the Books of the Bookshelf to the file. You need to import PrintWriter.

Look at the **HelloWorldWriter.java** file. You'll see an example of how to write to a file. You'll see that it will either create a new file with the name **sample_output.txt** if it doesn't exist, or overwrite a file with that name. This should help you write your `writeShelfToFile()` method.

### Milestone 3 Checkoff

> Write a main method that reads in a Bookshelf from bookinput.csv, sorts the bookshelf by rating, and then writes it to output.txt.

## Milestone 4

### 2D Arrays

By this point, you should be pretty comfortable using and traversing arrays. Now, you will be working with 2D arrays. A 2D array in Java is the array equivalent of a 2D list in Python. Essentially, it is just an array of arrays. The 2D array {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}} can be visualized as this matrix:

```math
  \begin{bmatrix} 
    1 & 2 & 3 \\ 
    4 & 5 & 6 \\
    7 & 8 & 9 \\
    10 & 11 & 12
  \end{bmatrix}
```

If you want to initialize a 4x3 2D array, you would use:

```Java
int[][] tdArray = new int[4][3];
```

The first set of brackets allows you to access a row in the 2D array, and the second set of brackets is the column. `tdArray[1][2]` would give you 6. `tdArray[2][1]` gives you 8. One important thing to keep in mind is that 2D arrays aren't always rectangular (its rows might have different lengths).

### Make a Matrix Class

You will be writing a Matrix class with the following instance variables and methods:

- `private int nrows` — The number of rows in the matrix.
- `private int ncols` — The number of columns in the matrix.
- `private int[][] matrix;` — 2D array that stores the matrix variables.

- `public Matrix(int nrows, int ncols)` — A constructor that takes in the dimensions and initializes the instance variables.
- `public Matrix(int[][] arr)` — A constructor that takes in a 2D array to set as the `matrix` attribute and initializes the rest of the instance variables.
- `public Matrix transpose()` — Transposes the matrix.
- `public String toString()` — String representation of the matrix. This doesn't have to be anything elaborate. Just make sure that each entry and each row are distinguishable.

Recall, the transpose of the matrix is where the rows are swapped with the columns. The transpose of the matrix from the previous example would look like this:

```math
  \begin{bmatrix} 
    1 & 4 & 7 & 10\\ 
    2 & 5 & 8 & 11\\
    3 & 6 & 9 & 12
  \end{bmatrix}
```

You should approach this by creating a new Matrix and setting nrows to be the number of columns of your matrix and ncols to be the number of rows in your matrix. Then, iterate through each entry of the new matrix, and set the value to be the entry in the original matrix except with the indices flipped. For example: `newMatrix.matrix[j][i] = this.matrix[i][j]`.

### Milestone 4 Checkoff

> Write a main method where you create a Matrix, print out its contents. Then, transpose the matrix by calling `transpose()`, and print it out again.
