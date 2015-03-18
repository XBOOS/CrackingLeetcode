//number of 1-bits humming weight

//1 , 32-bit interger unsigned
// mush take it to long

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long unsignedN = n & 0xffffffffl;
        int sum = 0;
        while(unsignedN!=0){
            sum+=unsignedN%2;
            unsignedN=unsignedN/2;
        }
        return sum;
    }
}