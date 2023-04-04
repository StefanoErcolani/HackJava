package id.aulab.model;

import id.aulab.model.Side1;
import id.aulab.model.Side2;
import id.aulab.model.Side3;

public class Triangle {

    private Side1 side1;
    private Side2 side2;
    private Side3 side3;

    public Triangle(Side1 side1, Side2 side2, Side3 side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Side1 getSideI() {
        return side1;
    }
    public void setSide1(Side1 side1) {
        this.side1 = side1;
    }
    
    public Side2 getSideII() {
        return side2;
    }
    public void setSide2(Side2 side2) {
        this.side2 = side2;
    }
    
    public Side3 getSideIII() {
        return side3;
    }
    public void setSide3(Side3 side3) {
        this.side3 = side3;
    }

    public Integer perimeter(Side1 side1, Side2 side2, Side3 side3){
        return side1.getSide1() + side2.getSide2() + side3.getSide3();
    }
    
}
