// 338. Counting Bits

class Counting_Bits {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            // Integer.bitCount(i) returns the number of one-bits in the two's complement binary 
            // representation of the specified int value.
            result[i] = Integer.bitCount(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int n1 = 2;
        int[] result1 = countBits(n1);
        System.out.println("Number of 1's are" + java.util.Arrays.toString(result1)); // Output: [0, 1, 1]
        // Test Case - 2
        int n = 5;
        int[] result = countBits(n);
        System.out.println("Number of 1's are" + java.util.Arrays.toString(result)); // Output: [0, 1, 1, 2, 1, 2]
    }
}