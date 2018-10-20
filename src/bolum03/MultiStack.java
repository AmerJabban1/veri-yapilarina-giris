package bolum03;

public class MultiStack {
	int[] array;
	int top;
	int n;
	int tempN;
	
	MultiStack(int n) {
		n *= 2;
		tempN = n;
		array = new int[n];
		top = -1;
		this.n = n;
	}
	
	void push(int data) {
		if (!isFirstHalfFull()) {
			array[++top] = data;
		} else if (!isSecondHalfFull()) {
			array[--tempN] = data;
		}
	}
	
	boolean isFirstHalfFull() {
		return top == (n / 2 - 1);
	}
	
	boolean isSecondHalfFull() {
		return tempN == array.length / 2;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int n : array)
			sb.append(n + " ");
		return sb.toString();
	}
}
