package com.cc.config;

import com.cc.bean.Color;
import com.cc.bean.ColorFactoryBean;
import com.cc.bean.Person;
import com.cc.bean.Red;
import com.cc.condition.LinuxCondition;
import com.cc.condition.MyImportBeanDefinitionRegistrar;
import com.cc.condition.MyImportSelector;
import com.cc.condition.WindowsCondition;
import org.springframework.context.annotation.*;
// 对配置类中的组件进行统一设置
@Conditional({WindowsCondition.class}) // 满足当前条件，这个类中配置的所有bean注册才能生效
@Configuration
@Import({
  Color.class,
  Red.class,
  MyImportSelector.class,
  MyImportBeanDefinitionRegistrar.class
}) // @Import快速地导入组件，id默认是组件的全类名
public class MainConfig2 {
  // @Scope("prototype") // 通过@Scope注解来指定该bean的作用范围，也可以说成是调整作用域
  @Bean("cc")
  @Lazy
  public Person person() {
    System.out.println("给容器中添加咱们这个Person对象...");
    return new Person("cc", 21);
  }

  @Bean("bill")
  public Person person01() {

    return new Person("Bill Gates", 62);
  }

  @Conditional({LinuxCondition.class})
  @Bean("linus")
  public Person person02() {

    return new Person("linus", 48);
  }

  @Bean
  public ColorFactoryBean colorFactoryBean() {
    return new ColorFactoryBean();
  }
}
