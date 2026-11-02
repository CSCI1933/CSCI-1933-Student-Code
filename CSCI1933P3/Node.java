package CSCI1933P3;
/**
 * Node support class for CSCI 1933 Project 3.
 *
 * @param <T> Generic type for Node class.
 */
public class Node<T extends Comparable<T>> {

  private T data;
  private Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }

  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }
}
