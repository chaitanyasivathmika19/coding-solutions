# Generate Usernames

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array of strings  **arr[].** The array represents first names of users, generate a unique username for each entry in the order it appears.

- Initially, consider all usernames present in the input array as reserved.
- If a username has not already been assigned to any previous user, keep it unchanged.
- Otherwise, append the smallest positive integer suffix that produces a username that has not been reserved or assigned to any previous user.

Return the array of generated usernames.

 **Examples:** 

```
Input: arr[] = ["aba", "ab", "aba", "aba", "ab"]
Output: ["aba", "ab", "aba1", "aba2", "ab1"]
Explanation: The first occurrences of "aba" and "ab" are new, so they remain unchanged. The next "aba" is already used, so "aba1" is assigned. When "aba" appears again, "aba1" is already used, so "aba2" is assigned. Similarly, the second occurrence of "ab" becomes "ab1".
```

```
Input: arr[] = ["a", "a", "a1", "a"]
Output: ["a", "a2", "a1", "a3"]
Explanation: Initially, "a" and "a1" are reserved. The first occurrence of "a" retains its name. For the second occurrence, "a1" is already reserved, so the smallest available username is "a2". The original "a1" retains its name when processed. Finally, the last occurrence of "a" gets "a3".
```

```
Input: arr[] = ["aba1", "aba", "aba"]
Output: ["aba1", "aba", "aba2"]
Explanation: Initially, "aba1" and "aba" are reserved. The first occurrence of each retains its original name. For the second occurrence of "aba", "aba1" is already reserved, so "aba2" is assigned.
```

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-07T05:01:20.325Z  

```java
class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        // code here
    ArrayList<String> result = new ArrayList<>();

    // All input usernames are initially reserved
    Set<String> used = new HashSet<>();
    for (String name : arr) {
        used.add(name);
    }

    // Track the next suffix to try for each username
    Map<String, Integer> nextSuffix = new HashMap<>();

    for (String name : arr) {
        if (!used.contains(name)) {
            used.add(name);
            result.add(name);
        } else {
            // Check whether this original name was already assigned
            boolean alreadyAssigned = false;

            for (String previous : result) {
                if (previous.equals(name)) {
                    alreadyAssigned = true;
                    break;
                }
            }

            if (!alreadyAssigned) {
                result.add(name);
                continue;
            }

            int suffix = nextSuffix.getOrDefault(name, 1);
            String candidate = name + suffix;

            while (used.contains(candidate)) {
                suffix++;
                candidate = name + suffix;
            }

            result.add(candidate);
            used.add(candidate);
            nextSuffix.put(name, suffix + 1);
        }
    }

    return result;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/new-registration-system--150419/1)