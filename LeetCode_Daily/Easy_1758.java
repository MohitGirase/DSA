package LeetCode_Daily;

/*
class Solution {
    public int minOperations(String s) {

        int n = s.length();

        int startingWith0 = 0;
        int startingWith1 = 0;

        for(int i=0; i<n; i++){
            if((i%2==0 && s.charAt(i) == '1') || (i%2==1 && s.charAt(i) == '0')){
                startingWith0++;
            }
            if((i%2==0 && s.charAt(i) == '0') || (i%2==1 && s.charAt(i) == '1')){
                startingWith1++;
            }
        }
        return Math.min(startingWith0, startingWith1);
    }
}
 */
public class Easy_1758 {
    public int minOperations(String s) {

        int n = s.length();

        int startingWith0 = 0;
        int startingWith1 = 0;

        for(int i=0; i<n; i++){
            if((i%2==0 && s.charAt(i) == '1') || (i%2==1 && s.charAt(i) == '0')){
                startingWith0++;
            }
            if((i%2==0 && s.charAt(i) == '0') || (i%2==1 && s.charAt(i) == '1')){
                startingWith1++;
            }
        }
        return Math.min(startingWith0, startingWith1);
    }
}
