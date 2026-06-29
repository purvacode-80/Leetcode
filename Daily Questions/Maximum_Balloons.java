// 1189. Maximum Number of Balloons

public class Maximum_Balloons {
    public static int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        return Math.min(count['b' - 'a'], Math.min(count['a' - 'a'], Math.min(count['l' - 'a'] / 2, Math.min(count['o' - 'a'] / 2, count['n' - 'a']))));
    }

    public static void main(String[] args) {
        // Test Case - 1
        String text1 = "nlaebolko";
        System.out.println(maxNumberOfBalloons(text1)); // Output: 1

        // Test Case - 2
        String text2 = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text2)); // Output: 2

        // Test Case - 3
        String text3 = "leetcode";
        System.out.println(maxNumberOfBalloons(text3)); // Output: 0
    }
}