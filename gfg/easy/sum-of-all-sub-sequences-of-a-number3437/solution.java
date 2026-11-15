class Solution {
    public int subsequenceSum(String s) {
        // code here
        long MOD = 1_000_000_007;
        long sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        long ways = 1;
        for (int i = 1; i < s.length(); i++) {
            ways = (ways * 2) % MOD;
        }

        return (int) ((sum % MOD * ways) % MOD);
    }
}