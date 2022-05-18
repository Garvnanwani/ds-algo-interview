package recursion;

public class DecimalToBinary {
  public static void main(String[] args) {
    int num = 123;
    System.out.println(decimalToBinary(num));
  }

  public static int decimalToBinary(int num) {
    if (num == 0) {
      return 0;
    }

    return 10 * decimalToBinary(num / 2) + num % 2;
  }
}
