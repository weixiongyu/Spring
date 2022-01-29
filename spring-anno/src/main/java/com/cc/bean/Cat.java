package com.cc.bean;

import javafx.fxml.Initializable;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;
//@Scope("prototype")
@Component
public class Cat implements InitializingBean, DisposableBean {

        public Cat(){
    System.out.println("cat constructor...");
        }
    //容器关闭的时候会调用此方法
    @Override
    public void destroy() throws Exception {
    System.out.println("cat destroy...........");
    }
    //bean创建好了，并且属性值都已经赋值好了的情况下自动调用此方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat afterPropertiesSet...");
    }
}
