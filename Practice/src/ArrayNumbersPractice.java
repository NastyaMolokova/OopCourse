import java.util.ArrayList;
import java.util.Arrays;

public class ArrayNumbersPractice {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 8, 7, 3, 2, 6, 9, 4));
        System.out.println("Исходный список: " + numbers);

        for (int i = 0; i < numbers.size(); ) {
            Integer number = numbers.get(i);

            if (number % 2 == 0) {
                numbers.remove(i);
            } else {
                i++;
            }
        }

        System.out.println("Список после удаления четных чисел: " + numbers);
    }
}