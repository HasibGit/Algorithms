import java.util.*;
public class Linear_Diophantine_Equation {
    static long gcd(long a,long b){
        long num1,num2;
        if(a > b){
            num1 = a;
            num2 = b;
        }
        else{
            num1 = b;
            num2 = a;
        }
        long rem = num2;
        while (true){
            if(num1 % num2 == 0){
                break;
            }
            rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        return rem;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // ax + by = c
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        long g = gcd(a,b);

        if(c % g == 0){
            long x = 0, y = 1, lastx = 1, lasty = 0, temp;
            while (b != 0)
            {
                long q = a / b;
                long r = a % b;

                a = b;
                b = r;

                temp = x;
                x = lastx - q * x;
                lastx = temp;

                temp = y;
                y = lasty - q * y;
                lasty = temp;
            }

            long xg = lastx;
            long yg = lasty;

            x = xg * (c / g);
            y = yg * (c / g);

            System.out.println("x " + x + " y " + y);
        }
        else{
            System.out.println("Not Possible");
        }
    }
}
