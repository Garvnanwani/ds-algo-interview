package sorting;

public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 3, 2, 6, -1, 4, 1, 8, 2 };
    bubbleSort(arr);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

  static void bubbleSort(int[] arr) {

    for (int i = 0; i < arr.length - 1; i++) {

      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
  }
}
