//converting string to int
//1.used the Character's utility methods such as
//Character.isDigit(c)   Character.isLetter(c)
//Character.numericValue(c) to change to int
//Integer.parseInt(String s)
//String.valueOf(...) int/char/...
//2. to handle the overflow and underflow be careful
//str.trim()
//....
public class Solution {
    public int atoi(String str) {
        //handle whitespaces
        if(str.isEmpty()) return 0;
        str = str.trim();
        
        boolean neg=false;
        //int m=0;
       // while(m<str.length()&&(str.charAt(0)=='-'||str.charAt(0)=='+')){
        if(str.charAt(0)=='-'){ neg=true; str=str.substring(1);}
        else if(str.charAt(0)=='+'){ str=str.substring(1);}
      //  m++;
      //  }
        int k=0;
        int start=0;
        while(k<str.length()&&Character.isDigit(str.charAt(k))){//also Character.isDigit(c) isLetter(c);
            if(str.charAt(k)==0&&start==k) start++;
            k++;
        }
        if(k==0) return 0;
        str = str.substring(start,k);
        
        //handle overflow and underflow
        if(str.length()>10&&neg==false) return Integer.MAX_VALUE;
        if(str.length()>10&&neg==true) return Integer.MIN_VALUE;
        if(str.length()==10){
        int check = Integer.parseInt(str.substring(0,9));
        if(check>214748364&&neg==false) return Integer.MAX_VALUE;
        if(check>214748364&&neg==true) return Integer.MIN_VALUE;
        if(check==214748364&&neg==false&&Character.getNumericValue(str.charAt(9))>7) return Integer.MAX_VALUE;
        if(check==214748364&&neg==true&&Character.getNumericValue(str.charAt(9))>=8) return Integer.MIN_VALUE;
        str = str.substring(0,10);
           
        }
        
        int ret = Integer.parseInt(str)*(neg? -1:1);
        
        return ret;
     }
}

//solution2
//lets cheat using double
