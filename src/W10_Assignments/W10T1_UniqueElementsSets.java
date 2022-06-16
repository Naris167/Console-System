package W10_Assignments;

import java.util.HashSet;
import java.util.Set;

public class W10T1_UniqueElementsSets {
    public static void main(String[] args) {
        Set<String> words1 = new HashSet<>();
        words1.add("Hello");
        words1.add("Welcome");
        words1.add("How");
        words1.add("Hi");

        Set<String> words2 = new HashSet<>();
        words2.add("Hi");
        words2.add("How");
        words2.add("Yoo");
        words2.add("bro");

        int unique = totalElements(words1,words2);
        System.out.println("\nThere are " + unique + " unique elements from both sets.");
    }

    // Returns the number of unique elements contained
    // in either set1 or set2. Not a good model to follow.
    public static int totalElements(Set<String> set1, Set<String> set2) {
        int count = set1.size();
            for (String element : set2) {
                if (!set1.contains(element)) {
                    count++;
                }
            }
        return count;
    }
}
