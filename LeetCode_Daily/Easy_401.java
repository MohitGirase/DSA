package LeetCode_Daily;

import java.util.ArrayList;
import java.util.List;

/*
401. Binary Watch

A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

For example, the below binary watch reads "4:51".


Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

For example, "01:00" is not valid. It should be "1:00".
The minute must consist of two digits and may contain a leading zero.

For example, "10:2" is not valid. It should be "10:02".
 

Example 1:

Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
Example 2:

Input: turnedOn = 9
Output: []
 

Constraints:

0 <= turnedOn <= 10
 */
public class Easy_401 {
    public List<String> readBinaryWatch(int k) {
        if (k == 0) return List.of("0:00");
        int mask = (1 << 6) - 1;
        int q = (1 << k) - 1;
        int limit = q << (10 - k);
        List<String> res = new ArrayList<>();

        while (q <= limit) {
            int min = q & mask;
            int hour = q >> 6;
            if (hour < 12 && min < 60)
                res.add(hour + ":" + (min < 10 ? "0" : "") + min);
            int r = q & -q;
            int n = q + r;
            q = (((q ^ n) / r) >> 2) | n;
        }
        return res;
    }
}
