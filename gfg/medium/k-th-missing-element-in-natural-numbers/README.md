# K-th Missing in Natural Numbers

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]**  of distinct positive integers and a positive integer  **k**. Consider an infinite sequence of natural numbers starting from 1. The task is to remove all elements present in arr[] from this sequence.

Find the k-th smallest number in the remaining sequence.

 **Note:**  Your solution must run in O(1) auxiliary space.

 **Examples:** 

```
Input: arr[] = [1, 9, 5, 2], k = 6
Output: 10
Explanation: After removing [1, 2, 5, 9] from the natural numbers, the remaining sequence is: 3, 4, 6, 7, 8, 10, 11,.... and so on. The 6th number in this sequence is 10, so the answer is 10.
```

```
Input: arr[] = [1, 2, 3, 4], k = 1
Output: 5
Explanation: After removing [1, 2, 3, 4] from the natural numbers, the remaining sequence is: 5, 6, 7,.... and so on. The 1st number in the sequence is 5, so the answer is 5.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-16T10:48:50.091Z  

```java
class Solution {
    public int findKthSmall(int[] arr, int k) {
        // code here
        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] + k;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int index = Arrays.binarySearch(arr, mid);
            int countLessOrEqual;

            if (index >= 0) {
                countLessOrEqual = index + 1;

                // Handle duplicates in sorted array (though input is distinct)
                while (countLessOrEqual < arr.length
                        && arr[countLessOrEqual] == mid) {
                    countLessOrEqual++;
                }
            } else {
                countLessOrEqual = -index - 1;
            }

            int missing = mid - countLessOrEqual;

            if (missing >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/k-th-missing-element-in-natural-numbers/1)