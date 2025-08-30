import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String outputPath = ".";
    private static String prefix = "";
    private static boolean appendMode = false;
    private static boolean showStats = false;
    private static boolean fullStats = false;

    private static List<String> parseArgs(String[] args) {
        boolean hasShort = false;
        boolean hasFull = false;
        List<String> files = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            switch (arg) {
                case "-o":
                    if (i + 1 >= args.length) {
                        System.err.println("Ошибка: опция -o требует аргумент (путь)");
                        return null;
                    }

                    outputPath = args[++i];
                    break;

                case "-p":
                    if (i + 1 >= args.length) {
                        System.err.println("Ошибка: опция -p требует аргумент (префикс)");
                        return null;
                    }

                    prefix = args[++i];
                    break;

                case "-a":
                    appendMode = true;
                    break;

                case "-f":
                    if (hasShort) {
                        System.err.println("Ошибка: нельзя использовать опции -s и -f одновременно");
                        return null;
                    }

                    hasFull = true;
                    fullStats = true;
                    showStats = true;
                    break;

                case "-s":
                    if (hasFull) {
                        System.err.println("Ошибка: нельзя использовать опции -s и -f одновременно");
                        return null;
                    }

                    hasShort = true;
                    fullStats = false;
                    showStats = true;
                    break;

                default:
                    if (arg.startsWith("-")) {
                        System.err.printf("Неизвестная опция: %s%n", arg);
                        return null;
                    }

                    files.add(arg);
                    break;
            }
        }
        return files;
    }

    private static boolean isInteger(String line) {
        try {
            Long.parseLong(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String line) {
        try {
            Double.parseDouble(line);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void sortLine(String line, List<String> integers, List<String> doubles, List<String> strings) {
        if (line == null || line.isBlank()) {
            return;
        }

        line = line.trim();

        if (isInteger(line)) {
            integers.add(line);
        } else if (isDouble(line)) {
            doubles.add(line);
        } else {
            strings.add(line);
        }
    }

    public static void readAndSortFile(String filename, List<String> integers, List<String> doubles, List<String> strings) {
        try (Scanner scanner = new Scanner(new FileInputStream(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                sortLine(line, integers, doubles, strings);
            }
        } catch (FileNotFoundException e) {
            System.err.printf("Файл не найден: %s%n", filename);
        }
    }

    public static void writeIfNotEmpty(List<String> data, String fileName, boolean append) {
        if (data.isEmpty()) {
            System.out.printf("Нет данных для записи в: %s - файл не создан.%n", fileName);
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName, append))) {
            for (String line : data) {
                writer.println(line);
            }
            System.out.printf("Файл записан: %s%n", fileName);
        } catch (IOException e) {
            System.out.printf("Не удалось записать в файл: %s%n", fileName);
        }
    }

    public static void printStats(List<String> integers, List<String> doubles, List<String> strings) {
        if (!showStats) {
            return;
        }

        if (!integers.isEmpty() || !doubles.isEmpty() || !strings.isEmpty()) {
            System.out.println("\tСТАТИСТИКА");

            printIntegerStats(integers);
            System.out.println();
            printDoubleStats(doubles);
            System.out.println();
            printStringStats(strings);
        }
    }

    private static void printIntegerStats(List<String> integers) {
        int count = integers.size();

        if (count == 0) {
            System.out.println("Количество целых чисел: 0");
            return;
        }

        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (String s : integers) {
            long num = Long.parseLong(s);
            sum += num;

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        double avg = (double) sum / count;

        if (fullStats) {
            System.out.printf("Количество целых чисел: %d\n", count);
            System.out.printf("Сумма целых чисел: %d\n", sum);
            System.out.printf("Среднее целое число: %.2f\n", avg);
            System.out.printf("Минимальное целое число: %d\n", min);
            System.out.printf("Максимальное целое число: %d\n", max);
        } else {
            System.out.printf("Количество целых чисел: %d\n", count);
        }
    }

    private static void printDoubleStats(List<String> doubles) {
        int count = doubles.size();

        if (count == 0) {
            System.out.println("Количество вещественных чисел: 0");
            return;
        }

        double sum = 0.0;
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        for (String s : doubles) {
            double num = Double.parseDouble(s);
            sum += num;

            if (num < min) {
                min = num;
            }

            if (num > max) {
                max = num;
            }
        }

        double avg = sum / count;

        if (fullStats) {
            System.out.printf("Количество вещественных чисел: %d\n", count);
            System.out.printf("Сумма вещественных чисел: %.2f\n", sum);
            System.out.printf("Среднее вещественное число: %.2f\n", avg);
            System.out.printf("Минимальное вещественное число: %.2f\n", min);
            System.out.printf("Максимальное вещественное число: %.2f\n", max);
        } else {
            System.out.printf("Количество вещественных чисел: %d\n", count);
        }
    }

    private static void printStringStats(List<String> strings) {
        int count = strings.size();

        if (count == 0) {
            System.out.println("Количество строк: 0");
            return;
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (String s : strings) {
            int len = s.length();

            if (len < minLength) {
                minLength = len;
            }

            if (len > maxLength) {
                maxLength = len;
            }
        }

        if (fullStats) {
            System.out.printf("Количество строк: %d\n", count);
            System.out.printf("Минимальная длина строки: %d\n", minLength);
            System.out.printf("Максимальная длина строки: %d\n", maxLength);
        } else {
            System.out.printf("Количество строк: %d\n", count);
        }
    }

    public static void main(String[] args) {
        List<String> files = parseArgs(args);

        if (files == null) {
            return;
        }

        if (files.isEmpty()) {
            System.err.println("Ошибка: не указан ни один файл для обработки.");
            return;
        }

        List<String> integers = new ArrayList<>();
        List<String> doubles = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        for (String filename : files) {
            readAndSortFile(filename, integers, doubles, strings);
        }

        File outputDir = new File(outputPath);
        if (!outputDir.exists()) {
            if (!outputDir.mkdirs()) {
                System.err.printf("Не удалось создать директорию: %s%n", outputPath);
                return;
            }
        }

        String intFile = Paths.get(outputPath, prefix + "integers.txt").toString();
        String doubleFile = Paths.get(outputPath, prefix + "floats.txt").toString();
        String stringFile = Paths.get(outputPath, prefix + "strings.txt").toString();

        writeIfNotEmpty(integers, intFile, appendMode);
        writeIfNotEmpty(doubles, doubleFile, appendMode);
        writeIfNotEmpty(strings, stringFile, appendMode);

        printStats(integers, doubles, strings);
    }
}