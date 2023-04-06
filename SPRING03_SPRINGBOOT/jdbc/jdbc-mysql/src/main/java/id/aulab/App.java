package id.aulab;

import java.math.BigInteger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import id.aulab.model.Restaurant;

public class App 
{
    public static void main( String[] args )
    {   

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DaoProject dao = context.getBean(DaoProject.class);

        Restaurant r = dao.getOne(new BigInteger("1"));

        r.setDescription("Non più errori ma solidi warnings");

        dao.update(r.getId(), r);
        // dao.delete(new BigInteger("2"));
        // Restaurant r2 = new Restaurant();
        // r2.setName("Da Pino");
        // r2.setDescription("Maronn sant che bontezza");
        // r2.setNumber_clients(3);
        // dao.insert(r2);

        System.out.println("Id: " + r.getId());
        System.out.println("Name: " + r.getName());
        System.out.println("Description: " + r.getDescription());
        System.out.println("Number of clients: " + r.getNumber_clients());

        for(Restaurant errino : dao.getData()){
            System.out.println("Lista di tutti i ristoranti: " + String.join(" ", errino.getName(), errino.getDescription(), Integer.toString(errino.getNumber_clients())));
        
        }

        System.out.println("Il numero dei ristoranti è " + dao.count());
    }
}
