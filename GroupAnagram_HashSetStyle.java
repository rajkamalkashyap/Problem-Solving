/* Problem Name is &&& Group Anagrams &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 *  1) Given a list of words, group them by anagrams
 *     Input: List of "cat", "dog", "god"
 *     Output: A Set of Sets of anagrams: {{'cat'}, {'dog', 'god'}}
 *  2) Run this code in the REPL to observe its behaviour. The
 *     execution entry point is main().
 *  3) Consider adding some additional tests in doTestsPass().
 *  4) Implement the AnagramSolution group() method correctly.
 *  5) If time permits, try to improve your implementation.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* To execute Java, please define "static void main" on a class
* named Solution.
*
* If you need more classes, simply define them inline.
*/
public class Solution {

  /**
   * A means for grouping words by anagram (same letters irrespective of order)
   */
  @FunctionalInterface
  interface AnagramSolution {
    Set<Set<String>> group(List<String> words);
  }

  /**
   * public static boolean doTestsPass()
   * Returns true if all tests pass. Otherwise returns false
   */
  public static boolean doTestsPass(){
    // given some words
    List<String> words = Arrays.asList("cat", "dog", "god", "cat");

    AnagramSolution sol = (input) -> {
      Map<String, Set<String>> hashIndex = new HashMap<>();

      input.stream().forEach((word) -> {
        String sorted = sortCharacters(word); // or a set of the characters
        if (!hashIndex.containsKey(sorted)) hashIndex.put(sorted, new HashSet<>());
        hashIndex.get(sorted).add(word);
      });

      return new HashSet<>(hashIndex.values());
    };

    // when grouped
    Set<Set<String>> grouped = sol.group(words);

    // we expect god and dog to be identified as anagrams, whilst cat isn't
    boolean result = true;
    result = result && grouped.contains(new HashSet<>(Arrays.asList("cat")));
     result = result && grouped.contains(new HashSet<>(Arrays.asList("dog", "god")));
    return result;
  };

  private static String sortCharacters(String word) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  /**
   * Execution entry point.
   */
  public static void main(String[] args){
    if(doTestsPass()){
      System.out.println("All tests pass");
    } else {
      System.out.println("There are test failures");
    }

  }
}
