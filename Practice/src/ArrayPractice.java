import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        ArrayList<String> lines = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        System.out.println(lines);
    }
}