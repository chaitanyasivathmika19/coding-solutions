class Solution {
    public int countBT(int h) {
        // code here
        long mod = 1000000007;

                if (h == 0) {
                    return 1;
                }

                long prev2 = 1; // Trees of height 0
                long prev1 = 1; // Trees of height 1

                for (int i = 2; i <= h; i++) {
                    long curr = (prev1 * prev1) % mod;
                    curr = (curr + (2 * prev1 % mod) * prev2) % mod;

                    prev2 = prev1;
                    prev1 = curr;
                }

                return (int) prev1;
    }
}
