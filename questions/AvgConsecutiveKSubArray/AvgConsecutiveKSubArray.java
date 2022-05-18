import java.util.ArrayList;

// q) Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

public class AvgConsecutiveKSubArray {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
        int k = 5;
        System.out.println(avgConsecutiveKSubArray(arr, k));
    }

    public static ArrayList<Float> avgConsecutiveKSubArray(int[] arr, int k) {
        ArrayList<Float> result = new ArrayList<>();
        float sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            count++;
            if (count == k) {
                result.add(sum / k);
                sum = sum - arr[i - k + 1];
                count--;
            }
        }

        return result;
    }

    public static ArrayList<Float> avgConsecutiveKSubArrayDoubleLoop(int[] arr, int k) {
        ArrayList<Float> result = new ArrayList<>();
        for (int i = 0; i <= arr.length - k; i++) {
            float sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            result.add(sum / k);
        }

        return result;
    }
}
