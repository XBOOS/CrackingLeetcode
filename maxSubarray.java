//maximum subarray
O(n) time

{
     
    public int maxSubArray(int[] A) {
        int n = A.length;
        if(n<2)return A[0];
        
        int longest =A[0];
        int len=0;
        for(int i=0;i<n;i++){
            len =Math.max(len+A[i],A[i]);
            if(len>longest){
                longest = len;
            }
        }
        
        return longest;
    }
    
}

//should try divide and conquer
//method 2
public class Solution {
     
    public int maxSubArray(int[] A) {
      //the divide and conquer method
      //divide into two parts
      int n = A.length;
      //if(n<2) return A[0];
      return recur(A,0,n);
        
    }
    private int recur(int[] A,int left,int right){
        if(left>right) return Integer.MIN_VALUE;
        if(right-left<2)return A[left];
        
        int mid = (left+right)/2;
        int max1 =  Math.max(recur(A,left,mid),recur(A,mid,right));
        
        //int max2 = Integer.MIN_VALUE;
        int lhalf = 0;//A[mid];
        int lmax = 0;//A[mid];
        
        for(int i=mid-1;i>left-1;i--){
            lhalf+=A[i];
            if(lhalf>lmax) lmax=lhalf;
        }
      //  if((mid+1)<right){
        int rhalf = 0;//A[mid+1];
        int rmax = 0;//A[mid+1];
        for(int i=mid+1;i<right;i++){
            rhalf+=A[i];
            if(rhalf>rmax) rmax=rhalf;
        }
           int  max2 = lmax+rmax+A[mid];
       // }else{
       //      max2 = lmax;
       // }
        return Math.max(max1,max2);
    }
    
}


//method 3
