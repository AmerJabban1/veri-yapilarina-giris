package bolum02;

public class LinkedList {
    public Node head, tail;
    
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    
    void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (tail == null) {
            tail = newNode;
        }
        head = newNode;
    }
    
    public void remove(int value) {
        if (head != null && contains(this, value)) {
            Node prev = null;
            Node temp = head;
            if (value == head.data) {
                head = head.next;
                return;
            }
            while (temp.next != null && temp.data != value) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
        }
    }
    
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public Node search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value)
                return temp;
        }
        return null;
    }
    
    public boolean contains(int n) {
        return contains(this, n);
    }
    
    private boolean contains(LinkedList list, int n) {
        Node temp = list.head;
        while (temp != null) {
            if (temp.data == n) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    public int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data).append(" ");
            temp = temp.next;
        }
        sb.append("\n");
        return sb.toString();
    }
}
