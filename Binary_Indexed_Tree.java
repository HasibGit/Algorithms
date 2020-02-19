// we are gonna do range sum query

import java.util.*;
public class Binary_Indexed_Tree {

    static int[] tree;


    static int getNext(int vertex){
        return vertex + (vertex & -vertex);
    }

    static void buildTree(int[] arr,int n){
        tree = new int[n+1];
        for(int i = 0;i < n;i++){
           tree[(i+1)] = tree[(i+1)] + arr[i];
           int val = arr[i];
           int vertex = (i+1);

           while (true){
               int next = getNext(vertex);
               if(next > n){
                   break;
               }
               else{
                   tree[next] += val;
                   vertex = next;
               }
           }
        }
    }

    static int getParent(int vertex){
        return  vertex - (vertex & -vertex);
    }

    static int rangeSumQuery(int start,int end){
        int rightFlank = end + 1;
        int sum = 0;
        sum += tree[rightFlank];
        int parent = -1;
        while (true){
            parent = getParent(rightFlank);
            if(parent == 0){
                break;
            }
            sum += tree[parent];
            rightFlank = parent;
        }
        int sum2 = 0;
        if(start > 0){
            int leftFlank = start;
            sum2 += tree[leftFlank];
            parent = -1;
            while (true){
                parent = getParent(leftFlank);
                if(parent == 0){
                    break;
                }
                sum2 += tree[parent];
                leftFlank = parent;
            }
        }
        sum = sum - sum2;
        return sum;
    }

    static void update(int index,int updateValue){
        tree[index+1] += updateValue;
        int vertex = index+1;
        while (true){
            int next = getNext(vertex);
            if(next >= tree.length){
                break;
            }
            tree[next] += updateValue;
            vertex = next;
        }
        return;
    }

    public static void main(String[] args) {
        // input array
        /*
        11
        3 2 -1 6 5 4 -3 3 7 2 3
        */
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = input.nextInt();
        }
        buildTree(arr,n);
/*
   Check Tree
   for(int i = 0;i < tree.length;i++){
            System.out.print(tree[i] + " ");
   }
 */

        System.out.println(rangeSumQuery(0,6));
/*
 check update
 update(4,5);
 System.out.println(rangeSumQuery(3,5));
 */


    }
}
