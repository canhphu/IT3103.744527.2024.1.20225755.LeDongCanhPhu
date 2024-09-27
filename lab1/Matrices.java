package lab1;
import java.util.Scanner;

public class Matrices {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Le Dong Canh Phu - 20225755");
        System.out.print("Enter the number of rows: "); //Enter the number of rows
        int m = input.nextInt();
        System.out.print("Enter the number of columns: "); //Enter the number of columns
        int n = input.nextInt();
        int[][] matrix = new int[m][n]; // Create a matrix with m rows and n columns
        for (int k = 0;k<2;k++) {
            System.out.println("Matrix " + (k+1));
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print("Enter the element at position (" + (i+1) + ", " + (j+1) + "): "); //Enter the element
                    matrix[i][j] = input.nextInt();
                }
            }
            System.out.println("Le Dong Canh Phu - 20225755 - Matrix " + (k+1) + " is: ");
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }       
        input.close();        
    }
}
