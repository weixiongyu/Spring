package com.cc.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑，返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.cc.bean.Blue","com.cc.bean.Yellow"}; // 可以返回一个空数组
    }
}
