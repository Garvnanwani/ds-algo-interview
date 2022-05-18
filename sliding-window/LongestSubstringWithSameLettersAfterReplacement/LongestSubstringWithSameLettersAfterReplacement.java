import java.util.HashMap;
import java.util.Map;

// Q) Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

public class LongestSubstringWithSameLettersAfterReplacement {
    public static void main(String[] args) {
        String s = "aabccbb";
        int k = 2;
        System.out.println(longestSubstring(s, k));
    }

    private static int longestSubstring(String s, int k) {
        int start = 0;
        int end = 0;

        int maxLength = 0;
        int maxRepeatLetterCount = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(c));

            if (end - start + 1 - maxRepeatLetterCount > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}

// aabccbb, 2
// 5

// s = 0;
// e = 0;
// c = a

// map
// a = 1
// max = 1
