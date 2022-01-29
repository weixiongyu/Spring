package com.cc.test;

import com.cc.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        // 1. 创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
        //applicationContext.getBean("car"); // 多实例bean在获取的时候才创建对象

        //2 关闭容器
     applicationContext.close();
      //spring容器不会自动管理多实例的bean对象，只有当作用域是单实例的时候ioc容器才会接管bean对象，一旦容器关闭，那么对应的单实例也将会注销
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");
    System.out.println("-------------------");
    //调用创建对象
        Object cat = applicationContext.getBean("cat");
    System.out.println("---------------");
        //调用创建对象
        Object cat1 = applicationContext.getBean("cat");
        System.out.println("---------------");
        //关闭容器 在多实例bean情况下，Spring不会自动调用bean的销毁方法。
//        applicationContext.close();


    }
}
