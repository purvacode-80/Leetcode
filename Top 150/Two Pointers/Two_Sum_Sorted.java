// 167. Two Sum II - Input Array Is Sorted

public class Two_Sum_Sorted {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int total = 0;

        while (left < right) {
            total = numbers[left] + numbers[right];

            if (total == target) {
                return new int[]{left+1 , right+1};
            } 
            else if (target > total) {
                left++;
            }
            else {
               right--; 
            }
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] numbers1 = {2,7,11,15};
        int target1 = 9;
        int[] result1 = twoSum(numbers1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        // Test Case - 2
        int[] numbers2 = {2,3,4};
        int target2 = 6;
        int[] result2 = twoSum(numbers2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        // Test Case - 3
        int[] numbers3 = {-1,0};
        int target3 = -1;
        int[] result3 = twoSum(numbers3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");
    }
}
