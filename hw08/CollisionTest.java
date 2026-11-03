import java.lang.reflect.Field;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CollisionTest {
    public static Object getFieldValue(Object target, String expectedName, String typeName) {
        if (target == null) return null;
        Field typeMatch = null;

        for (Field field : target.getClass().getDeclaredFields()) {
            if (field.getType().getSimpleName().equals(typeName)) {
                if (field.getName().equalsIgnoreCase(expectedName)){
                    field.setAccessible(true);
                    try {
                        return field.get(target);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (typeMatch == null) typeMatch = field;
            }
        }
        if (typeMatch != null){
            typeMatch.setAccessible(true);
            try {
                return typeMatch.get(target);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("No field of type '" + typeName + "' found in " + target.getClass().getSimpleName());
    }

    public static int[] collisionStats(HashTable ht){
        PairNode[] table = (PairNode[])getFieldValue(ht, "table", "PairNode[]");
        int filledCells = 0;
        int totalNodes = 0;
        int longestChain = 0;
        int longestChainIdx = 0;
        for (int i = 0; i < table.length; i++){
            PairNode curr = table[i];
            int currentChain = 0;
            if (curr != null) filledCells++;
            while (curr != null){
                totalNodes++;
                if (++currentChain > longestChain){
                    longestChain = currentChain;
                    longestChainIdx = i;
                }
                curr = curr.getNext();
            }
        }
        return new int[]{filledCells, totalNodes, longestChain, longestChainIdx};
    }

    public static String collisionReport(HashTable ht){
        int[] stats = collisionStats(ht);
        int filledCells = stats[0];
        int totalNodes = stats[1];
        int longestChain = stats[2];
        int longestChainIdx = stats[3];
        double collisionPerc = 100 * (totalNodes - filledCells) / (double)totalNodes;
        return String.format("%s elements covering %s array positions. Collision percentage: %.2f%%" +
                            "\nLongest chain has %s nodes at index %s",
                            totalNodes, filledCells, collisionPerc, longestChain, longestChainIdx);
    }

    public static HashTable csvToHashTable(String fileName) throws FileNotFoundException {
        HashTable ht = new HashTable(1000);
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            String str = s.nextLine();
            String[] args = str.split(",");
            ht.add(args[0],args[1]);
        }
        s.close();
        return ht;
    }
}
