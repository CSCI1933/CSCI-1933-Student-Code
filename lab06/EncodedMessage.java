public class EncodedMessage {
    String[] words;

    public EncodedMessage(String message) {
        words = message.split(" ");
    }

    public void decode() {
        String finalWord = words[words.length];
        int shift = findShift(finalWord, "Squeak");
        for (int i = 0; i < words.length; i++) {
            words[i] = caesarDecode(words[i], shift);
        }
    }

    private static String caesarDecode(String word, int shift) {
        StringBuilder decoded = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char newChar = (char) ((c - base - shift + 26) % 26 + base);
                decoded.append(newChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }

    // Method to find shift. Brute force comparison with 26 possible shifts
    public int findShift(String word, String known) {
        for (int i = 0; i < 26; i++) {
            if (caesarDecode(word, i).equalsIgnoreCase(known)) {
                return i;
            }
        }
        return 0;
    }

    public String toString(){
        return String.join(" ",words);
    }
}