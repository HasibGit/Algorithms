// find the minimum elements of all the subarrays of size m

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow_RangeMinimumQuery {
    static class Obj{
        int value;
        int index;
        Obj(int value,int index){
            this.value = value;
            this.index = index;
        }
    }

    // Last is the tail of deque, first is the head

    static void find(int[] arr,int m){
        Deque<Obj> deque = new LinkedList<Obj>();
        for(int i = 0;i < arr.length;i++){
            while (deque.size() >= 1 && deque.peekLast().value >= arr[i]){
                deque.pollLast();
            }
            deque.addLast(new Obj(arr[i],i));
//            for(Obj k : deque){
//                System.out.print(k.value + " ");
//            }
//            System.out.println();
            while(deque.size() >= 1 && deque.peekFirst().index <= i - m){
                deque.pollFirst();
            }
            if(i >= m-1){
                res.add(deque.peekFirst().value);
            }
        }
    }

    static ArrayList<Integer> res = new ArrayList<Integer>();

    public static void main(String[] args) {
        int[] arr = {10,50,15,12,4};
        find(arr,3);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
