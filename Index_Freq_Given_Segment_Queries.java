import java.util.*;
import java.io.*;


public class Index_Freq_Given_Segment_Queries {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int q = input.nextInt();

        int[] arr = new int[n+1];


        for(int i = 1;i <= n;i++){
            arr[i] = input.nextInt();
        }

        int[] freq = new int[n+2];


        for(int i = 1;i <= q;i++){
            int start = input.nextInt();
            int end = input.nextInt();

            freq[start]++;
            freq[end+1]--;

        }


        freq[1] = freq[1];

        for(int i = 2;i <= n;i++){
            freq[i] = freq[i-1] + freq[i];
        }

        System.out.println("Index     " + "    Occurance");

        for(int i = 1;i <= n;i++){
            System.out.println(i + "              " + freq[i]);
        }


    }

}
