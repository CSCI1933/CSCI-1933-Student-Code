public class PairNode {
    private String key;
    private String value;
    private PairNode next;

    public PairNode(String key, String value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public PairNode getNext(){
        return next;
    }

    public void setNext(PairNode newNext){
        next = newNext;
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }
}