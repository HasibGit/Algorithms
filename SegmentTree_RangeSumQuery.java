public class SegmentTree_RangeSumQuery {
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
        segmentTree[pos] = (segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2]);
    }
    static int rangeSumQuery(int low,int high,int quertLow,int queryHigh,int pos){
        // Total Overlap
        if(quertLow <= low && queryHigh >= high){
            return segmentTree[pos];
        }
        // No overlap
        else if(quertLow > high || queryHigh < low){
            return 0;
        }
        else{
            int mid = (low + high) / 2;
            int p1 = rangeSumQuery(low,mid,quertLow,queryHigh,2 * pos + 1);
            int p2 = rangeSumQuery(mid+1,high,quertLow,queryHigh,2 * pos + 2);
            return p1 + p2;
        }
    }
    public static void main(String[] args) {
        int[] input = {3,2,1,4,5};
        int length = input.length;
        int size = 0;
        if(isPowerOfTwo(length)){
            size = length * 2 - 1;
        }
        else {
            size = nextPowerOf2(length) * 2 -1;
        }
        segmentTree = new int[size];
        // Since we are going to do range sum query..
        for(int i = 0;i < segmentTree.length;i++){
            segmentTree[i] = 0;
        }
        constructSegmentTree(input,0,input.length-1,0);
        for(int i = 0;i < segmentTree.length;i++){
            System.out.print(segmentTree[i] + " ");
        }
        System.out.println();
        System.out.println(rangeSumQuery(0,input.length-1,2,5,0));
    }
}
