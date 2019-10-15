public class SlidingWindow_MaximumSumRange {

    static int findMaximumSum(int[] arr,int k){
        int maxSum = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for(int i = 0;i < arr.length;i++){
            currentRunningSum += arr[i];

            if(i >= (k-1)){
                maxSum = Math.max(maxSum,currentRunningSum);
                currentRunningSum -= arr[i - (k-1)];
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,1,7,8,1,2,8,1,0};
        System.out.println(findMaximumSum(arr,3));
    }
}
