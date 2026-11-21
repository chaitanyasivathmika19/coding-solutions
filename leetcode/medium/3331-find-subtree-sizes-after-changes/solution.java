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