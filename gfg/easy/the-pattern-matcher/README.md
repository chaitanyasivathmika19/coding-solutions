# Repeated Pattern Check

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a string  **s**  made of two characters of  **'x'** and  **'y'**.  The task is to verify whether  **s**  is made by concatenating substrings that follow the pattern  **xnyn**   (equal number of y' *s*  follow equal number of x' *s)*. 

 **Examples:** 

```
Input: s = "xxyyxy" 
Output: true
Explanation: The string can be split into "xxyy" + "xy". Both substrings contain an equal number of consecutive 'x' and 'y' characters.
```

```
Input: s = "xyx"
Output: false
Explanation: The last 'x' cannot form a valid substring because it is not followed by a matching 'y'. 
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-17T12:33:57.104Z  

```java
class Solution {
    public boolean findPattern(String s) {
        // code here
        int i = 0;
          int n = s.length();

          while (i < n) {
              if (s.charAt(i) != 'x') {
                  return false;
              }

              int xCount = 0;
              while (i < n && s.charAt(i) == 'x') {
                  xCount++;
                  i++;
              }

              int yCount = 0;
              while (i < n && s.charAt(i) == 'y') {
                  yCount++;
                  i++;
              }

              if (xCount != yCount) {
                  return false;
              }
          }

          return true;
    }
}

```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/the-pattern-matcher/1)