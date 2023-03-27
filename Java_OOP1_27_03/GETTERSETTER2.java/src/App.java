// Scrivere una classe Docente che rappresenti le seguenti informazioni relative ad un docente: nome,
// cognome, codice ed età, e che contenga il costruttore parametrizzato ed i metodi getCodice, getCognome e
// getEta che restituiscono rispettivamente il codice, il cognome e l’età del docente.
// Scrivere poi una classe Universita, che rappresenti un insieme di docenti universitari tramite un array di tipo
// Docente, e che contenga il costruttore parametrizzato ed un metodo etaMinima che restituisce la minima
// età tra i docenti universitari.
public class App {
    public static void main(String[] args){

        Docente d1 = new Docente("Pippo", "Baudo", 80, "KappaSwag98");

        Docente d2 = new Docente("Agostino", "Tinozza",25, "MormonePoligamo88");
    
        Docente d3 = new Docente("Giuseppe", "Garibaldi", 170, "ItaliaUnita60");   

        if(d1.getEtà() < d2.getEtà() && d1.getEtà() < d3.getEtà()) {

            System.out.println(d1.getEtà());

        }else if(d2.getEtà() < d3.getEtà() && d2.getEtà() < d1.getEtà()){ 

            System.out.println(d2.getEtà());

        } else if(d3.getEtà() < d1.getEtà() && d3.getEtà() < d2.getEtà()) {

            System.out.println(d3);
            
        }
        
    }
}
