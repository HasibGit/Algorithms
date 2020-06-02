import java.util.*;
/*
Test
7
3 1 5 2 6 4 9
 */

public class Longest_Increasing_Subsequence_O_nlogn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        int[] temp = new int[n];
        int lastElement = Integer.MIN_VALUE;
        int len = 0;
        for(int i = 0;i < n;i++){
            if(arr[i] > lastElement){
                temp[len] = arr[i];
                lastElement = arr[i];
                len++;
            }
            else{
                int low = 0;
                int high = len-1;
                int pos = -1;
                while (low <= high){
                    int mid = (low + high) / 2;
                    if(temp[mid] >= arr[i]){
                        pos = mid;
                        high = mid - 1;
                    }
                    else{
                        low = mid + 1;
                    }
                }
                try {
                    if(temp[pos] == lastElement){
                        lastElement = arr[i];
                    }
                    temp[pos] = arr[i];
                }
                catch (Exception e ){
                    System.out.println(pos);
                }

            }
        }

        System.out.println("Length of the Longest Increasing Subsequence : " + len);
    }
}
