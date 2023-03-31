public class Combine {
    
    private Limb limbsx;

    private Limb limbdx;

    private Limb limbtop;

    private Limb limbdown;

    private Torso torso;

    public Combine(Limb limbsx, Limb limbdx, Limb limbtop, Limb limbdown, Torso torso) {
        this.setLimb(limbsx, LimbLocation.Sx);
        this.setLimb(limbdx, LimbLocation.Dx);
        this.setLimb(limbdown, LimbLocation.Inferior);
        this.setLimb(limbtop, LimbLocation.Superior);
        this.torso = torso;
    }

    public Limb getLimbsx() {
        return limbsx;
    }

    public void setLimb(Limb limb, LimbLocation location) {
        if(location == LimbLocation.Sx) { this.limbsx = limb; }
        else if(location == LimbLocation.Dx) { this.limbdx = limb; }
        else if(location == LimbLocation.Superior) { this.limbtop = limb; }
        else if(location == LimbLocation.Inferior) { this.limbdown = limb; }
    }

    public Limb getLimbdx() {
        return limbdx;
    }

    public Limb getLimbtop() {
        return limbtop;
    }

    public Limb getLimbdown() {
        return limbdown;
    }

    public Torso getTorso() {
        return torso;
    }

    public void setTorso(Torso torso) {
        this.torso = torso;
    }

    
    public void dangers(){

        this.limbsx.dangerous();

        this.torso.dangerous();

        this.limbdx.dangerous();

        this.torso.dangerous();

        this.limbtop.dangerous();

        this.torso.dangerous();

        this.limbdown.dangerous();

        

    }

    public void moving() {

        this.limbsx.itMoves();

        this.limbdx.itMoves();

        this.limbtop.itMoves();

        this.limbdown.itMoves();

        this.torso.itMoves();

    }

}
