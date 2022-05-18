package recursion;

public class ReverseString {
  public static void main(String[] args) {
    System.out.println("Reverse String");
    String str = "Hello World";
    System.out.println(reverseString(str));
  }

  public static String reverseString(String s) {
    if (s == "") {
      return "";
    }

    return reverseString(s.substring(1)) + s.charAt(0);
  }
}
