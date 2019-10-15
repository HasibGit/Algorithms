public class SegmentTree_RangeMaximumQuery {
    static int nextPowerOf2(int n)
    {
        int count = 0;

        // First n in the below
        // condition is for the
        // case where n is 0
        if (n > 0 && (n & (n - 1)) == 0)
            return n;

        while(n != 0)
        {
            n = n >> 1;
            count = count + 1;
        }

        return 1 << count;
    }
    static boolean isPowerOfTwo(int n){
        return n > 0 && ((n & (n-1)) == 0);
    }

    static int[] segmentTree;
    static void constructSegmentTree(int[] input,int low,int high,int pos){
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructSegmentTree(input,low,mid,2 * pos + 1);
        constructSegmentTree(input,mid+1,high,2 * pos + 2);
        segmentTree[pos] = Math.max(segmentTree[2 * pos + 1],segmentTree[2 * pos + 2]);
    }
    static int rangeMaximumQuery(int low,int high,int quertLow,int queryHigh,int pos){
        // Total Overlap
        if(quertLow <= low && queryHigh >= high){
            return segmentTree[pos];
        }
        // No overlap
        else if(quertLow > high || queryHigh < low){
            return Integer.MIN_VALUE;
        }
        else{
            int mid = (low + high) / 2;
            int p1 = rangeMaximumQuery(low,mid,quertLow,queryHigh,2 * pos + 1);
            int p2 = rangeMaximumQuery(mid+1,high,quertLow,queryHigh,2 * pos + 2);
            return Math.max(p1,p2);
        }
    }
    public static void main(String[] args) {
        int[] input = {4,6,1,2,0,5,12,44};
        int length = input.length;
        int size = 0;
        if(isPowerOfTwo(length)){
            size = length * 2 - 1;
        }
        else {
            size = nextPowerOf2(length) * 2 -1;
        }
        segmentTree = new int[size];
        // Since we are going to do range max query..
        for(int i = 0;i < segmentTree.length;i++){
            segmentTree[i] = Integer.MIN_VALUE;
        }
        constructSegmentTree(input,0,input.length-1,0);
        System.out.println(rangeMaximumQuery(0,input.length-1,0,6,0));
    }
}
