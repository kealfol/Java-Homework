import java.util.function.Consumer;

class HeavyBox {
    int weight;
    HeavyBox(int weight) {
        this.weight = weight;
    }
}

public class Num3 {
    public static void main(String[] args) {
        Consumer<HeavyBox> unload = box -> System.out.println("Отгрузили ящик с весом " + box.weight);
        Consumer<HeavyBox> send = box -> System.out.println("Отправляем ящик с весом " + box.weight);

        Consumer<HeavyBox> unloadAndSend = unload.andThen(send);

        HeavyBox box1 = new HeavyBox(50);
        HeavyBox box2 = new HeavyBox(75);

        unloadAndSend.accept(box1);
        unloadAndSend.accept(box2);
    }
}