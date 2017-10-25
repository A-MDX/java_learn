package com.m2017.october;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 学学 代理模式，以及反射
 * Created by a-mdx on 2017/10/25.
 */
public class Octo25Learn {
    public static void main(String... args){
        Dao dao = new DaoImpl();
        Dao proxyDao = (Dao) Proxy.newProxyInstance(LogInvocationHandler.class.getClassLoader()
                , new Class[]{Dao.class}, new LogInvocationHandler(dao));
        proxyDao.insert();
        System.out.println("----------分割线----------");
        proxyDao.delete();
        System.out.println("----------分割线----------");
        proxyDao.update();
    }
}

class LogInvocationHandler implements InvocationHandler{

    private Object obj;
    LogInvocationHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("insert".equals(methodName) || "update".equals(methodName)){
            System.out.println(methodName + "()方法开始时间：" + System.currentTimeMillis());
            Object result = method.invoke(obj, args);
            System.out.println(methodName + "()方法结束时间：" + System.currentTimeMillis());
            return result;
        }
        return method.invoke(obj, args);
    }
}
interface Dao{
    void insert();
    void update();
    void delete();
}
class DaoImpl implements Dao{
    @Override
    public void insert() {
        System.out.println("DaoImpl.insert()");
    }

    @Override
    public void delete() {
        System.out.println("DaoImpl.delete()");
    }

    @Override
    public void update() {
        System.out.println("DaoImpl.update()");
    }
}
