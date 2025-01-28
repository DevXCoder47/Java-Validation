package com.nikijv.validation.validator;

import com.nikijv.validation.annotation.*;

import java.time.LocalDate;
import java.util.regex.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private List<Object> entities;

    public Validator(List<Object> entities) {
        this.entities = entities;
    }

    public void validateEntities() throws IllegalAccessException {
        for(Object entity : entities) {
            validateEntity(entity);
            System.out.println("\n===============================================================================\n");
        }
    }

    private void validateEntity(Object entity) throws IllegalAccessException {
        System.out.println("Entity: " + entity.getClass().getName());
        List<Field> fields = List.of(entity.getClass().getDeclaredFields());

        for(Field field : fields) {
            field.setAccessible(true);
            StringBuilder status = new StringBuilder("correct");
            validateField(field, entity, status);
            System.out.println("Field: " + field.getName() + ": " + field.get(entity) + ": " + status);
        }
    }

    private void validateField(Field field, Object entity, StringBuilder status) throws IllegalAccessException {
        if(field.isAnnotationPresent(NotNull.class)){
            NotNull annotation = field.getAnnotation(NotNull.class);
            Object value = field.get(entity);
            if(value == null) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }

        if(field.isAnnotationPresent(NotEmpty.class)){
            NotEmpty annotation = field.getAnnotation(NotEmpty.class);
            Object value = field.get(entity);
            if(value.toString().isBlank()) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }

        if(field.isAnnotationPresent(Size.class)){
            Size annotation = field.getAnnotation(Size.class);
            Object value = field.get(entity);
            if((int)value < annotation.min() || (int)value > annotation.max()) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }

        if(field.isAnnotationPresent(Min.class)){
            Min annotation = field.getAnnotation(Min.class);
            Object value = field.get(entity);
            if((int)value < annotation.min()) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }

        if(field.isAnnotationPresent(Max.class)){
            Max annotation = field.getAnnotation(Max.class);
            Object value = field.get(entity);
            if((int)value > annotation.max()) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }

        if(field.isAnnotationPresent(com.nikijv.validation.annotation.Pattern.class)){
            com.nikijv.validation.annotation.Pattern annotation = field.getAnnotation(com.nikijv.validation.annotation.Pattern.class);
            Object value = field.get(entity);
            java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(annotation.pattern());
            Matcher matcher = pattern.matcher(value.toString());
            if(!matcher.find()) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }

        if(field.isAnnotationPresent(Email.class)){
            Email annotation = field.getAnnotation(Email.class);
            Object value = field.get(entity);
            Pattern pattern = Pattern.compile(annotation.pattern());
            Matcher matcher = pattern.matcher(value.toString());
            if(!matcher.find()) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }

        if(field.isAnnotationPresent(Future.class)){
            Future annotation = field.getAnnotation(Future.class);
            Object value = field.get(entity);
            LocalDate date = (LocalDate)value;
            if(!date.isAfter(LocalDate.now())) {
                if(status.toString().equals("correct")) {
                    status.delete(0, status.length());
                }
                status.append(annotation.value()).append("; ");
            }
        }
    }

}
