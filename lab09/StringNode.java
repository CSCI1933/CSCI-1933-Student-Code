// String linked list node class
public class StringNode {
  private String data;
  private StringNode next;
  public StringNode() {
  }
  public StringNode(String item, StringNode link) {
      data = item;
      next = link;
  }
  public String getData() {
      return data;
  }
  public void setData(String item) {
      data = item;
  }
  public StringNode getNext() {
      return next;
  }
  public void setNext(StringNode link) {
      next = link;
  }
}
