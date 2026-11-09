class Solution {
    int getCount(String s, int k) {
        // code here
        int[] groups = new int[26];
        int n = s.length();

        // Count each character's consecutive groups
        for (int i = 0; i < n; i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                groups[s.charAt(i) - 'a']++;
            }
        }

        // Count distinct characters appearing in exactly k groups
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (groups[i] == k) {
                count++;
            }
        }

        return count;
        
    }
}