// Q) Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

public class LongestSubarrayWithOnesAfterReplacement {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 0, 0, 1, 1, 1 };
        int k = 2;
        System.out.println(longestSubstring(arr, k));
    }

    public static int longestSubstring(int[] arr, int k) {
        int start = 0;
        int end = 0;

        int maxLength = 0;
        int maxOnesCount = 0;

        while (end < arr.length) {
            if (arr[end] == 1) {
                maxOnesCount++;
            }

            if (end - start + 1 - maxOnesCount > k) {
                if (arr[start] == 1) {
                    maxOnesCount--;
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }

        return maxLength;
    }
}
