package com.ayush.SpringAopDemo.annotation;

import java.lang.annotation.*;

//Configured annotation

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {
    long warnAfter() default 1500;
    String value() default "";
}
