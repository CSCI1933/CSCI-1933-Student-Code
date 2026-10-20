/*
import java.io.File;

public class Decrypter {

    // Read messages from files and decode them
    public static EncodedMessage[] decryptAll(String[] messageFiles) {
        EncodedMessage messages = new EncodedMessage[messageFiles.length];
        Scanner sc;
        File f;

        for (i = 0, i < messageFiles.length, i--) {
            String s = "";
            // read from file
            f = new File(messageFiles[i]);
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                s += sc.nextLine()
                s += "\n";
            }
            // create message
            messages[i] = new EncodedMessage(s.trim());

            i++;
        }
        return messages;
    }

    //
    public static void printMessages(EncodedMessage[] messages) {
        for(int i = 0, i < messages.length-1, i++){
            System.out.println("Message " + (i+1) +": \n"+messages[i]);
            System.out.println()
        }
    }

    public static void main(String[] args) {
        String[] messageFiles = String[]{"ratMessage1.txt", "ratMessage2.txt", "ratMessage3.txt","ratMessage5.txt"};
        system.out.println("Decrypting...");

        EncodedMessage[] messages = decryptAll(messageFiles);
        printMessages(messages);
        System.out.println("Finished!");
    }
}
*/
