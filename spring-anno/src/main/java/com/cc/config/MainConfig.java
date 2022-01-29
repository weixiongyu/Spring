package com.cc.config;

import com.cc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration // 告诉spring这是一个配置类
@ComponentScan(
        value = "com.cc",
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.CUSTOM,
                        classes = {MyTypeFilter.class})
        },
        useDefaultFilters = false)
public class MainConfig {

  @Bean("person") // 告诉spring这是一个bean，交给容器处理
  public Person person21() {
    return new Person("cc", 23);
  }
}
