Longest substring without repeating characters
//conclusion:
//1.use HashSet() here to get the set implementation to assure that i don;t have //repeated characters in the maintained set
//2.some mistakes i have made during the oj process is that i omit the boundary
//also 1 problem
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        int i=0,j=1,len1=0,len2=0;
        if(size==0) return 0;
        if(size==1) return 1;
        
        
        while(i<j&&j<size){
            set.add(chars[i]);
            if(set.contains(chars[j])){
               int newi=s.indexOf(chars[j],i)+1;
               for(int k=i;k<newi;k++){
               set.remove(chars[k]);
               i=newi;
               }
               
            }
                
            set.add(chars[j]);
            len2=j-i+1;
            if(len2>len1) len1=len2;
            j++;
        }
          
        return len1;
    }
}