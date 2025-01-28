package com.nikijv.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pattern {
    String value() default "The field isn't valid";
    String pattern() default "^[A-ZА-ЯЁ][a-zа-яё]+(?:[-'\\s][A-ZА-ЯЁ][a-zа-яё]+)*$";
}
