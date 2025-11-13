import java.time.LocalDate;
import java.util.*;

class Student {
    int id;
    String lastName, firstName, patronymic;
    LocalDate birthDate;
    String address, phone, faculty;
    int course;
    String group;

    Student(int id, String lastName, String firstName, String patronymic,
            LocalDate birthDate, String address, String phone,
            String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    Student(String lastName, String firstName, String patronymic,
            LocalDate birthDate, String address, String phone,
            String faculty, int course, String group) {
        this(0, lastName, firstName, patronymic, birthDate, address, phone, faculty, course, group);
    }

    void setFaculty(String faculty) { this.faculty = faculty; }
    String getFaculty() { return faculty; }

    @Override
    public String toString() {
        return id + " | " + lastName + " " + firstName + " " + patronymic +
                " | " + birthDate + " | " + address + " | " + phone +
                " | " + faculty + " | " + course + " | " + group;
    }
}

public class Num8 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student(1, "Иванов", "Иван", "Иванович", LocalDate.of(2000, 5, 10), "ул. Ленина", "52345234523", "ИЦ", 2, "КБ-241"),
            new Student(2, "Петров", "Петр", "Петрович", LocalDate.of(2001, 3, 15), "ул. Гагарина", "39356356363", "ИЦ", 3, "ПИ-231"),
            new Student(3, "Сидоров", "Сидор", "Сидорович", LocalDate.of(2002, 7, 20), "ул. Пушкина", "7680756780", "НЕИЦ", 2, "МЕМ-241"),
            new Student(4, "Андреев", "Андрей", "Андреевич", LocalDate.of(2003, 1, 5), "ул. Чехова", "0275745412", "ИЦ", 1, "ФИТ-251")
        );

        System.out.println("=== Все студенты ===");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\n=== Студенты факультета 'Институт Цифры' ===");
        for (Student s : students) {
            if ("ИЦ".equals(s.getFaculty())) {
                System.out.println(s);
            }
        }

        System.out.println("\n=== Студенты ИЦ, 2 курс ===");
        students.stream()
                .filter(s -> "ИЦ".equals(s.getFaculty()) && s.course == 2)
                .forEach(System.out::println);

        System.out.println("\n=== Студенты, родившиеся после 2001 года ===");
        students.stream()
                .filter(s -> s.birthDate.getYear() > 2001)
                .forEach(System.out::println);
    }
}