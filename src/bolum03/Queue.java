package bolum03;

import bolum02.LinkedList;

public class Queue extends LinkedList {
    
    public void enqueue(int data) {
        append(data);
    }
    
    public Integer dequeue() {
        if (head != null & size() > 0) {
            int number = head.getData();
            head = head.next;
            return number;
        }
        return null;
    }
    
    public Integer peek() {
        if (head != null)
            return head.getData();
        return null;
    }
}
