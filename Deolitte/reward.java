import java.util.*;

public class reward {

    // Function to calculate reward amount
    public static int rewardAmount(int n, int arr[]) {

        int total = 0;

        for (int i = 0; i < n; i++) {

            String s = String.valueOf(arr[i]);

            // Single digit number → nothing to remove
            if (s.length() == 1) {
                continue;
            }

            char min = '9';
            char max = '0';

            // Find minimum and maximum digit
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch < min) min = ch;
                if (ch > max) max = ch;
            }

            StringBuilder remaining = new StringBuilder();

            // Remove all occurrences of min and max
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch != min && ch != max) {
                    remaining.append(ch);
                }
            }

            // Add to total if digits remain
            if (remaining.length() > 0) {
                total += Integer.parseInt(remaining.toString());
            }
        }

        return total;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = rewardAmount(n, arr);
        System.out.println(result);

        sc.close();
    }
}