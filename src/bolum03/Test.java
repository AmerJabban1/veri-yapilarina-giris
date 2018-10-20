package bolum03;

public class Test {
	public static void main(String[] args) {
		MultiStack newStack = new MultiStack(10);
		for (int i = 0; i < 20; i++) {
			newStack.push(i);
		}
		System.out.println(newStack);
	}
	
	static void convertToBinaryForm(int n) {
		Stack stack = new Stack();
		int digit;
		while (n > 0) {
			digit = n % 2;
			stack.push(digit);
			n /= 2;
		}
		while (stack.top != null && stack.top.data != -1) {
			System.out.print(stack.pop());
		}
	}
}
