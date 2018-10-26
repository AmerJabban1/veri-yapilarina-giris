package bolum02;

public class Node {
    int data;
    Node next, prev;
    
    public Node(int data) {
        this.data = data;
    }
    
    public String toString() {
        return String.valueOf(data);
    }
}
