package com.mdx.mybatis.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.mdx.mybatis.configuration.DruidDataSourceConfig;
import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DruidDataSourceConfig.class})
public @interface EnableMybatis {
    /**
     * mapper搜索路径。多个路径使用“;”或者“,”分割
     */
    String basePackage();

    /**
     * 使用annotation过滤mapper。默认值是Annotation.class，不过滤。预定义了一个MapperComponent
     * 统一标记mapper
     */
    Class<? extends Annotation> annotationClass() default Annotation.class;

    /**
     * pojo搜索路径。多个路径使用“;”或者“,”分割。用于注册pojo别名
     */
    String pojoPackage() default "";
}
