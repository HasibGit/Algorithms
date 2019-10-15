/*
 upperbound - Max pos where after inserting the element, the arrays will stay sorted
 lowerbound - Min pos where after inserting the element, the array will stay sorted
 */


import java.util.Arrays;

public class Upperbound_And_Lowerbound {
    static int upperBound(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key){
                index = mid;      // saving index
                low = mid + 1;    // ***
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
    static int lowerBound(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key){
                index = mid;      // saving index
                high = mid - 1;    // ***
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
        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int index = upperBound(arr,8);
        int index2 = lowerBound(arr,8);
        System.out.println("Upperbound : " + index + " " + "LowerBound : " + index2);
    }
}
