class Solution {
    public int maxSelectedElements(int[] nums) {
                Arrays.sort(nums);

        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 0;

        for (int num : nums) {
            int len1 = dp.getOrDefault(num - 1, 0) + 1;
            int len2 = dp.getOrDefault(num, 0) + 1;

            dp.put(num, Math.max(dp.getOrDefault(num, 0), len1));
            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), len2));

            answer = Math.max(answer,
                    Math.max(dp.get(num), dp.get(num + 1)));
        }

        return answer;
    }
}