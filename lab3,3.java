import java.util.*;

class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human other) {
        return this.lastName.compareTo(other.lastName); // Сравнение по фамилии
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Возраст: " + age;
    }
}

class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}

public class Main {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        humanList.add(new Human("Иван", "Иванов", 25));
        humanList.add(new Human("Петр", "Петров", 30));
        humanList.add(new Human("Анатолий", "Анатольев", 22));
        humanList.add(new Human("Геннадий", "Геннадиев", 28));

        // a) Используем HashSet
        Set<Human> hashSet = new HashSet<>(humanList);
        System.out.println("HashSet: " + hashSet);

        // b) Используем LinkedHashSet
        Set<Human> linkedHashSet = new LinkedHashSet<>(humanList);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // c) Используем TreeSet
        Set<Human> treeSet = new TreeSet<>(humanList);
        System.out.println("TreeSet: " + treeSet);

        // d) Создаем пустой TreeSet с компаратором HumanComparatorByLastName
        Set<Human> treeSetWithComparator = new TreeSet<>(new HumanComparatorByLastName());
        treeSetWithComparator.addAll(humanList);
        System.out.println("TreeSet с компоратором: " + treeSetWithComparator);

        // e) Создаем пустой TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetWithAnonymousComparator = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge()); // Сравнение по возрасту
            }
        });
        treeSetWithAnonymousComparator.addAll(humanList);
        System.out.println("TreeSet анонимным компаратором по возрасту: " + treeSetWithAnonymousComparator);
    }
}