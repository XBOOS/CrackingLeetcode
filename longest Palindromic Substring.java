//Longest palindromic substring
//what i learned here is that
//1.palindromic substring you need to check. with 2 pointers
//2. you can dedicate one check work to another method.
//3. pay attention to the return type, directly return what you want instead of back tracing
 

public class Solution {
    //my fist idea here is to maintain a stach as well as a set,but here is the problem that I cannot remove the elements i want directly from the stack.
    //so here is also a LinkedHashSet which is the an ordered-version of HashSet where you maintain a doubly-linked list, taking care of the insertion order, but this remain the FIFO property
    //这道题思路是设定pivot i, 从0到n-1 对每一个i ，以i为中心，向两侧扩展直到不是回文。注意回文的两种可能，单数个字符和双数个字符。
   
    public String longestPalindrome(String s) {
  
  
        if(s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        String longest = s.substring(0,1);
        for(int i=0;i<s.length();i++){
            String temp=foo(s,i,i);
            if(temp.length()>longest.length()) longest=temp;
            String temp1=foo(s,i,i+1);
            if(temp1.length()>longest.length()) longest=temp1;
        }
        
        return longest;
    }
    
    private String foo(String s,int m,int n){
       
        while(m>=0&&n<s.length()&&s.charAt(m)==s.charAt(n)){
            m--;
            n++;
        }
       // if(m!=n-1){
            return s.substring(m+1,n);
      //  }else{
      //      return s.substring(m,n);
      //  }
    }
   /*
        //int len=0;
        //int tempLen=0;
        char[] chars = s.toCharArray();
        //Set<Character> set = new HashSet<Character>();
        Stack toolst = new Stack();
        Stack st = new Stack();
        Stack backup = new Stack();
        boolean flag=false;//to flag the palindrome duration
        String str="";
        if(s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        st.push(chars[0]);
        
        for(int i=1;i<s.length();i++){
            
            if(flag==false&&(char)st.peek()!=chars[i]){
                st.push(chars[i]);
                //here's another situation that palindrome
                if((char)st.peek()==chars[i+1]&&(i+1)<s.length()){
                    st.push(chars[i+1]);
                    i++;
                    flag=true;
                    
                }
                
            }else if((char)st.peek()==chars[i]){
                if(!flag)flag=true;
                toolst.push((char)st.pop());
               
            }else if(flag&&(char)st.peek()!=chars[i]){
                flag=false;
                while(!st.empty()){
                    st.push((char)toolst.pop());
                }
                if(st.size() > backup.size()) backup.addAll(st);
                
            }
              
        }
        
        while(!backup.empty()){
            str += (String)backup.pop();
        }
        String str1 =new StringBuffer(str).reverse().toString();
        str = str+str1;
        return str;
        
        
        */
        
        
    
}