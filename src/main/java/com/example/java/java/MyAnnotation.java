package com.example.java.java;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotation {

    String name() default "default";

    String email() default "default@163.com";
}
