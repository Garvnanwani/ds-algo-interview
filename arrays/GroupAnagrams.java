package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Q) Given an array of strings strs,group the anagrams together.You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,typically using all the original letters exactly once.

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] sArr = s.toCharArray();
      Arrays.sort(sArr);
      String key = String.valueOf(sArr);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);
    }
    return new ArrayList<>(map.values());
  }
}
