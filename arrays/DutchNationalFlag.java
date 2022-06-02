package arrays;

import java.util.Arrays;

// Q) Given an array containing 0 s,1 s and 2 s,sort the array in-place.You should treat numbers of the array as objects,hence,we can’t count 0 s,1 s,and 2 s to recreate the array.

public class DutchNationalFlag {
  public static void main(String[] args) {
    int[] arr = { 0, 1, 1, 1, 0, 0, 1, 2, 1, 1, 0, 0, 2, 1, 1, 1, 1, 0, 2, 0, 1 };
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] arr) {
    int low = 0;
    int high = arr.length - 1;

    int i = 0;

    while (i <= high) {
      if (arr[i] == 0) {
        swap(arr, i, low);
        i++;
        low++;
      } else if (arr[i] == 1) {
        i++;
      } else {
        swap(arr, i, high);
        high--;
      }
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
