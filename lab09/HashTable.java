import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTable{
    StringNode[] hashTable;

    // Constructor to initialize hashTable to the size passed in
    public HashTable(int size) {
        hashTable = new StringNode[size];
    }

    // TODO: Implement a simple hash function
    public int hash(T item) {return -1;}
        
    // TODO: Implement the contains method that checks if a hash table contains item
    public boolean contains(T item) {return false;}
        
    // TODO: Adds items to the hash table without duplicates
    public void add(T item) { }

    // TODO: Delete item if present
    public boolean delete(T item) {
        return false;
    }

    // TODO: Resize
    public void resize() {
    
    }

    // Adds all words from a given file to the hash table using the add(T item) method above
    @SuppressWarnings("unchecked")
    public void addWordsFromFile(String fileName) {
        Scanner fileScanner = null;
        String word;
        try {
            fileScanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " not found.");
            System.exit(1);
        }
        while (fileScanner.hasNext()) {
            word = fileScanner.next();
            word = word.replaceAll("\\p{Punct}", ""); // removes punctuation
            this.add((T) word);
        }
    }

    // Counts the length of a chain
    public int count(StringNode ptr) {
        int count = 0;
        while (ptr != null) {
            count++;
            ptr = ptr.getNext();
        }
        return count;
    }

    // Prints out summary statistics for the hash table
    public void display() {
        int empty = 0, nonempty = 0, total = 0, longest = 0, len;
        for (int i = 0; i < hashTable.length; i++) {
            len = count(hashTable[i]);
            if (len == 0) {
                empty++;
            } else {
                nonempty++;
                total += len;
                if (len > longest) {
                    longest = len;
                }
            }
            System.out.println(i + ": " + len);
        }
        System.out.println("# of empty indices:      " + empty);
        System.out.println("# of non-empty indices:  " + nonempty);
        System.out.println("# of unique words:       " + total);
        System.out.println("Average # of collisions: " + ((double) total/hashTable.length));
        System.out.println("Longest chain:           " + longest);
    }

    public static void main(String[] args) {
        // Use the following sections for testing with our smaller input file and larger input file.
        // 
        // Introductory code has been provided to start each block, but these WILL require additions to test your methods.
        // 
        // Make sure you take a look at the files before adding code to verify your contains/delete/resize method behaviors!
        
        /* Smaller Testing 
        HashTable ht = new HashTable(10);
        ht.addWordsFromFile("shopping_list.txt");
        ht.display();
        */
        
        /* Larger Testing
        HashTable ht = new HashTable(100);
        ht.addWordsFromFile("canterbury.txt");
        ht.display();

        // Sample for testing contains() method
        System.out.println(ht.contains("whilst"));  // true
        System.out.println(ht.contains("nine"));    // true
        System.out.println(ht.contains("Zephyr"));  // true
        System.out.println(ht.contains("ran"));     // false
        System.out.println(ht.contains("very"));    // false
        System.out.println(ht.contains("far"));     // false
        */
    }
}
