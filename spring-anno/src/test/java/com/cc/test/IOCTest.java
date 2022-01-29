package com.cc.test;

import com.cc.bean.Person;
import com.cc.config.MainConfig;
import com.cc.config.MainConfig2;
import com.cc.config.MainConfig3;
import com.cc.scope.ThreadScope;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class IOCTest {

  @SuppressWarnings("resource")
  @Test
  public void test01() {
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
    String[] beanDefinitionNames = context.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      System.out.println(beanDefinitionName);
    }
  }

  @Test
  public void test02() {
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
    Person cc = (Person) context.getBean("cc");
    Person cc1 = (Person) context.getBean("cc");
    System.out.println(cc == cc1);
  }

  @Test
  public void test03() {
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
  }

  @Test
  public void test04() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(MainConfig3.class);
    // 向容器中注册自定义的Scope
    applicationContext.getBeanFactory().registerScope(ThreadScope.THREAD_SCOPE, new ThreadScope());

    for (int i = 0; i < 2; i++) {
      new Thread(
              () -> {
                System.out.println(
                    Thread.currentThread() + "," + applicationContext.getBean("person"));
                System.out.println(
                    Thread.currentThread() + "," + applicationContext.getBean("person"));
              })
          .start();
    }
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void test05() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(MainConfig2.class);
    System.out.println("IOC容器创建完成");
    Person cc = (Person) applicationContext.getBean("cc");
    Person cc1 = (Person) applicationContext.getBean("cc");
    System.out.println(cc == cc1);
  }

  @Test
  public void test06() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(MainConfig2.class);
    // 我们现在就来看一下IOC容器中Person这种类型的bean都有哪些
    String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
    ConfigurableEnvironment environment = applicationContext.getEnvironment(); // ioc运行环境
    // 动态获取坏境变量的值，例如操作系统的名字
    String property = environment.getProperty("os.name"); // 获取操作系统的名字，例如Windows 10
    System.out.println(property);

    for (String name : namesForType) {
      System.out.println(name);
    }
    Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
    System.out.println(persons);
  }

  @Test
  public void testImport() {
    AnnotationConfigApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(MainConfig2.class);
    String[] definitionNames = applicationContext.getBeanDefinitionNames();
    for (String name : definitionNames) {
      System.out.println(name);
    }

    // 工厂bean获取的是调用getObject方法创建的对象
    Object bean2 = applicationContext.getBean("colorFactoryBean");
    Object bean3 = applicationContext.getBean("colorFactoryBean");
    System.out.println("bean的类型：" + bean2.getClass());
    System.out.println(bean2 == bean3);
    Object bean4 = applicationContext.getBean("&colorFactoryBean");
    System.out.println(bean4.getClass());
  }
}
