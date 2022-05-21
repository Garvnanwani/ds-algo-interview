package sorting;

public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
    insertionSort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  static void insertionSort(int[] arr) {

    for (int i = 1; i < arr.length; i++) {
      int sel = arr[i];
      int j = i - 1;
      while (j >= 0 && sel < arr[j]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
        i--;
      }

    }
  }

}
