package lesson7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void start(Object o) {
        Class claz = o.getClass();
        System.out.println(claz.getName());

        // проверка количества методов с аннотацией BeforeSuite
        Annotation[] bfrSt = claz.getAnnotationsByType(BeforeSuite.class);
        if (bfrSt.length > 1) {
            throw new RuntimeException("methods with BeforeSuite anatation are more then one");
        }

        // проверка количества методов с аннотацией AfterSuite
        Annotation[] aftSt = claz.getAnnotationsByType(AfterSuite.class);
        if (aftSt.length > 1) {
            throw new RuntimeException("methods with AfterSuite anatation are more then one");
        }

        // выполнение метода с аннотацией BeforeSuite
        Method[] methods = claz.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                try {
                    m.invoke(o);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // выполнение методов с аннотацией MyTest
        // вариант 1
        List<Method> testMethods = new ArrayList<>();
        MyTest myTstAnatation;
        int mostPriority = 1;

        for (Method m : methods) {
            if (m.getAnnotation(MyTest.class) != null) {
                testMethods.add(m);
            }
        }

        while (mostPriority <= testMethods.size()) {
            for (int i = 0; i < testMethods.size(); i++) {
                myTstAnatation = testMethods.get(i).getAnnotation(MyTest.class);
                if (myTstAnatation.priority() == mostPriority) {
                    try {
                        testMethods.get(i).invoke(o);
                        mostPriority++;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        // выполнение метода с аннотацией AfterSuite
        for (Method m : methods) {
            if (m.getAnnotation(AfterSuite.class) != null) {
                try {
                    m.invoke(o);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}