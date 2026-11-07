class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        // code here
    ArrayList<String> result = new ArrayList<>();

    // All input usernames are initially reserved
    Set<String> used = new HashSet<>();
    for (String name : arr) {
        used.add(name);
    }

    // Track the next suffix to try for each username
    Map<String, Integer> nextSuffix = new HashMap<>();

    for (String name : arr) {
        if (!used.contains(name)) {
            used.add(name);
            result.add(name);
        } else {
            // Check whether this original name was already assigned
            boolean alreadyAssigned = false;

            for (String previous : result) {
                if (previous.equals(name)) {
                    alreadyAssigned = true;
                    break;
                }
            }

            if (!alreadyAssigned) {
                result.add(name);
                continue;
            }

            int suffix = nextSuffix.getOrDefault(name, 1);
            String candidate = name + suffix;

            while (used.contains(candidate)) {
                suffix++;
                candidate = name + suffix;
            }

            result.add(candidate);
            used.add(candidate);
            nextSuffix.put(name, suffix + 1);
        }
    }

    return result;
    }
}