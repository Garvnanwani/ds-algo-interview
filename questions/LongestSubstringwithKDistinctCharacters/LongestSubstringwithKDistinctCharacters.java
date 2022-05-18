import java.util.HashMap;
import java.util.Map;

// Q) given a string, find  the length of longest substring in it with no more than K distinct characters.

public class LongestSubstringwithKDistinctCharacters {
    // we can use two pointers to find the longest substring with k distinct
    // characters.
    // and a hashmap to store the characters and their frequencies.
    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            end++;
            while (map.size() > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }
}
