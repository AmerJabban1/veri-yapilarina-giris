
public class Program {
    public static void main(String[] args) {
        System.out.println("Eclipse");
    }
    
//    static String tersCevir(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = s.length() - 1; i >= 0; i--) {
//            sb.append(s.charAt(i));
//        }
//        return sb.toString();
//    }
    
    static String tersCevir(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0, j = s.length() - 1; i < arr.length; i++, j--) {
            arr[i] = s.charAt(j);
        }
        return new String(arr);
    }    
    
    static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    static int GCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = GCD(result, arr[i]);
        }
        return result;
    }
    
    static int GCD(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
    
    static int LCM(int[] arr) {
        int result = arr[0];        
        for (int i = 1; i < arr.length; i++) {
            result = LCM(result, arr[i]);
        }        
        return result;
    }
    
    static int LCM(int a, int b) {
        return (a * b) / GCD(a, b);
    }
    
    static boolean isFactor(int x, long number) {
        return number % x == 0;
    }
    
    static boolean isPrime(double n) {
    	if (n <= 1)
    	    return false;
    	else if (n <= 3)
    	    return true;
    	else if (n % 2 == 0 || n % 3 == 0)
    	    return false;
    	
    	int i = 5;
    	while (i*i <= n) {
    	    if (n % i == 0 || n % (i + 2) == 0)
    	        return false;
    	    i += 6;
    	}
    	return true;
    }
    
    static void printFibonacciBelow(int n) {
    	int a = 0;
    	int b = 1;
    	while (a < n) {
    		int c = a + b;
    		a = b;
    		b = c;
    		if (c < n)
    			System.out.println(c);
    	}
    }
}