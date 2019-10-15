// Find the longest subarray where the number of distinct characters is less than k

import java.util.HashMap;

public class DynamicSlidingWindow_AuxiliaryDataStructure {
    static int find(char[] arr, int k){
        int windowStart = 0;
        int longestSubarray = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int windowEnd = 0;windowEnd < arr.length;windowEnd++){
            char c = arr[windowEnd];
            if(map.get(c) == null){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c) + 1);
            }

            while (map.size() >= k){
                char remove = arr[windowStart];
                windowStart++;

                map.put(remove,map.get(remove) - 1);
                if(map.get(remove) == 0){
                    map.remove(remove);
                }
            }
            longestSubarray = Math.max(longestSubarray,windowEnd - windowStart + 1);
        }
        return longestSubarray;
    }

    public static void main(String[] args) {
          char[] arr = {'a','a','a','h','h','i','b','c'};
        System.out.println(find(arr,3));
    }
}
