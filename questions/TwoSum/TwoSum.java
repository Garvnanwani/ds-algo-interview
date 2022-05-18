import java.util.ArrayList;
import java.util.HashMap;

// Q) you are given an array and a target num,you have to find a pair in the array that adds upto that target.

public class TwoSum {
    public static void main(String args[]) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };

        ArrayList<Integer> result = twoSum1(arr, 7);
        System.out.println(result);
    }

    // brute force using two loops
    // basic algo we use two loops one start from 0 and other from one ahead of it,
    // if the sum is equal to target then we add the index of the two numbers to the
    // result arraylist
    // its not recommended as its a log time consuming algo
    public static ArrayList<Integer> twoSum1(int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result.add(i);
                    result.add(j);
                    return result;
                }

            }
        }

        return result;
    }

    // two sum using hashmap
    // here we use a hashmap to store the required number and its pair index, for eg
    // we come across 1, then we add target - 1 to hashmap so that we know if we
    // find target - 1 in the array, this plus the number before can equal to target
    public static ArrayList<Integer> twoSum2(int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result.add(map.get(target - nums[i]));
                result.add(i);
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    // two sum using two pointers
    // here we use two pointers to traverse the array, if the sum is equal to target
    // then we add the index of the two numbers to the result arraylist, else if the
    // sum is less than target then we move the left pointer to the right, else we
    // move the right pointer to the left

    // this assumes that the array is sorted
    public static ArrayList<Integer> twoSum3(int[] nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result.add(left);
                result.add(right);
                return result;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

}
