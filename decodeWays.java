//decode ways
//what i learned here, be careful about the boundary situations.
//it can start from 0s 
//i improved from codes[i-2]*2 to codes[i-2]+codes[i-1]

public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n==0) return 0;
        if(s.charAt(0)=='0') return 0;
        if(n==1) return 1;
        
        int[] codes = new int[n];
        for(int i=0;i<n;i++){
            codes[i] = s.charAt(i)-'0';
        }
        
        int[] ways=new int[n];
        ways[0] = 1;
        for(int i=1;i<n;i++){
            
            if(i==1){
                if(codes[i]==0){
                    if(codes[0]==1||codes[0]==2){
                ways[i]=1;
                    }else{
                        return 0;
                    }
                }else if(codes[i]>0&&codes[i]<7){
                    if(codes[0]==1||codes[0]==2){
                        ways[i]=2;
                    }else{
                        ways[i]=1;
                    }
                }else if(codes[i]>6&&codes[0]==1){
                    ways[i]=2;
                }else{
                    ways[i]=1;
                }
                
            }else{
            
            if(codes[i]==0){
                if(codes[i-1]==1||codes[i-1]==2){
                    ways[i] = ways[i-2];
                }else{
                    return 0;
                }
                
            }else if(codes[i]>0&&codes[i]<7){
                if(codes[i-1]==1||codes[i-1]==2){
                    ways[i] = ways[i-2]+ways[i-1];
                }else{
                    ways[i] = ways[i-1];
                }
            }else{//codes[i]>6
                if(codes[i-1]==1){
                    ways[i] = ways[i-2]+ways[i-1];
                }else{
                    ways[i] = ways[i-1];
                }
            }
        }
        }
        return ways[n-1];
    }
}