# Number of Sub-arrays With Odd Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `arr`, return  *the number of subarrays with an  **odd**  sum*.

Since the answer can be very large, return it modulo `109 + 7`.

 

Original
Java
 **Example 1:** 

```
Input: arr = [1,3,5]
Output: 4
Explanation: All subarrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

```

 **Example 2:** 

```
Input: arr = [2,4,6]
Output: 0
Explanation: All subarrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0.

```

 **Example 3:** 

```
Input: arr = [1,2,3,4,5,6,7]
Output: 16

```

 

 **Constraints:** 

- 1 <= arr.length <= 105
- 1 <= arr[i] <= 100

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 44.50%)  
**Memory:** 81.1 MB (beats 94.09%)  
**Submitted:** 2026-11-15T17:08:42.910Z  

```java
class Solution {
    public int numOfSubarrays(int[] arr) {
                int MOD = 1_000_000_007;

        long odd = 0;
        long even = 1;
        long count = 0;
        int prefix = 0;

        for (int num : arr) {
            prefix += num;
            prefix %= 2;

            if (prefix == 1) {
                count = (count + even) % MOD;
                odd++;
            } else {
                count = (count + odd) % MOD;
                even++;
            }
        }

        return (int) count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/)