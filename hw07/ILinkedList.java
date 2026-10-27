public interface ILinkedList {
    /**
     * Adds the argument to the end of the linked list
     * @param data the element that will be added
     */
    public void add(int data);

    /**
     * Returns the index of the first occurrence of the element
     * @param data the element that is being searched for
     * @return Integer that represents the index of the first occurrence, or -1 if data does not appear in the list
     */
    public int indexOf(int data);

    /**
     * Inserts the data argument in the sequence at the index argument with 0-based indexing
     * @param data the element that will be inserted
     * @param index the position tha the element with be inserted into
     * @return Integer that represents the number of elements that were deleted
     */
    public boolean insert(int data, int index);
}