package com.spring.oa.action;

import java.lang.reflect.ParameterizedType;

/**
 * Created by burning-.- on 2015/6/27.
 */
public class GenericClass {
    public static Class<?> getGenericClass(Class clazz){
        ParameterizedType type=(ParameterizedType)clazz.getGenericSuperclass();
        Class<?> entityClass=(Class<?>) type.getActualTypeArguments()[0];
        return entityClass;
    }
}
