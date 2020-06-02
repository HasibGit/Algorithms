/*
for any number n, it takes n * log(log(n)) time to compute all prime numbers from
1 to n
 */


import java.util.*;
public class Sieve_Of_Eratosthenes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        boolean[] prime = new boolean[n+1];
        for(int i = 2;i <= n;i++){
            prime[i] = true;
        }

        for(int i = 2;i * i <= n;i++){
            if(prime[i] == true){
                for(int j = i * i;j <= n;j += i){
                    prime[j] = false;
                }
            }
        }

        for(int i = 1;i <= n;i++){
            if(prime[i]){
                System.out.print(i + " ");
            }
        }
    }
}
