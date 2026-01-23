package LeetCode_Daily;

import java.util.TreeSet;

/*
3510. Minimum Pair Removal to Sort Array II

Given an array nums, you can perform the following operation any number of times:

Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
Replace the pair with their sum.
Return the minimum number of operations needed to make the array non-decreasing.

An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).

 

Example 1:

Input: nums = [5,2,3,1]

Output: 2

Explanation:

The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
The array nums became non-decreasing in two operations.

Example 2:

Input: nums = [1,2,2]

Output: 0

Explanation:

The array nums is already sorted.

 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
public class Hard_3510 {
    class Node implements Comparable<Node> {
        int idx;
        long val;
        long sum;
        Node prev;
        Node next;

        public Node(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node other) {
            if (this.next == null || other.next == null) {
                return this.next == null ? 1 : -1;
            }
            long diff = this.sum - other.sum;
            return diff != 0 ? (diff < 0 ? -1 : 1)
                             : (this.idx - other.idx);  
        }
    }

    public int minimumPairRemoval(int[] nums) {
        TreeSet<Node> set = new TreeSet<>();
        int des = 0;
        int len = nums.length;
        Node iter = null;
        for (int i = 0; i < len; i++) {
            Node cur = new Node(i, nums[i]);
            if (iter == null) {
                iter = cur;
            } else {
                if (cur.val < iter.val) des++;
                iter.next = cur;
                cur.prev = iter;
                iter.sum = iter.val + cur.val;
                set.add(iter);
                iter = cur;
            }
        }
        set.add(iter);

        int res = 0;
        while (des > 0) {
            res++;
            Node smallSum = set.pollFirst();
            Node remove = smallSum.next;
            if (remove.val < smallSum.val) des--;
            smallSum.sum = smallSum.val + remove.sum;
            smallSum.val = smallSum.val + remove.val;
            smallSum.next = remove.next;

            if (remove.next != null) {
                if (remove.next.val < remove.val) des--;
                remove.next.prev = smallSum;
                if (smallSum.val > smallSum.next.val) des++;
            }
            set.remove(remove);
            set.add(smallSum);

            Node pre = smallSum.prev;
            if (pre != null) {
                set.remove(pre);
                if (pre.val > pre.sum - pre.val) des--;
                if (pre.val > smallSum.val) des++;
                pre.sum = pre.val + smallSum.val;
                pre.next = smallSum;
                set.add(pre);
            }
        }
        return res;
        
    }
}
