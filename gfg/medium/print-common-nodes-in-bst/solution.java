/* Structure of a Binary Search Tree node
class Node {
  public int data;
  public Node left;
  public Node right;

  public Node(int val) {
      data = val;
      left = right = null;
  }
};
*/


import java.util.*;

class Solution {
    public ArrayList<Integer> findCommon(Node r1, Node r2) {
        ArrayList<Integer> result = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (r1 != null || r2 != null || !s1.isEmpty() || !s2.isEmpty()) {

            // Get the next smallest value from BST 1
            while (r1 != null) {
                s1.push(r1);
                r1 = r1.left;
            }

            // Get the next smallest value from BST 2
            while (r2 != null) {
                s2.push(r2);
                r2 = r2.left;
            }

            if (s1.isEmpty() || s2.isEmpty()) {
                break;
            }

            Node n1 = s1.peek();
            Node n2 = s2.peek();

            if (n1.data == n2.data) {
                result.add(n1.data);
                s1.pop();
                s2.pop();

                r1 = n1.right;
                r2 = n2.right;
            } else if (n1.data < n2.data) {
                s1.pop();
                r1 = n1.right;
            } else {
                s2.pop();
                r2 = n2.right;
            }
        }

        return result;
    }
}