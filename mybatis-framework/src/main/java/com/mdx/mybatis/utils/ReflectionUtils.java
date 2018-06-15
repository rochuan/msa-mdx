package com.mdx.mybatis.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on 2017/9/4.
 * 反射工具类
 */
public final class ReflectionUtils {

    /**
     * 类中查找method, 用于参数数组中某对象可能是map的 ，参数可能是基本类型的
     * @param clazz
     * @param methodName
     * @param methodParams
     * @return
     */
    public static Method findMethod(Class clazz, String methodName, Object[] methodParams) {
        Method method = null;

        for(Method _method : clazz.getDeclaredMethods()) {
            if(_method.getName().equals(methodName)) {
                Class[] methodParamsTypes = _method.getParameterTypes();
                if(methodParams.length != methodParamsTypes.length) {
                    continue;
                }

                boolean flag = true;
                for (int i = 0; i < methodParams.length; i++) {
                    if(methodParams[i] instanceof Map) {
                        for(String key : ((Map<String, ?>) methodParams[i]).keySet()) {
                            try {
                                methodParamsTypes[i].getDeclaredField(key);
                            } catch (NoSuchFieldException e) {
                                flag = false;
                                break;
                            }
                        }
                    } else if (!methodParams[i].getClass().equals(methodParamsTypes[i])) {
                        Class classA = changeToBasicClass(methodParams[i])
                                , classB = changeToBasicClass(methodParamsTypes[i]);
                        if(!compareBasicClass(classA, classB)) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) {
                    method = _method;
                    break;
                }
            }
        }

        return method;
    }

    /**
     * 实体转map
     * @param source
     * @return
     */
    public static Object getFileds(Object source) {
        if(null == source) {
            return null;
        }
        if(null == source.getClass().getClassLoader()) {
            return source;
        }
        if(source instanceof Map) {
            return source;
        }
        if(source instanceof List) {
            return ((List) source).stream().map(item -> getFileds(item)).collect(Collectors.toList());
        }

        Field[] fields = source.getClass().getDeclaredFields();
        Map<String, Object> convert = Arrays.stream(fields).collect(CollectorUtils.toMap(Field::getName, field -> {
            Object res ;
            try {
                field.setAccessible(true);
                res = field.get(source);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return getFileds(res);
        }));
        return convert;
    }

    public static String getFiledsString(Object source) {
        return getFileds(source).toString();
    }

    private static boolean compareBasicClass(Class classA, Class classB) {
        if((classA.equals(Integer.TYPE) || classA.equals(Long.TYPE) || classA.equals(Short.TYPE)) &&
                (classB.equals(Integer.TYPE) || classB.equals(Long.TYPE) || classB.equals(Short.TYPE))) {
            return true;
        } else if((classA.equals(Float.TYPE) || classA.equals(Double.TYPE)) &&
                (classB.equals(Float.TYPE) || classB.equals(Double.TYPE))) {
            return true;
        }

        return false;
    }

    private static Class<?> changeToBasicClass(Object obj) {

        Class<?> clazz = (obj instanceof Class) ? (Class)obj : obj.getClass();

        if (clazz == Integer.class) {
            clazz = Integer.TYPE;
        } else if (clazz == Long.class) {
            clazz = Long.TYPE;
        } else if (clazz == Float.class) {
            clazz = Float.TYPE;
        } else if (clazz == Double.class) {
            clazz = Double.TYPE;
        } else if (clazz == Short.class) {
            clazz = Short.TYPE;
        } else if (clazz == Boolean.class) {
            clazz = Boolean.TYPE;
        } else if (clazz == Character.class) {
            clazz = Character.TYPE;
        } else if (clazz == Byte.class) {
            clazz = Byte.TYPE;
        }

        return clazz;
    }

    private ReflectionUtils() {
        // Utility class
    }
}
