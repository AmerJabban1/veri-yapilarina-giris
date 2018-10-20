package bolum03;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
	}
}

// Burada Stack "Çıkın" anlamında kullanılıyor.
public class Stack {
	Node top;
	
	void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	int peek() {
		return top.data;
	}
	
	int pop() {
		int n = top.data;
		if (!isEmpty())
			top = top.next;
		return n;
	}
	
	boolean isEmpty() {
		return top == null;
	}
	
	public String toString() {
		Node temp = top;
		StringBuilder sb = new StringBuilder();
		while (temp != null) {
			sb.append(temp.data + " ");
			temp = temp.next;
		}
		return sb.toString();
	}
}
