class Solution {
    public int numOfSubarrays(int[] arr) {
                int MOD = 1_000_000_007;

        long odd = 0;
        long even = 1;
        long count = 0;
        int prefix = 0;

        for (int num : arr) {
            prefix += num;
            prefix %= 2;

            if (prefix == 1) {
                count = (count + even) % MOD;
                odd++;
            } else {
                count = (count + odd) % MOD;
                even++;
            }
        }

        return (int) count;
    }
}