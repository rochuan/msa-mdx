package com.mdx;

import sun.misc.Cleaner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        final List<String> list = new ArrayList<>();

        list.add("abc");
        list.add("bcd");


        System.out.printf(list.toString());

//        try {
//            Class<?> user = Class.forName("com.mdx.User");
//
//            Field[] fields = user.getFields();
//
//            for (Field field : fields) {
//                System.out.printf("Feild:" + field.getName());
//            }
//            ;
//
//            Method[] methods = user.getMethods();
//
//            for (Method method:methods){
//                System.out.printf("method:" + method.getName() + "\n");
//
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}

