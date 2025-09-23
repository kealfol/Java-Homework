public class Bell {
    private int count;

    public void Bell(){
        count = 0;
    }

    public void sound(){
        if (count % 2 == 0){
            System.out.println("Ding");
        } else {System.out.println("Dong");}
        count++;
    }
}
