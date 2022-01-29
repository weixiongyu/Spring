package com.cc.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
  /**
   * 如果实现自定义规则进行过滤时，自定义规则的类必须是org.springframework.core.type.filter.TypeFilter接口的实现类。
   * metadataReader：读取到的当前正在扫描的类的信息 metadataReaderFactory：可以获取到其他任何类的信息的（工厂）
   */
  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
      throws IOException {
    AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
    ClassMetadata classMetadata = metadataReader.getClassMetadata();
    Resource resource = metadataReader.getResource();
    String className = classMetadata.getClassName();
    System.out.println("=========" + className);

    // 制订规则
    if (className.contains("er")) {
      return true;
    } else {
      return false;
    }
  }
}
