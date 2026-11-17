class Solution {
    public int minimumChanges(String s, int k) {
                int n = s.length();

        // cost[i][j] = minimum changes to make s[i...j]
        // a semi-palindrome
        int[][] cost = new int[n][n];

        // Step 1: Precompute costs for every substring
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                int minCost = n;

                for (int d = 1; d < len; d++) {
                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;

                    // Compare mirrored characters in each group
                    for (int offset = 0; offset < d; offset++) {
                        int left = i + offset;
                        int right = j - d + 1 + offset;

                        while (left < right) {
                            if (s.charAt(left) != s.charAt(right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    minCost = Math.min(minCost, changes);
                }

                cost[i][j] = minCost;
            }
        }

        // Step 2: DP over prefixes and number of substrings
        // dp[i][parts] = minimum changes for first i characters
        // divided into exactly 'parts' semi-palindromes
        int INF = 1_000_000;
        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 2; i <= n; i++) {
            for (int parts = 1; parts <= k; parts++) {

                // Last substring is s[start ... i-1]
                // Every substring must have length >= 2
                for (int start = (parts - 1) * 2;
                     start <= i - 2; start++) {

                    if (dp[start][parts - 1] == INF) {
                        continue;
                    }

                    dp[i][parts] = Math.min(
                        dp[i][parts],
                        dp[start][parts - 1] + cost[start][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}