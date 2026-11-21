# Find Subtree Sizes After Changes

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a tree rooted at node 0 that consists of `n` nodes numbered from `0` to `n - 1`. The tree is represented by an array `parent` of size `n`, where `parent[i]` is the parent of node `i`. Since node 0 is the root, `parent[0] == -1`.

You are also given a string `s` of length `n`, where `s[i]` is the character assigned to node `i`.

We make the following changes on the tree  **one**  time  **simultaneously**  for all nodes `x` from `1` to `n - 1`:

- Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
- If node y does not exist, do nothing.
- Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an edge between them.

Return an array `answer` of size `n` where `answer[i]` is the  **size**  of the subtree rooted at node `i` in the  **final**  tree.

 

Original
Java
 **Example 1:** 

 **Input:**  parent = [-1,0,0,1,1,1], s = "abaabc"

 **Output:**  [6,3,1,1,1,1]

 **Explanation:** 

The parent of node 3 will change from node 1 to node 0.

 **Example 2:** 

 **Input:**  parent = [-1,0,4,0,1], s = "abbba"

 **Output:**  [5,2,1,1,1]

 **Explanation:** 

The following changes will happen at the same time:

- The parent of node 4 will change from node 1 to node 0.
- The parent of node 2 will change from node 4 to node 1.

 

 **Constraints:** 

- n == parent.length == s.length
- 1 <= n <= 105
- 0 <= parent[i] <= n - 1 for all i >= 1.
- parent[0] == -1
- parent represents a valid tree.
- s consists only of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 203 ms (beats 39.53%)  
**Memory:** 274.1 MB (beats 60.46%)  
**Submitted:** 2026-11-21T15:44:52.660Z  

```java
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
                int n = parent.length;

        // Build the original tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        // Find the new parent of every node
        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] previous = new int[n];
        int[] order = new int[n];
        int count = 0;

        // Iterative DFS with enter/exit states
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});

        while (!stack.isEmpty()) {
            int[] item = stack.pop();
            int node = item[0];
            int state = item[1];
            int c = s.charAt(node) - 'a';

            if (state == 0) {
                previous[node] = last[c];

                if (node != 0 && last[c] != -1) {
                    newParent[node] = last[c];
                }

                last[c] = node;
                stack.push(new int[]{node, 1});

                List<Integer> children = tree.get(node);
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(new int[]{children.get(i), 0});
                }
            } else {
                last[c] = previous[node];
                order[count++] = node;
            }
        }

        // Build the modified tree
        List<List<Integer>> newTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            newTree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            newTree.get(newParent[i]).add(i);
        }

        // Calculate subtree sizes in postorder
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        for (int i = 0; i < n; i++) {
            int node = order[i];
            if (newParent[node] != -1) {
                answer[newParent[node]] += answer[node];
            }
        }

        return answer;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-subtree-sizes-after-changes/)