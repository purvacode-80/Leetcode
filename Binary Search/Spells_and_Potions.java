import java.util.Arrays;

public class Spells_and_Potions {
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int spells_length = spells.length;
        int potions_length = potions.length;
        int[] result = new int[spells_length];

        // Sort potions array
        Arrays.sort(potions);

        for (int i = 0; i < spells_length; i++) {
            int low = 0;
            int high = potions_length - 1;
            while (low <= high) {
                int mid = low + ((high - low) / 2);
                long product = (long) spells[i] * potions[mid];
                if (product >= success) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            result[i] = potions_length - low;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 7;
        int[] result = successfulPairs(spells, potions, success);
        System.out.println("Test Case - 1: " + Arrays.toString(result)); // Output: [4, 0, 3]

        // Test Case - 2
        spells = new int[]{3, 1, 2};
        potions = new int[]{8, 5, 8};
        success = 16;
        result = successfulPairs(spells, potions, success);
        System.out.println("Test Case - 2: " + Arrays.toString(result)); // Output: [2, 0, 2]

        // Test Case - 3
        spells = new int[]{1, 2, 3};
        potions = new int[]{1, 2, 3};
        success = 10;
        result = successfulPairs(spells, potions, success);
        System.out.println("Test Case - 3: " + Arrays.toString(result)); // Output: [0, 0, 0]
    }
}
