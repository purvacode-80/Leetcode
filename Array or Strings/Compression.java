class Compression {
    public static int compress(char[] chars) {
        if(chars.length == 0 || chars == null) {
            return 0;
        }
        if(chars.length == 1) {
            return 1;
        }
        int write = 0;  // Pointer to write the compressed characters or counts
        int count = 1;  // Count of the current character

        for(int i=0;i<chars.length;i++) {
            // If the current character is the same as the next one, increment the count
            // Otherwise, write the character and its count if greater than 1
            if(i+1 < chars.length && chars[i]==chars[i+1]) {
                count++;
            }
            else  {
                chars[write++] = chars[i];
                if(count > 1) {
                        String writeString = Integer.toString(count);
                        // Write the count as characters
                        for(int j=0;j<writeString.length();j++) {
                            chars[write++] = writeString.charAt(j);
                        }
                }
                count = 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        // Test Case - 1
        char[] chars1 = {'a','a','b','b','c','c','c'};
        int length1 = compress(chars1);
        System.out.println("Compressed Length : " + length1);
        System.out.print("Compressed Characters: ");
        for(int i=0;i<length1;i++) {
            System.out.print(chars1[i] + " ");
        }
        System.out.println();

        // Test Case - 2
        char[] chars2 = {'a'};
        int length2 = compress(chars2);
        System.out.println("Compressed Length : " + length2);
        System.out.print("Compressed Characters: ");
        for(int i=0;i<length2;i++) {
            System.out.print(chars2[i] + " ");
        }
        System.out.println();

        // Test Case - 3
        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int length3 = compress(chars3);
        System.out.println("Compressed Length : " + length3);
        System.out.print("Compressed Characters: ");
        for(int i=0;i<length3;i++) {
            System.out.print(chars3[i] + " ");
        }
    }
}