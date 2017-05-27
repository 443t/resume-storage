package com.urise.webapp;

import com.urise.webapp.model.Resume;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Field;

/**
 * Created by vp on 20.03.17.
 */
public class MainReflection {
    public static void main(String args[]) throws IllegalAccessException {
        Resume r = new Resume("Name");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(r.toString());
        //TODO : invoke r.toString via reflection
        System.out.println(ToStringBuilder.reflectionToString(r, ToStringStyle.MULTI_LINE_STYLE));


    }
}
