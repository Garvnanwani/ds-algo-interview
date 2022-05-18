import java.util.HashMap;
import java.util.Map;

// Q) Given a string and a pattern, find out if the string contains any permutation of the pattern.

public class PermutationInAString {
    public static void main(String[] args) {
        String s = "abababab";
        String p = "ababab";
        System.out.println(checkPermutation(s, p));
    }

    private static boolean checkPermutation(String s, String p) {
        int start = 0;
        int matched = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                    matched++;
                }
            }
            if (matched == map.size()) {
                return true;
            }

            if (end >= p.length() - 1) {
                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) == 1) {
                        map.remove(startChar);
                        matched--;
                    }
                }
                start++;
            }
        }
        return false;
    }
}
