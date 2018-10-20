package bolum02;

class Node {
    int data;
    Node next, prev;
    
    Node(int data) {
        this.data = data;
    }
    
    public String toString() {
        return String.valueOf(data);
    }
}

public class LinkedList {
    Node head, tail;
    
    void append(int data) {
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
    
    void remove(int value) {
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
    
    public static void main(String[] args) {
        
    }
}
