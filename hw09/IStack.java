public interface IStack {
    /**
     * Adds a new element to the top of the stack
     * @param data The element that will be pushed
     */
    public void push(int data);

    /**
     * Removes the top element from the stack
     * @return The element that was removed
     */
    public int pop();

    /**
     * Indicates whether the stack is empty or not
     * @return True if the stack has zero elements, false if it has at least one
     */
    public boolean isEmpty();
}