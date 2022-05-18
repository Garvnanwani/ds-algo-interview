public class MaximumSumSubArrayK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, -5, 16, 7, 8, 9, 10 };
        int k = 3;
        System.out.println(maxSum(arr, k));
    }

    private static int maxSum(int[] arr, int k) {
        int maxSum = 0;
        int sum = 0;
        int windowSize = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            windowSize++;
            if (windowSize == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[i - k + 1];
                windowSize--;
            }
        }

        return maxSum;
    }
}
