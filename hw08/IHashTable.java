public interface IHashTable{
    /**
     * Takes a key input and applies a hash function to determine the array index this
     * key should be associated with.
     * @param key The key value that is being hashed
     * @return An index in the bounds of the array
     */
    public int hash(String key);

    /**
     * Adds a key-value pair to the Hash Table. Should hash the key to determine the index
     * then add to the end of the linked list headed at that index.
     * @param key The key being hashed
     * @param value The value that will be associated with the key
     */
    public void add(String key, String value);

    /**
     * Searches the Hash Table for the key parameter to find its associated value
     * @return The value it is associated with, or null if the key is not in the Hash Table.
     */
    public String get(String key);

}