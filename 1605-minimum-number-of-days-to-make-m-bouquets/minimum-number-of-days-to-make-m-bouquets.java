class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // WHY: If the total flowers required (m * k) exceeds the available flowers,
        // it's mathematically impossible. We cast to (long) to prevent integer 
        // overflow because m * k can exceed Integer.MAX_VALUE (e.g., 10^6 * 10^5).
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        // WHY: Initialize the boundaries for binary search. 
        // The earliest possible day is the minimum bloom day, 
        // and the latest is the maximum bloom day.
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // WHY: Find the absolute minimum and maximum days in the given array 
        // to establish our search range (the 'search space').
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int result = -1;

        // WHY: Standard binary search loop to look for the minimum day.
        while (low <= high) {
            // WHY: Calculate the mid-point day while preventing potential integer overflow.
            int mid = low + (high - low) / 2;

            // WHY: Check if it's possible to make 'm' bouquets by day 'mid'.
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                result = mid;     // Record 'mid' as a valid answer.
                high = mid - 1;   // Try to see if we can do it even earlier (smaller number of days).
            } else {
                low = mid + 1;    // If 'mid' days isn't enough, we must wait longer.
            }
        }

        return result;
    }

    // WHY: Helper method to simulate the garden on a specific target 'day'.
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int bDay : bloomDay) {
            // WHY: If the flower's bloom day is <= target day, it has bloomed and can be used.
            if (bDay <= day) {
                flowers++;
                // WHY: Once we collect 'k' adjacent bloomed flowers, we form 1 bouquet.
                if (flowers == k) {
                    bouquets++;
                    flowers = 0; // Reset the counter to start looking for the next bouquet.
                }
            } else {
                // WHY: The problem requires *adjacent* flowers. If a flower hasn't bloomed yet, 
                // it breaks the continuous streak, so we must reset our flower counter to 0.
                flowers = 0; 
            }
        }

        // WHY: Returns true if the total bouquets we could form is at least the required 'm'.
        return bouquets >= m;
    }
}