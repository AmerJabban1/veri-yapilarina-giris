package bolum02;

public class Node {
    int data;
    public Node next, prev;
    
    public Node(int data) {
        this.data = data;
    }
    
    public int getData() {
        return data;
    }
    
    public String toString() {
        return String.valueOf(data);
    }
}
