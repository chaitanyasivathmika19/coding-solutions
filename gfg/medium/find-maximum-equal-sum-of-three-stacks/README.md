# Max Equal Sum in 3 Stacks

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given three stacks  **s1**,  **s2**, and  **s3**, represented by arrays where the first element of each array represents the top of the corresponding stack.

Find the maximum possible equal sum(sum of all elements) of all three stacks by removing zero or more elements from the top of each stack.

If it is not possible to make the sum of all three stacks equal, return  **0**.

 **Examples:** 

```
Input: s1 = [3, 2, 1, 1, 1], s2 = [4, 3, 2], s3 = [2, 5, 4, 1]
Output: 5
Explanation: Remove 3 from s1, 4 from s2, and 2, 5 from s3. The remaining sums of all three stacks are equal to 5.

```

```
Input: s1 = [4,7], s2 = [10], s3 = [1,2,3]
Output: 0
Explanation: It is not possible to make the sums of all three stacks equal by removing elements from their tops.

```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-14T16:01:47.823Z  

```java
class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {
        // code here
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int x : s1) {
            sum1 += x;
        }

        for (int x : s2) {
            sum2 += x;
        }

        for (int x : s3) {
            sum3 += x;
        }

        int i = 0, j = 0, k = 0;

        while (i < s1.size() && j < s2.size() && k < s3.size()) {

            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(i++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(j++);
            } else {
                sum3 -= s3.get(k++);
            }
        }

        return 0;
        
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-maximum-equal-sum-of-three-stacks/1)