package com.cc.condition;

import com.cc.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

  /**
   * AnnotationMetadata：当前类的注解信息 BeanDefinitionRegistry：BeanDefinition注册类
   *
   * <p>我们可以通过调用BeanDefinitionRegistry接口中的registerBeanDefinition方法，手动注册所有需要添加到容器中的bean
   */
  @Override
  public void registerBeanDefinitions(
      AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
    boolean definition = registry.containsBeanDefinition("com.cc.bean.Blue");
    boolean definition1 = registry.containsBeanDefinition("com.cc.bean.Red");
    if (definition && definition1) {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
      //            注册bean，指定名称
      registry.registerBeanDefinition("rainbow", beanDefinition);
    }
  }
}
