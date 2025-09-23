public class Button {
    private int ClickCount;

    public void Button(){
        ClickCount = 0;
    }

    public void click(){
        ClickCount++;
        System.out.println("Button was clicked " + ClickCount + " times");        
    }
}