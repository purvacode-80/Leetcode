// 134. Gas Station

public class Gas_Station {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;  // Starting point of the circuit
        int currentGas = 0; // Current amount of gas in the tank
        int totalGas = 0;   // Total net gas after completing the circuit

        for(int i = 0; i < gas.length; i++) {
            // Calculate the net gas gain or loss at each station
            int fuelGain = gas[i] - cost[i];
            totalGas += fuelGain;
            currentGas += fuelGain;

            // If currentGas drops below 0, it means we cannot start from the previous station
            // We need to reset currentGas and update the starting point to the next station
            if(currentGas < 0) {
                currentGas = 0;
                start = i+1;
            }

            // Debugging output to trace the computation at each station
            // System.err.println("Station: " + i + ", Fuel Gain: " + fuelGain + ", Current Gas: " + currentGas + ", Total Gas: " + totalGas);
        }
        return totalGas < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas1, cost1)); // Output: 3

        // Test Case - 2
        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        System.out.println(canCompleteCircuit(gas2, cost2)); // Output: -1
    }
}