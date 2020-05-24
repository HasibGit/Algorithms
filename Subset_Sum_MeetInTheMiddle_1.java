/*
Given an array of size <= 34, we have to find the number of subsets where sum
is in range of A and B
 */

import java.util.*;
public class Subset_Sum_MeetInTheMiddle_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long A = input.nextLong();
        long B = input.nextLong();

        long[] arr = new long[n];

        for(int i = 0;i < n;i++){
            arr[i] = input.nextLong();
        }

        int middle = n / 2;

        long[] left = new long[middle];
        long[] right = new long[n - middle];
        for(int i = 0;i < middle;i++){
            left[i] = arr[i];
        }
        for(int i = middle;i < n;i++){
            right[i - middle] = arr[i];
        }

        ArrayList<Long> set_1 = new ArrayList<Long>();
        ArrayList<Long> set_2 = new ArrayList<Long>();

        for (int i = 0; i < (1<<left.length); i++)
        {
            // Print current subset
            long sum = 0;
            boolean here = false;
            for (int j = 0; j < left.length; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0){
                    here = true;
                    sum += left[j];
                }

            if(here)
            set_1.add(sum);
        }

        for (int i = 0; i < (1<<right.length); i++)
        {
            // Print current subset
            long sum = 0;
            boolean here = false;
            for (int j = 0; j < right.length; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0){
                    here = true;
                    sum += right[j];
                }


            if(here)
            set_2.add(sum);
        }

//        for(long l : set_1){
//            System.out.print(l + " ");
//        }
//        System.out.println();
//        for(long l : set_2){
//            System.out.print(l + " ");
//        }
//        System.out.println();

        Collections.sort(set_2);

        long ans = 0;
        for(long l : set_1){
            if(l >= A && l <= B){
                ans++;
               // System.out.println("Here");
            }
        }
        for(long l : set_2){
            if(l >= A && l <= B){
                ans++;
            }
        }

        for(long l : set_1){
            long A1 = A - l;
            long B1 = B - l;

            int low = 0;
            int high = set_2.size() - 1;

            int lowerBound = -1;
            while (low <= high){
                int mid = (low + high) / 2;

                if(set_2.get(mid) >= A1){
                    lowerBound = mid;
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }

            low = 0;
            high = set_2.size() - 1;

            int higherBound = -1;
            while (low <= high){
                int mid = (low + high) / 2;
                if(set_2.get(mid) <= B1){
                    higherBound = mid;
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
            if(lowerBound != -1 && higherBound != -1){
                ans += (higherBound - lowerBound) + 1;
            }
        }

        // Does empty set work
        if(0 >= A && 0 <= B){
            ans++;
        }

        System.out.println(ans);
    }
}
