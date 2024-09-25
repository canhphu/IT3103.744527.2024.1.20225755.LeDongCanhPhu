package lab1;
import java.util.Scanner;
public class Caculate {
    public static void main(String[] args) {
        // Use Scanner to read from keyboard
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        String strNum1 = input.nextLine();
        System.out.print("Enter the second number: ");
        String strNum2 = input.nextLine();
        // Parse string to double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        // Caculate sum, difference, product, quotient
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        // Print result
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        if (num2 == 0) {
            System.out.println("Cannot divide by zero");
            System.exit(0);
        } else {
            System.out.println("Quotient: " + quotient);
        }
    }

}
