package Proj10;

// Proj10Runner.java
import java.util.function.*;

public class Proj10Runner {
    // Functional interface implementations
    private Function<String, Integer> getLength = str -> str.length();
    private IntPredicate isEven = num -> num % 2 == 0;
    private BinaryOperator<String> concatenate = (str1, str2) -> str1 + str2;

    public Proj10Runner() {
        System.out.println("I certify that this program is my own work");
        System.out.println("and is not the work of others. I agree not");
        System.out.println("to share my solution with others.");
        System.out.println("Rediet Tebeje\n"); 
    }

    public int getLength(String str) {
        return getLength.apply(str);
    }

    public boolean isEven(int num) {
        return isEven.test(num);
    }

    public String concatenate(String str1, String str2) {
        return concatenate.apply(str1, str2);
    }
}