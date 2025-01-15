import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Integer> primes;

    public Main() {
        primes = new ArrayList<>();
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> generatePrimes(int N) {
        int number = 2;  // Начинаем с первого простого числа
        while (primes.size() < N) {
            if (isPrime(number)) {
                primes.add(number);
            }
            number++;
        }
        return primes;
    }

    public void printPrimesInOrder() {
        System.out.println("Первые " + primes.size() + " простых чисел в прямом порядке:");
        Iterator<Integer> iterator = primes.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void printPrimesInReverseOrder() {
        System.out.println("Первые " + primes.size() + " простых чисел в обратном порядке:");
        // Используем прямой доступ к элементам через индексы для обратного порядка
        for (int i = primes.size() - 1; i >= 0; i--) {
            System.out.print(primes.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество простых чисел для генерации: ");

        try {
            int N = scanner.nextInt();
            if (N < 1) {
                System.out.println("Введите положительное целое число.");
                return;
            }

            Main generator = new Main();
            generator.generatePrimes(N);
            // Выводим простые числа
            generator.printPrimesInOrder();
            generator.printPrimesInReverseOrder();
        } catch (Exception e) {
            System.out.println("Пожалуйста, введите целое число.");
        } finally {
            scanner.close();
        }
    }
}