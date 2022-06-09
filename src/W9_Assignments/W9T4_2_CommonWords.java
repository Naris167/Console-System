package W9_Assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class W9T4_2_CommonWords {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        giveIntro();

        System.out.print("file #1 name? "); // W9_Book1.txt
        Scanner in1 = new Scanner(new File(console.nextLine()));
        System.out.print("file #2 name? "); // W9_Book2.txt
        Scanner in2 = new Scanner(new File(console.nextLine()));
        System.out.println();

//        FOR DEBUG
//        Scanner in1 = new Scanner(new File("W9_Book1.txt"));
//        Scanner in2 = new Scanner(new File("W9_Book2.txt"));

        ArrayList<String> list1 = getWords(in1);
        ArrayList<String> list2 = getWords(in2);

//        FOR DEBUG
//        System.out.println("\nOriginal array Book 1: " + list1);
//        System.out.println("\nOriginal array Book 2: " + list2);

        ArrayList<String> common = getOverlap(list1, list2);
        reportResults(list1, list2, common);
    }
    // post: reads words from the Scanner, converts them to
    // lowercase, returns a sorted list of unique words
    public static ArrayList<String> getWords(Scanner input) {
        // ignore all but alphabetic characters and apostrophes
        input.useDelimiter("[^a-zA-Z']+");
        // read all words and sort
        ArrayList<String> words = new ArrayList<String>();
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            words.add(next);
        }
        Collections.sort(words);
        // add unique words to new list and return
        ArrayList<String> result = new ArrayList<String>();
        if (words.size() > 0) {
            result.add(words.get(0));
            for (int i = 1; i < words.size(); i++) {
                if (!words.get(i).equals(words.get(i - 1))) {
                    result.add(words.get(i));
                }
            }
        }
        return result;
    }
    // pre : list1 and list2 are sorted and have no duplicates
    // post: constructs and returns an ArrayList containing
    // the words in common between list1 and list2
    public static ArrayList<String> getOverlap(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> result = new ArrayList<String>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            int num = list1.get(i1).compareTo(list2.get(i2));
            if (num == 0) {
                result.add(list1.get(i1));
                i1++;
                i2++;
            } else if (num < 0) {
                i1++;
            } else { // num > 0
                i2++;
            }
        }
        return result;
    }
    // post: explains program to user
    public static void giveIntro() {
        System.out.println("This program compares two text files");
        System.out.println("and reports the number of words in");
        System.out.println("common and the percent overlap.");
        System.out.println();
    }
    // pre : common contains overlap between list1 and list2
    // post: reports statistics about lists and their overlap
    public static void reportResults(ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> common) {
        System.out.println("Number of Unique Words in Book #1 = " + list1.size());
        System.out.println("Number of Unique Words in Book #2 = " + list2.size());
        System.out.println("Number of Common Words = " + common.size());
        System.out.println("List of Common Words:\n" + common);
    }
}
