/*
     We have to print all prime numbers between l and r where r can be max 10^9
     10^9 won't fit an array
     also we can run a loop max 10^7
     But it is given, r-l <= 10^6

     So...
       between 2 to (sqrt 10^9)= 32000 sumthing
          we cal. all the primes using sieve

       now from i = l to r
          if i <= sqrt(10^9)
             cal. directly
          else
             from all the pre cal. primes
                if any of them divides i
                   then i is not a prime number

 */


import java.io.PrintWriter;
import java.util.*;
public class Segmented_Sieve {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int limit = (int)Math.sqrt(1000000000);

        boolean[] prime = new boolean[limit + 1];

        for(int i = 2;i <= limit;i++){
            prime[i] = true;
        }


        for(int i = 2;i * i <= limit;i++){
            if(prime[i] == true){
                for(int j = i * i;j <= limit;j += i){
                  prime[j] = false;
                }
            }
        }


        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 2;i <= limit;i++){
            if(prime[i]){
                primes.add(i);
            }
        }
        int t = input.nextInt();
        while (t > 0){
            int start = input.nextInt();
            int end = input.nextInt();
            for(int i = start;i <= end;i++){
                boolean con = true;
                if(i <= limit){
                    if(prime[i]){
                        pw.println(i);
                    }
                }
                else{
                    for(int j : primes){
                        if(i % j == 0){
                            con = false;
                            break;
                        }
                    }
                    if(con == true){
                        pw.println(i);
                    }
                }
            }
            if(t - 1 > 0)
            pw.println();
            t--;
        }
        pw.flush();
        pw.close();
    }
}
