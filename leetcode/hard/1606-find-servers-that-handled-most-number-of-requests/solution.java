class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
                TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        int maxRequests = 0;

        for (int i = 0; i < arrival.length; i++) {

            // Release servers that have finished their requests
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int[] server = busy.poll();
                available.add(server[1]);
            }

            // Drop the request if every server is busy
            if (available.isEmpty()) {
                continue;
            }

            // Prefer server i % k, otherwise wrap around
            int preferred = i % k;
            Integer server = available.ceiling(preferred);

            if (server == null) {
                server = available.first();
            }

            available.remove(server);

            // Count this successfully handled request
            count[server]++;
            maxRequests = Math.max(maxRequests, count[server]);

            // Store [completion time, server ID]
            busy.offer(new int[]{arrival[i] + load[i], server});
        }

        // Collect all busiest servers
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == maxRequests) {
                result.add(i);
            }
        }

        return result;
    }
}