class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
 int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        // Available servers: [weight, index]
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Busy servers: [freeTime, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }

        long time = 0;
        int task = 0;

        while (task < m) {
            time = Math.max(time, task);

            // Release all servers that have finished
            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();
                available.offer(new int[]{(int) s[1], (int) s[2]});
            }

            if (available.isEmpty()) {
                // Wait until the earliest server becomes free
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();
                    available.offer(new int[]{(int) s[1], (int) s[2]});
                }
            }

            // Assign the next task
            int[] server = available.poll();
            ans[task] = server[1];

            busy.offer(new long[]{
                time + tasks[task],
                server[0],
                server[1]
            });

            task++;
        }

        return ans;
    }
}