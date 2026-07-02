class Solution {
    // Function to calculate how many days are needed to ship
    // all packages with the given ship capacity
    int daysNeeded(int[] weights, int capacity) {
        // Initialize count of days to 1
        int days = 1;
        // Initialize current load on ship to 0
        int currentLoad = 0;

        // Iterate over all package weights
        for (int w : weights) {
            // Check if adding current package exceeds capacity
            if (currentLoad + w > capacity) {
                // If yes, increase days count since we start a new day
                days++;
                // Reset current load to current package weight
                currentLoad = w;
            } else {
                // Else, add current package weight to current load
                currentLoad += w;
            }
        }
        // Return total days required
        return days;
    }

    // Function to find minimum ship capacity to ship all packages within d days
    int shipWithinDays(int[] weights, int d) {
        // Calculate minimum capacity as max weight in packages
        int left = Arrays.stream(weights).max().getAsInt();
        // Calculate maximum capacity as sum of all weights
        int right = Arrays.stream(weights).sum();

        // Binary search between left and right capacity values
        while (left < right) {
            // Calculate mid value to test
            int mid = left + (right - left) / 2;
            // Calculate how many days needed for capacity mid
            int needed = daysNeeded(weights, mid);

            // If days needed is less or equal to allowed days,
            // try to find smaller capacity on left side
            if (needed <= d) {
                right = mid;
            } else {
                // Else, need more capacity, search on right side
                left = mid + 1;
            }
        }
        // Return minimum capacity found
        return left;
    }
}