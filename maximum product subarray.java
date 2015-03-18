//maximum product subarray
//50% acceptance rate cool!!!
public class Solution {
    public int maxProduct(int[] A) {
        int n = A.length;
        if(n<2) return A[0];
        int max = A[0];
        int min = A[0];
        int productMax = A[0];
        int productMin = A[0];
        int prevProMax;
       // int prevProMin;
        for(int i=1;i<n;i++){
            prevProMax = productMax;
            //prevProMin = productMin;
            productMax = Math.max(Math.max(productMax*A[i],productMin*A[i]),A[i]);
            if(productMax>max)max = productMax;
             productMin = Math.min(Math.min(prevProMax*A[i],productMin*A[i]),A[i]);
            if(productMin<min)min = productMin;
        }
        
        return max;
    }
}