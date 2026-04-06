// 274. H-Index

public class H_Index {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        // Count the number of papers for each citation count
        int[] count = new int[n + 1];
        
        for (int citation : citations) {
            // If the citation count is greater than n, we count it as n
            if (citation >= n) {
                count[n]++;
            } 
            // Otherwise, we count it in the corresponding bucket
            else {
                count[citation]++;
            }
        }
        
        int h = n;
        int total = 0;
        // Start from the highest possible h and check if we have at least h papers with at least h citations
        while (h > 0) {
            total += count[h];
            if (total >= h) {
                return h;
            }
            h--;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations)); // Output: 3

        // Test Case - 2
        int[] citations2 = {1, 3, 1};
        System.out.println(hIndex(citations2)); // Output: 1
    }
}
