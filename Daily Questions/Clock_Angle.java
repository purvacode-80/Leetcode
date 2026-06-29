// 1344. Angle Between Hands of a Clock

public class Clock_Angle {
    public static double angleClock(int hour, int minutes) {
        // Minute hand moves 6 degrees per minute (360 degrees / 60 minutes)
        double minAngle = 6 * minutes;
        // Hour hand moves 30 degrees per hour (360 degrees / 12 hours) 
        // and 0.5 degrees per minute (30 degrees / 60 minutes)
        double hourAngle = 30 * (hour % 12) + 0.5 * minutes;
        // Calculate the absolute difference between the two angles - Positive diff
        double diff = Math.abs(hourAngle - minAngle);
        // Return the smaller angle between the two hands
        return Math.min(360 - diff, diff);
    }

    public static void main(String[] args) {
        // Test Case - 1 : 3:15
        int hour1 = 3;
        int minutes1 = 15;
        double angle1 = angleClock(hour1, minutes1);    // 7.5
        System.out.println("The angle between the hands of the clock at " + hour1 + ":" + minutes1 + " is: " + angle1 + " degrees.");

        // Test Case - 2 : 12:30
        int hour2 = 12;
        int minutes2 = 30;
        double angle2 = angleClock(hour2, minutes2);    // 165
        System.out.println("The angle between the hands of the clock at " + hour2 + ":" + minutes2 + " is: " + angle2 + " degrees.");

        // Test Case - 3 : 3:30
        int hour3 = 3;
        int minutes3 = 30;
        double angle3 = angleClock(hour3, minutes3);    // 75
        System.out.println("The angle between the hands of the clock at " + hour3 + ":" + minutes3 + " is: " + angle3 + " degrees.");
    }
}