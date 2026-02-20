package LeetCode_daily;

import java.util.PriorityQueue;

/*
761. Special Binary String

Special binary strings are binary strings with the following two properties:

The number of 0's is equal to the number of 1's.
Every prefix of the binary string has at least as many 1's as 0's.
You are given a special binary string s.

A move consists of choosing two consecutive, non-empty, special substrings of s, and swapping them. Two strings are consecutive if the last character of the first string is exactly one index before the first character of the second string.

Return the lexicographically largest resulting string possible after applying the mentioned operations on the string.

 

Example 1:

Input: s = "11011000"
Output: "11100100"
Explanation: The strings "10" [occuring at s[1]] and "1100" [at s[3]] are swapped.
This is the lexicographically largest string possible after some number of swaps.
Example 2:

Input: s = "10"
Output: "10"
 

Constraints:

1 <= s.length <= 50
s[i] is either '0' or '1'.
s is a special binary string.
 */
public class Hard_761 {
    public String makeLargestSpecial(String S) {
        if(S == null || S.length() == 0 || S.length() == 2) return S;
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
        int acc = 1, prev = 0;
        for(int i = 1; i <= S.length(); i++) {
            if(acc == 0) {
                if(!(prev == 0 && i == S.length())) pq.add(makeLargestSpecial(S.substring(prev, i)));
                prev = i;
            }
            if(i == S.length()) break;
            if(S.charAt(i) == '1') {
                acc++;
            }
            else {
                acc--;
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            ans.append(pq.poll());
        }
        if(ans.length() == 0) {
            ans.append('1');
            ans.append(makeLargestSpecial(S.substring(1, S.length() - 1)));
            ans.append('0');
        }
        return ans.toString();
    }
}
