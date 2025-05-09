package Proj12;
import java.util.function.Predicate;

public class Proj12Runner {
    public boolean[] run(String x, String y, String z) {
        // Display certification message
        System.out.println("I certify that this program is my own work");
        System.out.println("and is not the work of others. I agree not");
        System.out.println("to share my solution with others.");
        System.out.println("Rediet Tebeje");

        // Create a Predicate using lambda expression to check for palindromes
        Predicate<String> isPalindrome = str -> {
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        };

        // Evaluate each string and return results
        return new boolean[] {
                isPalindrome.test(x),
                isPalindrome.test(y),
                isPalindrome.test(z)
        };
    }
}