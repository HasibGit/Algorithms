/*
   for common keys, it will return the leftmost index
 */

import java.util.Arrays;

public class Binary_Search2 {
    static int binarySearch(int[] arr,int key){
        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int low = 0;
        int high = arr.length-1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key){
                index = mid;
                high = mid - 1;
            }
            else if(arr[mid] < key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,1,8,8,56,8,2};
        int index = binarySearch(arr,8);
        System.out.println(index);
    }
}
