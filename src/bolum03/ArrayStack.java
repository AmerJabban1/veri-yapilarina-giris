package bolum03;

public class ArrayStack {
	int[] array;
	int top;
	int n;
	
	ArrayStack(int n) {
		array = new int[n];
		top = -1;
		this.n = n;
	}
	
	void push(int data) {
		if (isFull()) {
			int[] temp = new int[n];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = array[i];
			}
			
			n *= 2;
			array = new int[n];
			for (int i = 0; i < temp.length; i++) {
				array[i] = temp[i];
			}			
		}
		array[++top] = data;
	}
	
	Integer pop() {
		if (!isEmpty()) {
			return array[top--];
		}
		return null;
	}
	
	void swap() {
		if (array.length >= 2) {
			int tempA = pop();
			int tempB = pop();
			push(tempA);
			push(tempB);
		}
	}
	
	boolean isFull() {
		return top == n - 1;
	}
	
	boolean isEmpty() {
		return top == -1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int n : array)
			sb.append(n + " ");
		return sb.toString();
	}
}
