// 1318. Minimum Flips to Make a OR b Equal to c

public class Min_Flips {
    public static int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a > 0 || b > 0 || c > 0) {
            // Extract the least significant bits of a, b, and c using bitwise AND with 1
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            // If bitC is 0, both bitA and bitB must be 0. 
            if(bitC == 0) {
                flips += bitA + bitB;
            } else {
                // If bitC is 1, at least one of bitA or bitB must be 1.
                // If both are 0, we need to flip one of them to 1.
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }

            // Right shift a, b, and c to process the next bits in the next iteration
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return flips;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int a1 = 2, b1 = 6, c1 = 5;
        System.out.println("Minimum Flips in Test Case 1 : " + minFlips(a1, b1, c1)); 
        // Output: 3

        // Test Case - 2
        int a2 = 4, b2 = 2, c2 = 7;
        System.out.println("Minimum Flips in Test Case 2 : " + minFlips(a2, b2, c2)); 
        // Output: 1

        // Test Case - 3
        int a3 = 1, b3 = 2, c3 = 3;
        System.out.println("Minimum Flips in Test Case 3 : " + minFlips(a3, b3, c3)); 
        // Output: 0
    }
}
