import java.util.Arrays;

public class Binary_Search {
    static int binarySearch(int[] arr,int key){
        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {5,3,1,8,38,56,28,2};
        int index = binarySearch(arr,8);
        System.out.println(index);
    }
}
