import java.util.*;

/*
   test example
3
0 2 1 -8
1 -2 -3 0
-1 1 2 3

 */

public class Gaussian_Elimination_Algorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of equations : ");
        int n = input.nextInt();  // number of equn

        double[][] matrix = new double[n][n+1]; // augmented matrix

        for(int i = 0;i < n;i++){
            for(int j = 0;j <= n;j++){
                matrix[i][j] = input.nextDouble();
            }
        }

        // partial pivoting

        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                if(matrix[i][i] < matrix[j][i]){
                    for(int k = 0;k <= n;k++){
                        double temp = matrix[i][k];
                        matrix[i][k] = matrix[j][k];      // swapping rows for pivoting
                        matrix[j][k] = temp;
                    }
                }
            }
        }


        System.out.print("\n\n");


        // matrix after pivoting
        System.out.println("Matrix after pivoting : ");
        for(int i = 0;i < n;i++){
            for(int j = 0;j <= n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0;i < n-1;i++){
            for(int k = i+1;k < n;k++){
                double t = matrix[k][i]/matrix[i][i];
                for(int j = 0;j <= n;j++){
                    matrix[k][j] = matrix[k][j] - (t * matrix[i][j]);
                }
            }
        }
        System.out.print("\n\n");

        System.out.println("Matrix after gaussian elimination : ");

        for(int i = 0;i < n;i++){
            for(int j = 0;j <= n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        double[] x = new double[n];  // result

        // back substitution

        for(int i = n-1;i >= 0;i--){
            double coefficient = matrix[i][i];
           // System.out.println("Coeffecient : " + coefficient);
            if(coefficient == 0){
                x[i] = Double.POSITIVE_INFINITY;
            }
            else{
                double sum = 0;
                for(int j = i+1;j < n;j++){
                    sum += matrix[i][j] * x[j];
                }
                x[i] = (matrix[i][n] - sum) / coefficient;
            }
            //System.out.println("x[i] " + x[i]);
        }

        System.out.println("Result : ");
        for(int i = 0;i < n;i++){
            System.out.println("x" + i + " : " + x[i]);
        }

    }
}
