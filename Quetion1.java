/* Max Min

Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.

Example 1:

Input:
N = 5
A[] = {-2, 1, -4, 5, 3}
Output: 1
Explanation: min = -4, max =  5. Sum = -4 + 5 = 1
 

Example 2:

Input:
N = 4
A[]  = {1, 3, 4, 1}
Output: 5
Explanation: min = 1, max = 4. Sum = 1 + 4 = 5
 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function findSum() which takes the array A[] and its size N as inputs and returns the summation of minimum and maximum element of the array.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
-109 <= Ai <= 109

*/

public class Quetion1 {
    static class Pair{
        int max;
        int min;
    }
    
    static Pair getMinMax(int A[], int N){
        Pair minmax = new Pair();
        
        if(N==1){
            minmax.max=A[0];
            minmax.min=A[0];
            return minmax;
        }
        
        if(A[0]>A[1]){
            minmax.max=A[0];
            minmax.min=A[1];
        } else{
            minmax.max=A[1];
            minmax.min=A[0];
        }
        
        for(int i=2; i<N; i++){
            if(A[i]>minmax.max) minmax.max=A[i];
            else if(A[i]<minmax.min) minmax.min=A[i];
        }
        return minmax;
    }
    
    public static int findSum(int A[],int N) 
    {
        //code here
        Pair minmax = getMinMax(A, N);
        return minmax.max + minmax.min;
        
    }
}
