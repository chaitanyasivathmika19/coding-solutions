class Solution {
    public int getMinimumDays(String s, int[] p) {
        // code here
        int n = s.length();

        // Check whether the original string is already valid
        boolean valid = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                valid = false;
                break;
            }
        }

        if (valid) {
            return 0;
        }

        int left = 1;
        int right = n;
        int answer = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(s, p, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean isValid(String s, int[] p, int days) {
        int n = s.length();
        boolean[] replaced = new boolean[n];

        // Mark the positions replaced during these days
        for (int i = 0; i < days; i++) {
            replaced[p[i]] = true;
        }

        // Check adjacent characters
        for (int i = 0; i < n - 1; i++) {
            if (!replaced[i] && !replaced[i + 1]
                    && s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }

        return true;
        
    }
}