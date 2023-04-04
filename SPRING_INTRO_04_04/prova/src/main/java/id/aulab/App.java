package id.aulab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import id.aulab.services.*;
import id.aulab.model.*;
import id.aulab.services.CanATriangle;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    //     Side1 side1 = context.getBean("side1", Side1.class);
    //     Side2 side2 = context.getBean("side2", Side2.class); 
    //     Side3 side3 = context.getBean("side3", Side3.class);  
    //     Triangle triangle = context.getBean("triangle", Triangle.class);

    //     System.out.println(side1);
    //     System.out.println(side2);
    //     System.out.println(side3);
    //     System.out.println(triangle);

    
        CanATriangle canTriangle = context.getBean("triangleServices", CanATriangle.class);
    
        canTriangle.love();

    }
}
