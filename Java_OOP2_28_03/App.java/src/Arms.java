public class Arms {
    
    protected String side;

    public Arms(String side) {
        this.side = side;
    }

    public void left(){ System.out.println("Attacco col " + this.side); }

    public void right(){ System.out.println("Attacco col " + this.side); }

}
