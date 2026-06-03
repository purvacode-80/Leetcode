// 125. Valid Palindrome

public class Palindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        if(s.length() == 0)   return true;

        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right))   return false;
            left++;
            right--;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        
        return s.equals(reversed);
        // return true;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1)); // Output: true

        // Test Case - 2
        String s2 = "race a car";
        System.out.println(isPalindrome(s2)); // Output: false

        // Test Case - 3
        String s3 = " ";
        System.out.println(isPalindrome(s3)); // Output: true
    }
}