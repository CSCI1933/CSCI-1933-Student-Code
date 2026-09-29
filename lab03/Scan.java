// Scan.java
// Java IO example with Scanner class
// Scanner class used for "seamless" input without exception handling
// Scanner is a "relatively simple" way of reading data from the keyboard
// and often used for program testing,
// The Scanner class will be introduced in Lab 2.
// Revised 1/2024

import java.util.Scanner; // import in Java is different from Python

public class Scan {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // create a scanner object
        int count = 0, n;
        String words;

        // first Scanner example is reading of ints from the keyboard

        System.out.println("Reading integers...");
        System.out.print("\nValue " + count + "--" +
        "enter an integer followed by <enter/return> (or ^d to stop): ");
        count = count + 1;

        while (s.hasNextInt()) {    // true if more integer tokens
                                    // in this Scanner instance
                                    // hasNextInt() waits for keyboard entry
                                    // if needed

        // only gets here if an int token present
        n = s.nextInt(); 
        System.out.println("You entered: " + n);
        System.out.print("Value " + count + "--" +
        "enter next integer (or ^d to stop): ");
        count = count + 1;
        }
        
        System.out.println("\nOK\n\n");

        // Question: does count now represent the number of values entered???

        // second Scanner example is reading of Strings

        s = new Scanner(System.in); // new Scanner instance
        count = 0;

        System.out.println("Now Strings...");
        System.out.print("\nValue " + count + "--" +
            "enter a string followed by <enter/return> (or ^d to stop): ");
        count = count + 1;

        while (s.hasNext()) {   // true if more String tokens
                                // in this Scanner instance
                                // hasNext() waits for keyboard entry if needed

        // only gets here if a String token present
        words = s.nextLine();
        System.out.println("You entered: " + words);
        System.out.print("Value number " + count + "--" +
        "Enter next string: ");
        count = count + 1; // or count++
        }

        System.out.println("\nOK\n\n");
    }
}
