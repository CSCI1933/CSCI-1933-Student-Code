// CSCI 1933 Lab 08
public class Node {
    // Instance Variables
    private Node next;
    private int index;
    private double value;

    // Constructor
    public Node(int idx, double val){
        index = idx;
        value = val;
        next = null;
    }

    // Accessors and Mutators
    public double getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node other) {
         next = other;
    }

    public String toString() {
        return ""+value;
    }
}
  
