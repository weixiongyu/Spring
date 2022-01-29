package com.cc.test;

import com.cc.bean.Person;
import com.cc.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
  public static void main(String[] args) {
    //

    //    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    //    Person person = (Person) context.getBean("person");
    //    System.out.println(person);
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
    Person person = context.getBean("person", Person.class);
    System.out.println(person);
    String[] namesForAnnotation = context.getBeanNamesForType(Person.class);
    for (String s : namesForAnnotation) {
      System.out.println(s);
    }
  }
}
