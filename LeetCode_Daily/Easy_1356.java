package LeetCode_Daily;

import java.util.PriorityQueue;

/*
1356. Sort Integers by The Number of 1 Bits

You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.

 

Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]
Example 2:

Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
 

Constraints:

1 <= arr.length <= 500
0 <= arr[i] <= 104
 */
public class Easy_1356 {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; 
                return a[1] - b[1];
            }
        );

        for(int i=0;i<arr.length;i++){
            int num = count_bits(arr[i]);
            pq.offer(new int[]{num, arr[i]});
        }

        int index = 0;
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll()[1]; 
        }

        return arr;
    }

    public int count_bits(int n){
        int ans = 0;
        while(n>0){
            ans++;
            n = (n&(n-1));
        }
        return ans;
    }
}
