// 605. Can Place Flowers

class NoAdjacentFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Check if the flowerbed is empty or if n is greater than the length of flowerbed
        if (flowerbed == null || flowerbed.length == 0 || n > flowerbed.length) {
            return false;
        }

        if (n == 0) {
            return true; // If no flowers need to be planted, return true
        }

        int count = 0;

        for(int i = 0; i < flowerbed.length; i++) {
            // Check if current position is empty

            if(flowerbed[i] == 0) {
                // Check if left and right slot is empty
                boolean emptyLeft = (i == 0 || flowerbed[i - 1] == 0);
                boolean emptyRight = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    // If both left and right are empty, we can place a flower here
                    flowerbed[i] = 1; // Place a flower
                    count++; // Increment the count of flowers placed
                    
                    // If we have placed enough flowers, return true
                    if(count >= n) {
                        return true;
                    }                    
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean result = canPlaceFlowers(flowerbed, n);
        System.out.println("Can place " + n + " flowers : " + result); // Expected: true

        n = 2;
        result = canPlaceFlowers(flowerbed, n);
        System.out.println("Can place " + n + " flowers : " + result); // Expected: false

        n=0;
        int[] flowerbed2 = {1,0,1,0,1,0,1};
        result = canPlaceFlowers(flowerbed2, n);
        System.out.println("Can place " + n + " flowers : " + result); // Expected: true
    }
}