//zigzag conversion
//what i learned here
//1.dont add what i dont need e.g. that i dont need a matrix to store the detailed each row information,
//i just need a array of strings
//2. make sure the initializaion and base case
//3.some methods are built in methods some are class static algorithms
//e.g. the Arrays.fill()
//4.if you create a object without initializaion, it is a new, if i directly add+"" it is "null" 
//5. the iteration problem, here the period is 2*nRows-2
//6. remember the *
public class Solution {
    public String convert(String s, int nRows) {
        if(nRows==0)return "";
        if(nRows==1)return s;
        //if(nRows==2)
        if(nRows>=s.length()) return s;
        
        //char[][] matrix = new char[nRows][s.length()];
        
        String[] res = new String[nRows];
        Arrays.fill(res,"");
        //res.fill("",nRows);
        for(int i=0;i<s.length();i++){
            //int m=(i+1)/(2*nRows-2);//quotient
            int n=(i+1)%(2*nRows-2);//remainder
            if(n>=1&&n<=nRows){
                res[n-1]+=s.charAt(i);
            }else {
                res[(2*nRows-n-1)%(2*nRows-2)]+=s.charAt(i);
            }
            
        }
        String result="";
        for(int i=0;i<nRows;i++){
            if(res[i]!=null){result+=res[i];}
            }
        
        return result;
    }
}