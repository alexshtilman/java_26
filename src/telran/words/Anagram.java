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
		HashMap<Character, Long> map = new HashMap<Character, Long>();
		for (int i=0;i<word.length();i++) {
			map.compute(word.charAt(i), (w, prev) -> prev != null ? prev + 1 : 1);
		}
		for (int i=0;i<anagram.length();i++) {
			map.merge(anagram.charAt(i),1L, (w, prev) -> prev != null ? prev - 1 : 1);	
		}
		for (Long val : map.values()){
		   if (val>0)
			   return false;
		}		
		return true;

	}
}
