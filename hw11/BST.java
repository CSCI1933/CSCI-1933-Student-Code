public interface BST {
    /**
     * Inserts data into the Binary Search Tree, maintaining the Binary Search Tree condition to
     * place lower values to the left of their parent and higher values to the right of their parent
     * @param data The data that should be inserted
     * @return Boolean indicating whether the insertion succeeded. Failure should only occur when
     * the data is already in the Binary Search Tree
     */
    boolean insert(int data);

    /**
     * Searches the Binary Search Tree for the data
     * @param data The element to search for
     * @return Boolean indicating if this element is in the Binary Search Tree
     */
    boolean contains(int data);
}
