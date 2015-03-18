//Reverse Integer
//1. to check for overflow/underflow
//we could check if ret>214748364 or ret<-214748364 before multiplying by 10

//to reverse a integer I used the string to concatinate each digit but this is not a good solution
//i could just directly do it.


//solution 1

import java.util.*;
public class Solution {
    //data type conversion
    public int reverse(int x) {
        //take care of the overflow!!!!!
        //take care of the ending 0s
        if(x>=0&&x<10) return x;
        boolean flag=true;
       
        if(x<0){
            if(x==Integer.MIN_VALUE)return 0;
            flag=false;
            x = x*(-1);
        }
        
        while(x%10==0){
            x=x/10;
        }
        
        Vector nums = new Vector();
        String res="";
        while(x!=0){
            nums.add(x%10);
            x/=10;
        }
        //take care of the integer overflow
        
        int top = (int)nums.firstElement();
        if(nums.size()==10&&top>=3){
        //overflow happens
        return 0;
            
        }else if(nums.size()==10&&top==2){
            //a risk of overflow
            int remain = Integer.MAX_VALUE-(int)Math.pow(10,9)*2;
            for(int i=1;i<nums.size();i++){
                res+=String.valueOf(nums.get(i));
            }
          //  int temp= Integer.parInt(res);
            if(Integer.parseInt(res)>remain){
                return 0;
            }else{
                res=""+nums.get(0)+res;
            }
        }else{
            for(int i=0;i<nums.size();i++){
                res+=String.valueOf(nums.get(i));
            }
        }
        if(flag==false) return (Integer.parseInt(res))*(-1);
        return Integer.parseInt(res);
    }
}


//solutio 2 faster solution

public class Solution {
    //data type conversion
    public int reverse(int x) {
        //take care of the overflow!!!!!
        //take care of the ending 0s
        
        boolean neg=false;
       
        if(x<0){
            if(x==Integer.MIN_VALUE)return 0;
            neg=true;
            x = -x;
        }
        int ret=0;
        while(x!=0){
            if(ret>214748364)return 0;
            if(ret==214748364){
                if(x%10>7)return 0;
            }
            ret = ret*10+x%10;
            x/=10;
        }
        
       if(neg){return -ret;}
       return ret;
    }
}