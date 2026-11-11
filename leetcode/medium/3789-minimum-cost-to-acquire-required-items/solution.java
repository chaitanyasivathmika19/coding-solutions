class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // Option 1: Buy each type separately
        long separateCost = (long) cost1 * need1
                          + (long) cost2 * need2;

        // Option 2: Buy items that satisfy both requirements
        int both = Math.min(need1, need2);

        long bothCost = (long) both * costBoth
                      + (long) (need1 - both) * cost1
                      + (long) (need2 - both) * cost2;

        // Option 3: Use type 3 items for the larger requirement,
        // even if some contribution exceeds the smaller requirement
        int maxNeed = Math.max(need1, need2);

        long allBothCost = (long) maxNeed * costBoth;

        return Math.min(separateCost, Math.min(bothCost, allBothCost));
    }
}