package bolum03;

import java.util.Arrays;

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
			array = Arrays.copyOf(array, n * 2);
			n *= 2;
		}
		array[++top] = data;
	}
	
	public Integer pop() {
		if (!isEmpty()) {
			return array[top--];
		}
		return null;
	}
	
	public Integer peek() {
        if (!isEmpty()) {
            return array[top];
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
	
	public int size() {
	    return top + 1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int n : array)
			sb.append(n + " ");
		return sb.toString();
	}
}
