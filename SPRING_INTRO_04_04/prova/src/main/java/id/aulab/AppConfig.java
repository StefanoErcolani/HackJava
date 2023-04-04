package id.aulab;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import id.aulab.model.Side1;
import id.aulab.model.Side2;
import id.aulab.model.Side3;
import id.aulab.model.Triangle;


@Configuration
@ComponentScan("it.aulab")
public class AppConfig {
    
    @Bean(name = "side1")
        public Side1 getSide1(){
            return new Side1(7);
        }

    @Bean(name = "side2")
        public Side2 getSide2(){
            return new Side2(12);
        }

    @Bean(name = "side3")
        public Side3 getSide3(){
            return new Side3(7);
        }

    @Bean(name = "triangle")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
        public Triangle getTriangle(){
            return new Triangle(getSide1(), getSide2(), getSide3());
        }
}