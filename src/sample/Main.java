package sample;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer container = new TextContainer();
        container.setText("Hello, World!");
        final Class<?> cls = TextContainer.class;

        try {
            Field[] fields = cls.getDeclaredFields();
            Method[] methods = cls.getDeclaredMethods();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Annotations.SaveTo.class)) {
                    String path = field.getAnnotation(Annotations.SaveTo.class).path();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Annotations.Saver.class)) {
                            Annotations.Saver saver = method.getAnnotation(Annotations.Saver.class);
                            container.saveTo(path);
                        }
                    }
                }

            }
        } catch (IllegalAccessError e) {
            e.printStackTrace();

        }
    }
}
