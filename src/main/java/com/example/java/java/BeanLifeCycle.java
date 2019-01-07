package com.example.java.java;

import com.example.entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

    public static void main(String[] args){
        ApplicationContext factory = new ClassPathXmlApplicationContext
                ("classpath:/config/beans.xml ");
        System.out.println("容器初始化成功");
        Book book = factory.getBean("book", Book.class);
        System.out.println("bookName is: "+book.getBookName());

        System.out.println("现在开始关闭容器.");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
