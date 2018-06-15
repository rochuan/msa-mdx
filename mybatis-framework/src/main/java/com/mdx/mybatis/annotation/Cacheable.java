package com.mdx.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created on 2017/9/29.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cacheable {

    /**
     * 主要实体类，根据类名做缓存，默认则以返回的实体类作为主key
     */
    Class<?> primaryEntry() default Void.class;

    /**
     * 主要的参数列表，默认为空则遍历所有参数作为缓存key
     */
    String[] primaryParamNames() default {};

    /**
     * 暂未用到
     */
    int exprie() default -1;

}
