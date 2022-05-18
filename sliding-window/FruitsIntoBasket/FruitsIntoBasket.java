import java.util.HashMap;
import java.util.Map;

// Q) Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
// Write a function to return the maximum number of fruits in both the baskets.

public class FruitsIntoBasket {
    public static void main(String[] args) {
        Character[] fruits = { 'A', 'B', 'C', 'B', 'B', 'C' };
        System.out.println(solution(fruits));
        System.out.println(solution(fruits));
    }

    private static int solution(Character[] fruits) {
        int n = fruits.length;
        int start = 0;
        int end = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            char c = fruits[end];
            map.put(c, map.getOrDefault(c, 0) + 1);
            end++;
            while (map.size() > 2) {
                char startChar = fruits[start];
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
