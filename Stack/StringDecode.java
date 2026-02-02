import java.util.Stack;

public class StringDecode {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

       for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Multi-value digit handling
                // ASCII to digit conversion
                k = (k * 10) + (c - '0');
            }

            else if (c == '[') {
                // Final k value push to stack
                countStack.push(k);
                // Push currentString into stringStack
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k=0;
            }

            else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for(int i=0; i < repeat; i++) {
                    prev.append(currentString);
                }
                currentString = prev;
            }

            else {      // Character is a letter 
                currentString.append(c);
            }
       } 
       // Convert to string and return
       return currentString.toString();
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "3[a]2[bc]";
        String decoded_1 = decodeString(s1);
        System.out.println("Decoded String : " + decoded_1);    // Output : aaabcbc

        // Test Case - 2
        String s2 = "3[a2[c]]";
        String decoded_2 = decodeString(s2);
        System.out.println("Decoded String : " + decoded_2);    // Output : accaccacc

        // Test Case - 3
        String s3 = "2[abc]3[cd]ef";
        String decoded_3 = decodeString(s3);
        System.out.println("Decoded String : " + decoded_3);    // Output : abcabccdcdcdef
    }
}
