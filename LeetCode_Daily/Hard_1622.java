package LeetCode_Daily;

import java.util.ArrayList;

/*
1622. Fancy Sequence

Write an API that generates fancy sequences using the append, addAll, and multAll operations.

Implement the Fancy class:

Fancy() Initializes the object with an empty sequence.
void append(val) Appends an integer val to the end of the sequence.
void addAll(inc) Increments all existing values in the sequence by an integer inc.
void multAll(m) Multiplies all existing values in the sequence by an integer m.
int getIndex(idx) Gets the current value at index idx (0-indexed) of the sequence modulo 109 + 7. If the index is greater or equal than the length of the sequence, return -1.
 

Example 1:

Input
["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "append", "multAll", "getIndex", "getIndex", "getIndex"]
[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
Output
[null, null, null, null, null, 10, null, null, null, 26, 34, 20]

Explanation
Fancy fancy = new Fancy();
fancy.append(2);   // fancy sequence: [2]
fancy.addAll(3);   // fancy sequence: [2+3] -> [5]
fancy.append(7);   // fancy sequence: [5, 7]
fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -> [10, 14]
fancy.getIndex(0); // return 10
fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -> [13, 17]
fancy.append(10);  // fancy sequence: [13, 17, 10]
fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -> [26, 34, 20]
fancy.getIndex(0); // return 26
fancy.getIndex(1); // return 34
fancy.getIndex(2); // return 20
 

Constraints:

1 <= val, inc, m <= 100
0 <= idx <= 105
At most 105 calls total will be made to append, addAll, multAll, and getIndex.
*/
public class Hard_1622 {
    private static final int MOD = 1000000007;
    private ArrayList<Long> val;  
    private long a, b;   

    public Fancy() {
        val = new ArrayList<>(); 
        a = 1;
        b = 0;
    }

    private long modPow(long x, long y, long mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % mod;
            }
            y = y / 2;
            x = (x * x) % mod;
        }
        return res;
    }

    public void append(int val) {
        long x = (val - b + MOD) % MOD;
        this.val.add((x * modPow(a, MOD - 2, MOD)) % MOD);  
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }

    public void multAll(int m) {
        a = (a * m) % MOD;
        b = (b * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= val.size()) return -1; 
        return (int)((a * val.get(idx) + b) % MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
