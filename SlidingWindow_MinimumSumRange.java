public class SlidingWindow_MinimumSumRange {
    static int findMinimumSum(int[] arr,int k){
        int minimumSum = Integer.MAX_VALUE;
        int currentRunningSum = 0;

        for(int i = 0;i < arr.length;i++){
            currentRunningSum += arr[i];
            if(i >= (k-1)){
                minimumSum = Math.min(minimumSum,currentRunningSum);
                currentRunningSum -= arr[i - (k-1)];
            }
        }
        return minimumSum;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,7,8,1,2,8,1,0};
        System.out.println(findMinimumSum(arr,3));
    }
}
