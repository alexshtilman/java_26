package telran.words;
import java.util.HashMap;
public class Anagram {
	// check if string containing anagram may be an anagram of string containing
	// word
	// additional requirement: create only one map with applying methods merge and
	// compute
	public static boolean isAnagram(String word, String anagram) {
		if (word.length() == 0 || anagram.length() == 0 || word.length() != anagram.length() || word == anagram)
			return false;

		/*simple first solution
		int[] count = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
        */
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c:word.toCharArray()) {
			map.compute(c, (key, prev) -> prev != null ? prev + 1 : 1);
		}
		for (char c:anagram.toCharArray()) {
			map.merge(c,1, (c1, c2) -> c1 -c2==0?null:c1-c2  );	
		}
		return map.isEmpty();

	}
}
