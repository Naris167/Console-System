package W9_Assignments;
import java.util.*;

public class W9T2_CollectionSort {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("four");
        words.add("score");
        words.add("and");
        words.add("seven");
        words.add("years");
        words.add("ago");

        // show list before and after sorting
        System.out.println("before sort, words = " + words);
        Collections.sort(words);
        System.out.println("after sort, words = " + words);
    }
}
