// Task 1: Report some basic information about a file.
import java.io.File;
public class W8T1_FileInfo {
    public static void main(String[] args) {
        File f = new File("W8_sample1.txt");
        System.out.println("exists returns " + f.exists());
        System.out.println("canRead returns " + f.canRead());
        System.out.println("length returns " + f.length());
        System.out.println("getAbsolutePath returns " + f.getAbsolutePath());
    }
}