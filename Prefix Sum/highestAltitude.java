// 1732. Find the Highest Altitude

public class highestAltitude {

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currAltitude = 0;

        for (int i : gain) {
            currAltitude += i;
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }
        return maxAltitude;
    }

    public static void main(String[] args) {
        //Case 1
        int[] gain1 = {-5, 1, 5, 0, -7};
        System.out.println("Highest Altitude Case 1: " + largestAltitude(gain1)); // 1

        //Case 2
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Highest Altitude Case 2: " + largestAltitude(gain2)); // 0
    }
}