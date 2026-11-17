// CSCI 1933 Lab 10
public class Stack<T> {

  public Stack() {}

  public Stack(int size) {}

  public T pop() throws StackException {return null;}

  public void push(T data) throws StackException {}

  public static void main(String[] args) {

      // ------------- Comment this in to test ------------
      // Stack<Integer> myStack = new Stack<>();

      // try {
      //     myStack.push(10);
      //     myStack.push(20);
      //     myStack.push(30);
      //     System.out.println(myStack.pop()); // this should print 30
      //     myStack.push(40);
      //     myStack.push(50);
      //     myStack.push(60);
      //     myStack.push(70); // this causes an exception!
      // } catch (StackException e) { // catches any StackException that is thrown
      //     System.out.println("Stack exception has occurred!");
      // } finally {
      //     System.out.println("Goodbye!");
      // }
  }
}
