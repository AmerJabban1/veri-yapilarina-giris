import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (i == j)
                    continue;
                if (a[i] == a[j])
                    minDist = Math.min(Math.abs(i-j), minDist);
            }
        }
        return minDist != Integer.MAX_VALUE ? minDist : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        System.out.println(result);

        scanner.close();
    }
}
