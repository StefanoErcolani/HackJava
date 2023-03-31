public class MegaPunch extends Arms{

    public MegaPunch(String sideLabel) {
        super(sideLabel);
    }
    
    @Override
    public void attack(){  
    
        System.out.println("Justice punch! It's a  " + this.sideLabel);

    }


}
