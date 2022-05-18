import java.util.HashMap;
import java.util.Map;

// Q) Given a string, find the length of the longest substring which has no repeating characters.

public class NoRepeatSubstring {
    public static void main(String[] args) {
        String str = "aabccbb";
        System.out.println(noRepeatSubstring(str));
    }

    private static int noRepeatSubstring(String str) {
        int start = 0;
        int end = 0;

        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (end < str.length()) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            map.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }

}
