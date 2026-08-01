import java.util.*;

class Solution {
    public String frequencySort(String s) {

        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Convert map to list
        ArrayList<Map.Entry<Character, Integer>> list =
                new ArrayList<>(map.entrySet());

        // Step 3: Sort by frequency (descending)
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> a,
                               Map.Entry<Character, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        // Step 4: Build answer
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}