import java.util.*;
public class MergeSort {

    static void mergesort(int[] arr,int left,int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergesort(arr,left,mid);
            mergesort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    static void merge(int[] arr,int left,int mid,int right){
        int[] left_Array = new int[mid - left + 1];
        int[] right_Array = new int[right - mid];

        for(int i = 0;i < left_Array.length;i++){
            left_Array[i] = arr[left+i];
        }
        for(int i = 0;i < right_Array.length;i++){
            right_Array[i] = arr[mid + 1 + i];
        }

        int i = 0,j = 0,k = left;
        while (i < left_Array.length && j < right_Array.length){
            if(left_Array[i] <= right_Array[j]){
                arr[k++] = left_Array[i++];
            }
            else{
                arr[k++] = right_Array[j++];
            }
        }
        while (i < left_Array.length){
            arr[k++] = left_Array[i++];
        }
        while (j < right_Array.length){
            arr[k++] = right_Array[j++];
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        mergesort(arr,0,arr.length-1);

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
