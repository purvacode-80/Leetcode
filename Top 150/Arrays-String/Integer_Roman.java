// 12. Integer to Roman

public class Integer_Roman {
    public static String intToRoman(int num) {
        String result;

        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};

        result = ths[num/1000] + hrns[(num % 1000)/100] + tens[(num % 100)/10] + ones[num%10];
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int num1 = 3;
        System.out.println(intToRoman(num1)); // Output: III

        // Test Case - 2
        int num2 = 58;
        System.out.println(intToRoman(num2)); // Output: LVIII

        // Test Case - 3
        int num3 = 1994;
        System.out.println(intToRoman(num3)); // Output: MCMXCIV
    }
}
