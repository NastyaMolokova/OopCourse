import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDuplicationPractice {
    public static void main(String[] args) {
        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 9, 5, 5, 7, 6, 2, 6, 9, 6, 1, 7));
        ArrayList<Integer> numbers2 = new ArrayList<>();
        System.out.println("Исходный список: " + numbers1);

        for (Integer number : numbers1) {
            if (!numbers2.contains(number)) {
                numbers2.add(number);
            }
        }

        System.out.println("Новый список без повторяющихся элементов: " + numbers2);
    }
}