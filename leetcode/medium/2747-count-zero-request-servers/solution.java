class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
                int m = queries.length;
        int[] answer = new int[m];

        // Store each query with its original index
        int[][] sortedQueries = new int[m][2];

        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Sort queries by query time
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < m; i++) {
            int q = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];

            // Add logs whose time is <= q
            while (right < logs.length && logs[right][1] <= q) {
                int server = logs[right][0];
                freq.put(server, freq.getOrDefault(server, 0) + 1);
                right++;
            }

            // Remove logs whose time is < q - x
            while (left < right && logs[left][1] < q - x) {
                int server = logs[left][0];

                freq.put(server, freq.get(server) - 1);

                if (freq.get(server) == 0) {
                    freq.remove(server);
                }

                left++;
            }

            answer[originalIndex] = n - freq.size();
        }

        return answer;
    }
}