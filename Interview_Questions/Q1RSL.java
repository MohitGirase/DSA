package Interview_Questions;

import java.util.*;
/*
Given an input array of numbers, return array containing numbers which are power of 7
[1, 147, 7, 14, 49, 50, 343, 500]

 */
public class Q1RSL {
    public static void main(String[] args){
        int[] nums = {1, 147, 7, 14, 49, 50, 343, 500};
        
        List<Integer> res = powerOf7(nums);
        // res = {1, 7, 49, 343};

        System.out.println(res);
    }
    static List<Integer> powerOf7(int[] nums){
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(isPowerOf7(nums[i])){
                res.add(nums[i]);
            }
        }
        return res;
    }
    static boolean isPowerOf7(int num){
        
        while(num > 1){
            if(num % 7 != 0) return false; 
            num /= 7; 
        }
        return true;
    }
    
}
