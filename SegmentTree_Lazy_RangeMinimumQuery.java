public class SegmentTree_Lazy_RangeMinimumQuery {

    static int powerOfTwo(int n){
        if((n > 0 && (n & (n-1)) == 0)){
            return n;
        }
        else{
            int count = 0;
            while (n != 0){
                n = n >> 1;
                count += 1;
            }
            return 1 << count;
        }
    }
    static int[] segmentTree;
    static int[] lazy;
    static void constructSegmentTree(int[] arr,int low,int high,int pos){
        if(low == high){
            // left
            segmentTree[pos] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        constructSegmentTree(arr,low,mid,2 * pos + 1);
        constructSegmentTree(arr,mid+1,high,2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1],segmentTree[2 * pos + 2]);
    }

    static void update(int start,int end,int rangeStart,int rangeEnd,int val,int pos){
        if(start > end){
            return;
        }
        if(lazy[pos] != 0){
            segmentTree[pos] += lazy[pos];
            if(start != end){
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] +=  lazy[pos];
            }
            lazy[pos] = 0;
        }
        // no overlap
        if(rangeStart > end || rangeEnd < start){
            return;
        }
        // total overlap
        if(rangeStart <= start && rangeEnd >= end){
            segmentTree[pos] += val;
            if(start != end){
                // not leaf
                lazy[2 * pos + 1] += val;
                lazy[2 * pos + 2] += val;
            }
            return;
        }
        // partial overlap
        int mid = (start + end) / 2;
        update(start,mid,rangeStart,rangeEnd,val,2 * pos + 1);
        update(mid + 1,end,rangeStart,rangeEnd,val,2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1],segmentTree[2 * pos + 2]);
    }

    static int rangeMinimumQuery(int start,int end,int rangeStart,int rangeEnd,int pos){
        if(start > end){
            return Integer.MAX_VALUE;
        }
        if(lazy[pos] != 0){
            segmentTree[pos] += lazy[pos];
            if(start != end){
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }
        // no overlap
        if(rangeStart > end || rangeEnd < start){
            return Integer.MAX_VALUE;
        }
        // total overlap
        if(rangeStart <= start && rangeEnd >= end){
            return segmentTree[pos];
        }
        // partial overlap
        int mid = (start + end) / 2;
        int p1 = rangeMinimumQuery(start,mid,rangeStart,rangeEnd,2 * pos + 1);
        int p2 = rangeMinimumQuery(mid+1,end,rangeStart,rangeEnd,2 * pos + 2);
        return Math.min(p1,p2);
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,7,9,5,12,0};
        int size = powerOfTwo(arr.length) * 2 - 1;
        segmentTree = new int[size];
        lazy = new int[size];

        for(int i = 0;i < size;i++){
            segmentTree[i] = Integer.MAX_VALUE;
            lazy[i] = 0;
        }

        constructSegmentTree(arr,0,arr.length-1,0);

        System.out.println(rangeMinimumQuery(0,arr.length-1,1,5,0));

        update(0,arr.length-1,2,6,3,0);

        System.out.println("After update : ");
        System.out.println(rangeMinimumQuery(0,arr.length-1,2,6,0));

    }
}
