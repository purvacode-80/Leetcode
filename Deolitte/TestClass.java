import java.util.*;

public class TestClass {

    // Function 1: Largest Diamond Boundary
    static int firstRoute(int n, int a[][]) {

        int sum = 0;
        int mid = n / 2;

        for (int i = 0; i < n; i++) {

            int offset = Math.abs(mid - i);
            int start = offset;
            int end = n - 1 - offset;

            if (start == end) {
                sum += a[i][start];
            } else {
                sum += a[i][start];
                sum += a[i][end];
            }
        }

        return sum;
    }

    // Function 2: Smallest 2x2 Square Sum
    static int secondRoute(int n, int a[][]) {

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {

                int curr = a[i][j]
                         + a[i][j+1]
                         + a[i+1][j]
                         + a[i+1][j+1];

                minSum = Math.min(minSum, curr);
            }
        }

        return minSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int diamond = firstRoute(n, a);
        int square = secondRoute(n, a);

        System.out.println(diamond + " " + square);

        sc.close();
    }
}