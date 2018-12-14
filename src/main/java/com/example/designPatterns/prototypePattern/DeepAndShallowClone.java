package com.example.designPatterns.prototypePattern;


import com.example.entity.Address;

import java.io.*;

/**
* 浅复制：将一个对象复制后，基本数据类型的变量都会重新创建，而引用类型，指向的还是原对象所指向的。
 *
 * 深复制：将一个对象复制后，不论是基本数据类型还有引用类型，都是重新创建的。简单来说，就是深复制进行了完全彻底的复制，而浅复制不彻底。
*
* */

public class DeepAndShallowClone implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String str;

    private SerializableObject obj;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

    //浅复制
    public Object clone(Address add) throws CloneNotSupportedException{
        Prototype prototype = (Prototype) super.clone();
        return prototype;
    }

    //深复制
    public Object deepClone(Address add) throws IOException, ClassNotFoundException{
        //写入当前对象二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(add);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }


    class SerializableObject implements Serializable{
        private static final long serialVersionUID = 1L;
    }

}
