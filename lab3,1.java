import java.util.*;

public class Main {

    // a) Создайте массив из N случайных чисел от 0 до 100
    public static int[] createRandomArray(int n) {
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(101); // Генерируем числа от 0 до 100
        }
        System.out.println("Сгенерированный массив: " + Arrays.toString(array));
        return array;
    }
 // b) На основе массива создайте список List
    public static List<Integer> arrayToList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("Список на основе массива: " + list);
        return list;
    }

    // c) Отсортируйте список по возрастанию
    public static void sortListAscending(List<Integer> list) {
        Collections.sort(list);
        System.out.println("Список отсортирован по возрастанию: " + list);
    }

    // d) Отсортируйте список в обратном порядке
    public static void sortListDescending(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Список отсортирован в обратном порядке: " + list);
    }

    // e) Перемешайте список
    public static void shuffleList(List<Integer> list) {
        Collections.shuffle(list);
        System.out.println("Список перемешан: " + list);
    }

    // f) Выполните циклический сдвиг на 1 элемент
    public static void rotateList(List<Integer> list) {
        if (!list.isEmpty()) {
            Collections.rotate(list, 1);
            System.out.println("Список после циклического сдвига на 1 элемент: " + list);
        }
    }

    // g) Оставьте в списке только уникальные элементы
    public static void retainUnique(List<Integer> list) {
        Set<Integer> uniqueElements = new HashSet<>(list);
        list.clear();
        list.addAll(uniqueElements);
        System.out.println("Список с уникальными элементами: " + list);
    }

    // h) Оставьте в списке только дублирующиеся элементы
    public static void retainDuplicates(List<Integer> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : list) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        list.clear();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        System.out.println("Список с дублирующимися элементами: " + list);
    }

    // i) Из списка получите массив
    public static Integer[] listToArray(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(array));
        return array;
    }

    // j) Посчитайте количество вхождений каждого числа в массив и выведите на экран
    public static void countOccurrences(int[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Количество вхождений каждого числа в массиве: " + countMap);
    }

    public static void main(String[] args) {
        int n = 20; // размер массива
        int[] randomArray = createRandomArray(n);
        List<Integer> list = arrayToList(randomArray);

        sortListAscending(list);
        sortListDescending(list);
        shuffleList(list);
        rotateList(list);
        retainUnique(list);
        retainDuplicates(list);

        Integer[] arrayFromList = listToArray(list);
        countOccurrences(randomArray);
    }
   
}