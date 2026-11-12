/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int minDiff(Node root, int k) {
        // code here
        int minDiff = Integer.MAX_VALUE;

                while (root != null) {
                    int diff = Math.abs(root.data - k);
                    minDiff = Math.min(minDiff, diff);

                    if (diff == 0) {
                        return 0;
                    }

                    if (k < root.data) {
                        root = root.left;
                    } else {
                        root = root.right;
                    }
                }

                return minDiff;
    }
}