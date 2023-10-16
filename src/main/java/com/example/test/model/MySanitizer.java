package com.example.test.model;
import java.lang.reflect.Field;
import java.util.Collection;


import org.owasp.esapi.ESAPI;
public class MySanitizer {

    public static Object sanitizeObject(Object input) throws IllegalAccessException {
        Field[] fields = input.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            Object fieldValue = field.get(input);

            if (fieldValue != null) {
                if (fieldType == String.class) {
                    String originalFieldValue = String.valueOf(fieldValue);
                    field.set(input, ESAPI.encoder().encodeForHTML(originalFieldValue));
                } else if (Collection.class.isAssignableFrom(fieldType)) {
                    Collection<?> collection = (Collection<?>) fieldValue;
                    for (Object collectionItem : collection) {
                        sanitizeObject(collectionItem);
                    }
                } else if (fieldType.getName().contains("com.example.test")) {
                    sanitizeObject(fieldValue);
                }
            }
        }

        return input;
    }

}
