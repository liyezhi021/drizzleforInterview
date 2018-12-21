package com.example.java.reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DAO<T> {

    private Class<T> clazz;

    public DAO(){
        System.out.println("...->"+ this); //子类
        //Class class1 = this.getClass().getSuperclass(); //当前父类DAO
        Type type = this.getClass().getGenericSuperclass(); //获取带参数的子类
        //注意Type是一个空的接口，这里使用它的子类ParameterizedType，表示带参数的类类型（即泛型）
        if(type instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] args = parameterizedType.getActualTypeArguments();
            if(args!= null && args.length>0){
                Type arg = args[0];
                if(arg instanceof Class)
                    clazz = (Class<T>) arg;
            }
        }
    }

    T get(Integer id){
        return (T) clazz.getName();
    }

    void save(T entity){

    }

}
