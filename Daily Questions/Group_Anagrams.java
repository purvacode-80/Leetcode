import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagrams {
     public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String string : strs) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Test Case - 1
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = groupAnagrams(strs1);
        System.out.println("Test Case 1: " + result1);

        // Test Case - 2
        String[] strs2 = {""};
        List<List<String>> result2 = groupAnagrams(strs2);
        System.out.println("Test Case 2: " + result2);

        // Test Case - 3
        String[] strs3 = {"a"};
        List<List<String>> result3 = groupAnagrams(strs3);
        System.out.println("Test Case 3: " + result3);
    }
}
