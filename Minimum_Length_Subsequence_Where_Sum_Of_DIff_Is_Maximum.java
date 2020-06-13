/*
       We want a subsequence a,b,c,d,e.. from an array where
       |a-b| + |b-c| + |c-d| + ..
       this sum is maximum and the length of this subsequence
       need to be minimum possible.

       Key Trick:

           Just consider the peak and fall values.
           1,3,4,7,2,1,-5,4
           1 to 7 val increase..
           1-3 = 2 ; 3-4 = 1 ; 4-7 = 3 ;2 + 1 + 3 = 6 but...
           we can consider 1-7 direct, sum is same, len is less
           same concept with decreasing
           from 7 to -5 it dec, then it inc again, so we'll consider -5

           ** draw diff points on 2d graph and mark peak and fall for better understanding
 */




public class Minimum_Length_Subsequence_Where_Sum_Of_DIff_Is_Maximum {
}
