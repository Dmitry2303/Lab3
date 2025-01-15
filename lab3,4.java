import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку с текстом на английском языке:");
        String input = scanner.nextLine();

        // Создаем HashMap для подсчета частоты слов
        Map<String, Integer> wordCount = new HashMap<>();

        // Приводим строку к нижнему регистру и разбиваем на слова
        String[] words = input.toLowerCase().split("\\W+"); // Используем регулярное выражение для разделения по пробелам и пунктуации

        // Подсчитываем частоту каждого слова
        for (String word : words) {
            if (!word.isEmpty()) { // Проверяем, что слово не пустое
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Выводим результаты
        System.out.println("Частота встречаемости слов:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}