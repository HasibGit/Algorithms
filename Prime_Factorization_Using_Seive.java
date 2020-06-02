/*
  for seive precomputation it take n * log ( log (n) )
  And for every query to get all prime factors of a number N
      it takes log ( N ) time.
 */


import java.util.*;
public class Prime_Factorization_Using_Seive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] prime = new int[100000+1];
        Arrays.fill(prime,-1);

        for(int i = 2;i * i < prime.length;i++){
            if(prime[i] == -1){
                for(int j = i * i;j < prime.length; j += i){
                    if(prime[j] == -1){
                        prime[j] = i;
                    }
                }
            }
        }



        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            while (true){
                if(prime[n] == -1){
                    System.out.print(n);
                    break;
                }
                else{
                    System.out.print(prime[n] + " ");
                    n = n / prime[n];
                }
            }
            System.out.println();
            t--;
        }
    }
}
