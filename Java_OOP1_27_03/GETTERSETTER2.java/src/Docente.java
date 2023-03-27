public class Docente{

    private String nome;

    private String cognome;

    private int età;

    private String codice;

    //constructor

    public Docente(String nome, String cognome, int età, String codice){

        this.nome = nome;

        this.cognome = cognome;

        this.età = età;

        this.codice = codice;

    }


    //getter1
    public String getCognome(){ return this.cognome; }

    public int getEtà(){ return this.età; }

    public String getCodice(){ return this.codice; }

}