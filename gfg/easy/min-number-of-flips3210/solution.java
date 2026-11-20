class Solution {
    public int minFlips(String s) {
        // code here
        int flips1 = 0; // Pattern: 010101...
        int flips2 = 0; // Pattern: 101010...

        for (int i = 0; i < s.length(); i++) {
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expected1) {
                flips1++;
            }

            if (s.charAt(i) != expected2) {
                flips2++;
            }
        }

        return Math.min(flips1, flips2);
    }
}