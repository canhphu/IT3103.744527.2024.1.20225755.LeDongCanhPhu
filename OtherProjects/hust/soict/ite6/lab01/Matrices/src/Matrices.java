package lab1.Matrices.src;
import java.util.Scanner;

public class Matrices {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Le Dong Canh Phu - 20225755");
        System.out.print("Enter the number of rows: "); //Enter the number of rows
        int m = input.nextInt();
        System.out.print("Enter the number of columns: "); //Enter the number of columns
        int n = input.nextInt();
        int[][] matrix1 = new int[m][n]; // Create a matrix with m rows and n columns
        int[][] matrix2 = new int[m][n]; 
            System.out.println("Matrix 1: ");
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    matrix1[i][j] = input.nextInt();
                }
            }
            System.out.println("Matrix 2: ");
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    matrix2[i][j] = input.nextInt();
                }
            }
        System.out.println("Sum of two matrices: ");
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(matrix1[i][j] + matrix2[i][j] + " "); // Print the sum of two matrices
            }
            System.out.println();
        }       
        input.close();        
    }
}
