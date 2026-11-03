// CSCI 1933 Lab 08

public class SparseVector {
    private Node head;
    private int length;

    public SparseVector(int len){
        head = null;
        length = len;
    }

    // Prints out a sparse vector (including zeros)
    public String toString(){
        String result = "";
        Node currNode = head;
        int currIndex = 0;
        while( currNode != null ){
            int idx = currNode.getIndex();

            // Pad the space between nodes with zero
            while( currIndex < idx ){
                result += "0, ";
                currIndex++;
            }

            result += currNode;
            currNode = currNode.getNext();
            currIndex++;

            // Only add a comma if this isn't the last element
            if(currNode != null) {
                result += ", ";
            }
        }
        return result;
    }

    // TODO: Implement me for milestone 2
    public void addElement(int index, double value) {
    }

    // TODO: Implement me for milestone 4
    public static double dot(SparseVector x, SparseVector y) {
        return 0.0;
    }

    // TODO: Test out your code here!
    public static void main(String[] args) {
    }
}
