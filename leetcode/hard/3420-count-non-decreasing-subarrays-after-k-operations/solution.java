class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
                int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;
        int right = n - 1;

        for (int left = n - 1; left >= 0; left--) {

            // Merge smaller values that must be increased
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] < nums[left]) {

                int index = deque.pollLast();

                int end = deque.isEmpty()
                        ? right + 1
                        : deque.peekLast();

                cost += (long) (end - index)
                        * (nums[left] - nums[index]);
            }

            deque.offerLast(left);

            // Shrink the window until cost <= k
            while (cost > k) {
                cost -= nums[deque.peekFirst()] - nums[right];

                if (deque.peekFirst() == right) {
                    deque.pollFirst();
                }

                right--;
            }

            // Count valid subarrays starting at left
            ans += right - left + 1;
        }

        return ans;
    }
}