package LeetCode_Daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
3661. Maximum Walls Destroyed by Robots

There is an endless straight line populated with some robots and walls. You are given integer arrays robots, distance, and walls:
robots[i] is the position of the ith robot.
distance[i] is the maximum distance the ith robot's bullet can travel.
walls[j] is the position of the jth wall.
Every robot has one bullet that can either fire to the left or the right at most distance[i] meters.

A bullet destroys every wall in its path that lies within its range. Robots are fixed obstacles: if a bullet hits another robot before reaching a wall, it immediately stops at that robot and cannot continue.

Return the maximum number of unique walls that can be destroyed by the robots.

Notes:

A wall and a robot may share the same position; the wall can be destroyed by the robot at that position.
Robots are not destroyed by bullets.
 

Example 1:

Input: robots = [4], distance = [3], walls = [1,10]

Output: 1

Explanation:

robots[0] = 4 fires left with distance[0] = 3, covering [1, 4] and destroys walls[0] = 1.
Thus, the answer is 1.
Example 2:

Input: robots = [10,2], distance = [5,1], walls = [5,2,7]

Output: 3

Explanation:

robots[0] = 10 fires left with distance[0] = 5, covering [5, 10] and destroys walls[0] = 5 and walls[2] = 7.
robots[1] = 2 fires left with distance[1] = 1, covering [1, 2] and destroys walls[1] = 2.
Thus, the answer is 3.
Example 3:
Input: robots = [1,2], distance = [100,1], walls = [10]

Output: 0

Explanation:

In this example, only robots[0] can reach the wall, but its shot to the right is blocked by robots[1]; thus the answer is 0.

 

Constraints:

1 <= robots.length == distance.length <= 105
1 <= walls.length <= 105
1 <= robots[i], walls[j] <= 109
1 <= distance[i] <= 105
All values in robots are unique
All values in walls are unique
*/
public class Hard_3661 {
    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] num = new int[n];
        Map<Integer, Integer> robotsToDistance = new HashMap<>();

        for (int i = 0; i < n; i++) {
            robotsToDistance.put(robots[i], distance[i]);
        }

        Arrays.sort(robots);
        Arrays.sort(walls);

        for (int i = 0; i < n; i++) {
            int pos1 = upperBound(walls, robots[i]);

            int leftPos = 0;
            if (i >= 1) {
                int leftBound = Math.max(
                    robots[i] - robotsToDistance.get(robots[i]),
                    robots[i - 1] + 1
                );
                leftPos = lowerBound(walls, leftBound);
            } else {
                leftPos = lowerBound(
                    walls,
                    robots[i] - robotsToDistance.get(robots[i])
                );
            }
            left[i] = pos1 - leftPos;

            int rightPos = 0;
            if (i < n - 1) {
                int rightBound = Math.min(
                    robots[i] + robotsToDistance.get(robots[i]),
                    robots[i + 1] - 1
                );
                rightPos = upperBound(walls, rightBound);
            } else {
                rightPos = upperBound(
                    walls,
                    robots[i] + robotsToDistance.get(robots[i])
                );
            }
            int pos2 = lowerBound(walls, robots[i]);
            right[i] = rightPos - pos2;

            if (i == 0) {
                continue;
            }
            int pos3 = lowerBound(walls, robots[i - 1]);
            num[i] = pos1 - pos3;
        }

        int subLeft = left[0];
        int subRight = right[0];
        for (int i = 1; i < n; i++) {
            int currentLeft = Math.max(
                subLeft + left[i],
                subRight -
                right[i - 1] +
                Math.min(left[i] + right[i - 1], num[i])
            );
            int currentRight = Math.max(
                subLeft + right[i],
                subRight + right[i]
            );
            subLeft = currentLeft;
            subRight = currentRight;
        }

        return Math.max(subLeft, subRight);
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
