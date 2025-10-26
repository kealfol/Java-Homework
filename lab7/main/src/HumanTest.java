import java.util.*;

class Human implements Comparable<Human> {
    private String fName;
    private String lName;
    private int age;

    public Human(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Human o) {
        int rez;
        if (this.equals(o))
            return 0;
        rez = fName.compareToIgnoreCase(o.getfName());
        if (rez != 0)
            return rez;
        rez = lName.compareToIgnoreCase(o.getlName());
        if (rez != 0)
            return rez;
        else
            return age - o.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return age == human.age &&
               Objects.equals(fName, human.fName) &&
               Objects.equals(lName, human.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, lName, age);
    }
}

class HumanComparatorByLName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getlName().compareToIgnoreCase(h2.getlName());
    }
}

class HumanTest {
    public static void main(String[] args) {
        Set<Human> s = new HashSet<>();
        s.add(new Human("Ivan", "Petrov", 25));
        s.add(new Human("Anna", "Sidorova", 30));
        s.add(new Human("Dmitry", "Petrov", 28));

        Set<Human> hashSet = new HashSet<>(s);
        System.out.println("a) " + hashSet);

        Set<Human> linkedHashSet = new LinkedHashSet<>(s);
        System.out.println("b) " + linkedHashSet);

        Set<Human> treeSet = new TreeSet<>(s);
        System.out.println("c) " + treeSet);

        Set<Human> treeSetByLName = new TreeSet<>(new HumanComparatorByLName());
        treeSetByLName.addAll(s);
        System.out.println("d) " + treeSetByLName);

        Set<Human> treeSetByAge = new TreeSet<>((h1, h2) -> Integer.compare(h1.getAge(), h2.getAge()));
        treeSetByAge.addAll(s);
        System.out.println("e) " + treeSetByAge);
    }
}