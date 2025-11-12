import java.util.*;

class Phone {
    String number;
    String type;

    Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }
}

class Client {
    int id;
    String name;
    int age;
    List<Phone> phones;

    Client(int id, String name, int age, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phones = phones;
    }
}

public class Num7 {
    public static void main(String[] args) {
        List<Client> clients = Arrays.asList(
            new Client(1, "Kolya", 25, Arrays.asList(new Phone("123", "мобильный"))),
            new Client(2, "Bob", 19, Arrays.asList(new Phone("456", "стационарный"), new Phone("789", "мобильный"))),
            new Client(3, "Dima", 30, Arrays.asList(new Phone("012", "мобильный")))
        );

        Client youngestMobileUser = clients.stream()
                .filter(c -> c.phones.stream().anyMatch(p -> p.type.equals("мобильный")))
                .min(Comparator.comparingInt(c -> c.age))
                .orElse(null);

        System.out.println(youngestMobileUser != null ? 
            youngestMobileUser.name + "(" + youngestMobileUser.age + ")" : 
            "Нет клиентов с мобильным телефоном");
    }
}