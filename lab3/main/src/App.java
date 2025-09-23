public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("#1");

        Button btn = new Button();

        btn.click();
        btn.click();
        btn.click();

        System.out.println("#2");

        Balance balance = new Balance();
        
        balance.addLeft(12);
        balance.addRight(7);
        balance.result(); 
        
        balance.addRight(7);
        balance.result(); 
        
        balance.addLeft(2);
        balance.result(); 

        System.out.println("#3");

        Bell b = new Bell();

        b.sound();
        b.sound();
        b.sound();
        b.sound();

        System.out.println("#4");

        OddEvenSeparator num = new OddEvenSeparator();

        for(int i = 0; i <=10;i++){
            num.addNumber(i);
        }

        num.even();
        num.odd();

        System.out.println("#5");

        Table t = new Table(3, 3);
        t.SetValue(0, 0, 1);
        t.SetValue(0, 1, 2);
        t.SetValue(0, 2, 3);
        t.SetValue(1, 0, 4);
        t.SetValue(1, 1, 5);
        t.SetValue(1, 2, 6);
        t.SetValue(2, 0, 7);
        t.SetValue(2, 1, 8);
        t.SetValue(2, 2, 9);

        System.out.println(t.getValue(1,1));

        System.out.println(t.rows());
        System.out.println(t.cols());

        System.out.println(t.toString());

        System.out.println(t.average());
    }
}