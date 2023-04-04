public class TriangleKey {
    String hash;
    int progressivo;

public TriangleKey(String hash, int progressivo) {
        this.hash = hash;
        this.progressivo = progressivo;
    }

    @Override
    public int hashCode(){
        //usare numeri primi
        final int prime = 31;

        int result = 1;

        return prime * result * ((hash == null) ? 0 : hash.hashCode());
    }

    @Override
    public boolean equals(Object obj){
        //as soon as possible
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;

        //casting dell'oggeto come obj della classe key
        TriangleKey other = (TriangleKey) obj;
        //controlli di uguaglianza del codice( hash == null o meno e progressivo)
        if(hash == null){
            if(other.hash != null) return false;

        } else if(!hash.equals(other.hash)) return false;

        if(progressivo != other.progressivo) return false;

        return true;

    }
}

