public interface IQueue {
    /** Tests whether the queue is empty. */
    public boolean isEmpty();

    /** Adds an element to the back of the queue. */
    public void enqueue(int data);

    /** Removes and returns the front element the queue */
    public int dequeue();
}
