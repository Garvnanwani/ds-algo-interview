// check whether a string is a palindrome using recursion
public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {
        if (str.length() == 1 || str.length() == 0) {
            return true;
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindrome(str.substring(1, str.length() - 1));
        }

        return false;
    }
}
