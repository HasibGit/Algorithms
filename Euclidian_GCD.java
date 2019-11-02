import java.util.*;
public class Euclidian_GCD {
    static int gcd(int a,int b){
        int num1,num2;
        if(a > b){
            num1 = a;
            num2 = b;
        }
        else{
            num1 = b;
            num2 = a;
        }
        int rem = 0;
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
        int a = input.nextInt();
        int b = input.nextInt();
        int gcd = gcd(a,b);
        System.out.println(gcd);
    }
}
