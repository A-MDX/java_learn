package com.annotation.anno;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 这个就是为了让注解产生效果
 * 注入
 * Created by A-mdx on 2016/11/21.
 */
public class AnnoInjection {
    
    public static Object getBean(Object obj){
        try {
            // 获得类属性
            Field[] fs = obj.getClass().getDeclaredFields();

            for (Field ff : fs){
                //获得属性上的注解
                Seven s = ff.getAnnotation(Seven.class);
                if (s != null){
                    System.err.println("注入："+ff.getName()+"； 属性: "+s.value());
                    
                    // 反射调用 public set方法，如果如果为访问级别private,那么可以直接使用属性的set(obj,
                    // value);
                    obj.getClass().getMethod("set"+ff.getName().substring(0,1).toUpperCase()+ff.getName().substring(1),new Class[]{String.class}).invoke(obj,s.value());
                    
                }
                
            }
            Method[] ms = obj.getClass().getDeclaredMethods();
            for (Method m : ms){
                
                // 获得方法注解
                Seven s = m.getAnnotation(Seven.class);
                if (s != null){
                    System.err.println("注入 -> "+m.getName()+";方法 -> "+s.Property());
                    m.invoke(obj,s.Property());
                }
                
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        
        return obj;
    }
    
    
    
}
