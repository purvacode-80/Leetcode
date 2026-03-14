public class GuessNumber {
    public static int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (( high - low ) / 2);
            int res = guess(mid);
            if (res == 0)    return mid;
            else if (res == -1)   high = mid - 1;
            else    low = mid + 1;
        }
        return -1; // If not found
    }

    private static int guess(int num) {
        // This method is assumed to be implemented elsewhere
        // It returns:
        // Num - Current guess
        // Pick - The number to guess
        // -1 if num > pick
        // 1 if num < pick
        // 0 if num == pick
        return 0; // Placeholder implementation
    }

    public static void main(String[] args) {
        
    }
}