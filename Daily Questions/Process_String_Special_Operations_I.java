// 3612. Process String with Special Operations I

public class Process_String_Special_Operations_I {
    public static String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (sb.length() != 0)   
                    sb.deleteCharAt(sb.length() - 1);
            }
            else if (s.charAt(i) == '#') {
                sb.append(sb);
            }
            else if (s.charAt(i) == '%') {
                sb.reverse();
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "a#b%*";
        System.out.println(processStr(s1)); // Output: "ba"

        // Test Case - 2
        String s2 = "z*#";
        System.out.println(processStr(s2)); // Output: ""
    }
}
