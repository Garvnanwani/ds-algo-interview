public class SmallestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 16, 7, 20, 9, 10, 11, 12, 13, 14, 15, 25 };
        int s = 25;

        System.out.println(smallestSubarrayWithGivenSum(arr, s));
    }

    public static int smallestSubarrayWithGivenSum(int[] arr, int s) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;

        while (j < arr.length) {
            if (sum < s) {
                sum += arr[j];
                j++;
            }

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= arr[i];
                i++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min;

    }
}

// [1,2,3,4,16,7,8,9,10,11,12,13,14,15,6]
