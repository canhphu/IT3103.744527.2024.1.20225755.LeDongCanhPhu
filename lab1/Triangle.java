package lab1;
import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Le Dong Canh Phu - 20225755 - Enter your number: "); //Enter the height
        int n = input.nextInt();
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n-i;j++) { 
                System.out.print(" "); //Print space
            }
            for (int j=1;j<=2*i-1;j++) {
                System.out.print("*"); //Print star
            }
            System.out.println(); //Print new line
        }
        input.close();
    }
}
