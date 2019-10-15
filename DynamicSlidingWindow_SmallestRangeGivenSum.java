public class DynamicSlidingWindow_SmallestRangeGivenSum {

    static int findRange(int[] arr,int targetSum){
        int currentRunningSum = 0;
        int minimumWindow = Integer.MAX_VALUE;

        int windowStart = 0;

        for(int windowEnd = 0;windowEnd < arr.length;windowEnd++){
            currentRunningSum += arr[windowEnd];
            while (currentRunningSum >= targetSum){
                minimumWindow = Math.min(minimumWindow,windowEnd - windowStart + 1);
                currentRunningSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minimumWindow;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,2,7,8,1,2,8,10};
        System.out.println(findRange(arr,18));
    }
}
