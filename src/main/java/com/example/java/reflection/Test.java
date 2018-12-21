package com.example.java.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test {

    @SuppressWarnings("unchecked")
    public static Class getSuperClassGenericType(Class clazz, int index){
        // getGenericSuperClass: 获取带泛型参数的父类, 返回值为: DAO<Book>
        //注意Type是一个空的接口，这里使用它的子类ParameterizedType，表示带参数的类类型（即泛型）
        //可以调用 ParameterizedType 的 Type[] getActualTypeArguments() 获取泛型参数的数组.
        Type type = clazz.getGenericSuperclass();
        if(!(type instanceof ParameterizedType)) return null;
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] args = parameterizedType.getActualTypeArguments();
        if(args ==null) return null;
        if(index<0 || index>args.length-1){
            return  null;
        }
        Type arg = args[index];
        if(arg instanceof Class) return (Class) arg;

        return null;
    }

    @SuppressWarnings("unchecked")
    public static Class getSuperClassGenericType(Class clazz){
        return getSuperClassGenericType(clazz, 0);
    }

    public static void main1(String[] args){
        Class clazz = LibraryDAO.class;
        Class argClazz = getSuperClassGenericType(clazz, 0);
        System.out.println(argClazz);
    }

    public static void main(String[] args){
        LibraryDAO libraryDAO = new LibraryDAO();
        System.out.println(libraryDAO.get(1));

    }

}
