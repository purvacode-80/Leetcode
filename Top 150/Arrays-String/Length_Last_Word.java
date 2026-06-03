// 58. Length of Last Word

public class Length_Last_Word {
    public static int lengthOfLastWord(String s) {
        s = s.trim();   // Remove leading and trailing spaces


        // Find the index of the last space in the string
        int lastIndex = s.lastIndexOf(" ");
        // Length = Total length of the string - index of the last space
        // System.out.println(s.length() + " " + lastIndex);
        return s.length() - lastIndex - 1;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "Hello World";
        System.out.println(lengthOfLastWord(s1)); // Output: 5

        // Test Case - 2
        String s2 = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s2)); // Output: 4

        // Test Case - 3
        String s3 = "luffy is still joyboy";
        System.out.println(lengthOfLastWord(s3)); // Output: 6
    }
}
