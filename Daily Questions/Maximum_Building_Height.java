// 1840. Maximum Building Height

import java.util.ArrayList;
import java.util.List;

public class Maximum_Building_Height {
    public static int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,0});

        for (int[] r : restrictions) {
            list.add(new int[]{r[0],r[1]});
        }

        list.add(new int[]{n,n-1});

        list.sort((a,b) -> a[0] - b[0]);
        int m = list.size();

        // Left to Right
        for (int i = 1 ; i < m ; i++) {
            int distance = list.get(i)[0] - list.get(i-1)[0];

            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i-1)[1] + distance);
        }

        // Right to Left
        for (int i = m-2 ; i >= 0 ; i--) {
            int distance = list.get(i+1)[0] - list.get(i)[0];

            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i+1)[1] + distance);
        }

        int maxHeight = 0;

        for (int i = 1 ; i < m ; i++) {
            int id1 = list.get(i-1)[0];
            int h1 = list.get(i-1)[1];

            int id2 = list.get(i)[0];
            int h2 = list.get(i)[1];

            int distance = id2 - id1;

            int peak = (h1 + h2 + distance) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int n1 = 5;
        int[][] restrictions1 = {{2,1},{4,1}};
        System.out.println(maxBuilding(n1, restrictions1)); // Output: 2

        // Test Case - 2
        int n2 = 6;
        int[][] restrictions2 = {};
        System.out.println(maxBuilding(n2, restrictions2)); // Output: 5

        // Test Case - 3
        int n3 = 10;
        int[][] restrictions3 = {{5,3},{2,5},{7,4},{10,3}};
        System.out.println(maxBuilding(n3, restrictions3)); // Output: 5
    }
}