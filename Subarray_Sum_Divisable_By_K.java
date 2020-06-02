import java.util.*;
public class Subarray_Sum_Divisable_By_K {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int n = input.nextInt();
        int k = input.nextInt();

        int[] arr = new int[n];


        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        int runningSum = 0;

        map.put(runningSum,1);

        int ans = 0;

        for(int i = 0;i < n;i++){
           runningSum += arr[i];

           int remainder = runningSum % k;

           if(remainder < 0){
               remainder = remainder + k;  //  so that we dont get a neg remainder
                                          // value will be same, just positive
           }

           if(map.containsKey(remainder)){
               ans += map.get(remainder);

               map.put(remainder,map.get(remainder) + 1);
           }
           else{
               map.put(remainder,1);
           }
        }
        System.out.println(ans);
    }
}
