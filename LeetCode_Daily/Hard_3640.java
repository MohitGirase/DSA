package LeetCode_Daily;

/*
3640. Trionic Array II

You are given an integer array nums of length n.

A trionic subarray is a contiguous subarray nums[l...r] (with 0 <= l < r < n) for which there exist indices l < p < q < r such that:

nums[l...p] is strictly increasing,
nums[p...q] is strictly decreasing,
nums[q...r] is strictly increasing.
Return the maximum sum of any trionic subarray in nums.

 

Example 1:

Input: nums = [0,-2,-1,-3,0,2,-1]

Output: -4

Explanation:

Pick l = 1, p = 2, q = 3, r = 5:

nums[l...p] = nums[1...2] = [-2, -1] is strictly increasing (-2 < -1).
nums[p...q] = nums[2...3] = [-1, -3] is strictly decreasing (-1 > -3)
nums[q...r] = nums[3...5] = [-3, 0, 2] is strictly increasing (-3 < 0 < 2).
Sum = (-2) + (-1) + (-3) + 0 + 2 = -4.
Example 2:

Input: nums = [1,4,2,7]

Output: 14

Explanation:

Pick l = 0, p = 1, q = 2, r = 3:

nums[l...p] = nums[0...1] = [1, 4] is strictly increasing (1 < 4).
nums[p...q] = nums[1...2] = [4, 2] is strictly decreasing (4 > 2).
nums[q...r] = nums[2...3] = [2, 7] is strictly increasing (2 < 7).
Sum = 1 + 4 + 2 + 7 = 14.
 

Constraints:

4 <= n = nums.length <= 105
-109 <= nums[i] <= 109
It is guaranteed that at least one trionic subarray exists.
 */
public class Hard_3640 {
    public long maxSumTrionic(int[] nums) {
        
        int n = nums.length;
        long res= -1 * (long)1e16;

        for(int i=1;i<n-2;i++){

            int a = i; 
            int b = i; 

            long net = nums[a];

            while(b+1<n && nums[b+1] < nums[b]){
                net+=(long)nums[b+1];
                b++;
            }

            if(b==a)continue;

            int c= b; 

            long left = 0;
            long right = 0;

            long lx =Integer.MIN_VALUE;
            long rx =Integer.MIN_VALUE;

            while(a-1>=0 && nums[a-1] < nums[a]){
                left+=(long)nums[a-1];
                lx = Math.max(lx, left);
                a--;
            }

            if(a==i)continue;

            while(b+1<n && nums[b+1] > nums[b]){
                right+=(long)nums[b+1];
                rx = Math.max(rx, right);
                b++;
            }

            if(b==c)continue;
            i=b-1;
            res = Math.max( res, lx+rx+net);

        }
        return res;
    }
}
