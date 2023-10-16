package com.example.test.model;
import java.lang.reflect.Field;
import java.util.Collection;
import org.owasp.encoder.Encode;
import java.lang.annotation.Annotation;
import java.util.Map;
public class My2Sanatizer {
    public static Object sanitizeObject(Object input) throws Exception {
        Field[] fields = input.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object fieldValue = field.get(input);
            Annotation[] annotations = field.getDeclaredAnnotations();

            if (fieldValue != null) {
                Class<?> fieldType = field.getType();
                if (fieldType == String.class) {
                    String cleanField = sanitizeStringField((String) fieldValue, annotations);
                    field.set(input, cleanField);
                } else if (Collection.class.isAssignableFrom(fieldType)) {
                    Collection<Object> collection = (Collection<Object>) fieldValue;
                    field.set(input, sanitizeCollection(collection));
                } else if (Map.class.isAssignableFrom(fieldType)) {
                    Map<?, ?> map = (Map<?, ?>) fieldValue;
                    field.set(input, sanitizeMap(map));
                } else if (fieldType.getName().startsWith("com.mbusa.ecommerce")) {
                    sanitizeObject(fieldValue);
                }
            }

            field.setAccessible(false);
        }

        return input;
    }

    private static String sanitizeStringField(String value, Annotation[] annotations) {
        // Apply sanitization logic based on the annotations or your custom requirements
        // Example: Sanitize the value using OWASP Encoder's HTML encoding
        return Encode.forHtml(value);
    }

    private static Collection<Object> sanitizeCollection(Collection<Object> collection) throws Exception {
        for (Object item : collection) {
            sanitizeObject(item);
        }
        return collection;
    }

    private static Map<?, ?> sanitizeMap(Map<?, ?> map) throws Exception {
        for (Object key : map.keySet()) {
            Object value = map.get(key);
            sanitizeObject(key);
            sanitizeObject(value);
        }
        return map;
    }
}
