package org.mammadov;

import org.mammadov.configuration.MyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication=context.getBean("communication",Communication.class);
        Child child=new Child(4,"Fidu",1);
        communication.saveChild(child);
    }
}
