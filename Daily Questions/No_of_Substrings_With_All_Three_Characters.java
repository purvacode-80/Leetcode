// 1358. Number of Substrings Containing All Three Characters

public class No_of_Substrings_With_All_Three_Characters {
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        // Frequency array to keep track of the count of 'a', 'b', and 'c'
        int[] freq = new int[3];
        int left = 0;
        int ans = 0;

        // Sliding window approach
        for (int right = 0; right < n; right++) {
            // Increment the frequency of the current character
            freq[s.charAt(right) - 'a']++;

            // Check if we have at least one of each character 'a', 'b', and 'c'
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // If we have all three characters, add the number of valid substrings
                // n - right gives the count of substrings starting from 'right' to the end of the string
                ans += n - right;
                // Move the left pointer to reduce the window size and check for more valid substrings
                freq[s.charAt(left) - 'a']--;
                // Move the left pointer to the right
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "abcabc";
        System.out.println(s1 + " => " + numberOfSubstrings(s1)); // Output: 10

        // Test Case - 2
        String s2 = "aaacb";
        System.out.println(s2 + " => " + numberOfSubstrings(s2)); // Output: 3

        // Test Case - 3
        String s3 = "abc";
        System.out.println(s3 + " => " + numberOfSubstrings(s3)); // Output: 1
    }
}
