package arrays;

// Q) Given two strings s and t,return true if t is an anagram of s,and false otherwise.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,typically using all the original letters exactly once.

// TC - O(n)
// SC - O(1)

public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26];

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }

    for (int i : count) {
      if (i != 0) {
        return false;
      }
    }

    return true;
  }
}
