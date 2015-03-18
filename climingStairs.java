//climing stairs
public class Solution {
    //this is dynamic programming not divide and conquer because subproblems have intersections
    //solution1 top-down method with the recursive calls and data memoization, a little bit slow due to the time consumption due to recursive calls
    //solution2 bottom-up method start from the bottom do the data processing
    //solution3 the "programming"part, make the matrix
    boolean flag = true;
    int[] record;
    private void initialize(int n){
     flag=false;
     record = new int[n];
     record[0]=1;
     record[1]=1;
     //record[2]=2;
    }
    public int climbStairs(int n) {
        if(n<2)return 1;
       if(n==2)return 2;
        if(flag)initialize(n);
        
        if(record[n-1]!=0){
            
            return record[n-1];
        }else{
            int res = climbStairs(n-1)+climbStairs(n-2);
            record[n-1]=res;
            return res;
        }
        
    }
}


//solution2
public class Solution {
    //solution2 bottom-up method start from the bottom do the data processing
    

    public int climbStairs(int n) {
        if(n<2)return 1;
       if(n==2)return 2;
       int[] record = new int[n];
       record[0]=1;
       record[1]=2;
       int i=2;
        while(i<n){
            record[i]=record[i-1]+record[i-2];
            i++;
        }
        return record[n-1];
    }
}