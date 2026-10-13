import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class HelloWorldWriter {
    public static void writeHelloWorld(String fileName) throws FileNotFoundException {
        File f = new File(fileName);        // creates a new File
        PrintWriter p = new PrintWriter(f); // create a new PrintWriter
        p.print("Hello World!");          // writes to the file
        
        // if you want to write an object with a toString() to a file:
        // p.print(object.toString());

        p.close();
    }
    
    public static void main(String[] args) {
        try {
            writeHelloWorld("sample_output.txt");
        } catch (Exception e) {
            System.out.println("Womp womp! Failed to write!");
        }
    }
}