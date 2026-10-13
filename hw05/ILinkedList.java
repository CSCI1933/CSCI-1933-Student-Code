public interface ILinkedList {
    /**
     * Adds the argument to the end of the linked list
     * @param data the element that will be added
     */
    public void add(int data);

    /**
     * Deletes the first occurrence of the argument from the linked list. Modifies nothing if there is no instance of the argument.
     * @param data the element that will have its first occurrence removed from the list
     * @return Boolean indicating whether an element was deleted. Returns false if there were no instances of the argument, meaning the list was unmodified.
     */
    public boolean delete(int data);
}
