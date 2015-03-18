//twoSum
//this is not a good method
//i copied it to have the information for original order, then sort it
//use Arrays.sort() which uses binary sort so that I achieved the O(n logn)
//for the resualts i make a trick to let one result go into one space each time
//but here i can see that use a set could be better, i can let the insertion order determine the index

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int[] backup = Arrays.copyOf(numbers,size);
        Arrays.sort(numbers);//to sort the array in O(n logn)
        
        int i=0,j=size-1;
       while(i<j){
           if(numbers[i]+numbers[j]==target){
               break;
           }
           else if(numbers[i]+numbers[j]<target){
               i++;
           }
           else{
               j--;
           }
       }
       int[] results = new int[2];
       boolean flag=true;
       //i cant use the Arrays.binarySearch here because this also needs sorting prior to this
       for(int k=0;k<size;k++){
           if(backup[k]==numbers[i]||backup[k]==numbers[j]){ 
               if(flag){
                   results[0]=k+1;
                   flag=false;
               }else{
                   results[1]=k+1;
               }
               
           }
          
               
       }
       
               return results;
      
    }
}