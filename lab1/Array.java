package lab1;
import java.util.Scanner;
public class Array {
    public static void main (String[] args) {
        int[] arr = {};
        int sum = 0;
        int avg = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Le Dong Canh Phu - 20225755 - Enter the number of elements: "); //Enter the number of elements
        int n = input.nextInt();
        arr = new int[n]; // Create an array with n elements
        for(int i = 0; i < n; i++) {
            System.out.print("Enter the element " + (i+1) + ": "); //Enter the element
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        avg = sum/n;
        System.out.println("Le Dong Canh Phu - 20225755 - The sum of the elements is: " + sum);
        System.out.println("Le Dong Canh Phu - 20225755 - The average of the elements is: " + avg);
        input.close();
    }
}
