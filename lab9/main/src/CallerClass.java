import java.lang.reflect.Method;

public class CallerClass {

    public static void main(String[] args) {
        TargetClass target = new TargetClass();

        Method[] methods = target.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                int repeatCount = annotation.value();

                if (isProtectedOrPrivate(method)) {
                    try {
                        method.setAccessible(true);

                        Object[] argsForMethod = getSampleArgs(method);

                        System.out.println("\nВызов метода: " + method.getName() + " (" + repeatCount + " раз)");

                        for (int i = 0; i < repeatCount; i++) {
                            method.invoke(target, argsForMethod);
                        }

                    } catch (Exception e) {
                        System.err.println("Ошибка при вызове метода " + method.getName() + ": " + e.getMessage());
                    }
                }
            }
        }
    }

    private static boolean isProtectedOrPrivate(Method method) {
        int modifiers = method.getModifiers();
        return (modifiers & java.lang.reflect.Modifier.PROTECTED) != 0 ||
           (modifiers & java.lang.reflect.Modifier.PRIVATE) != 0;
    }

    private static Object[] getSampleArgs(Method method) {
        Class<?>[] paramTypes = method.getParameterTypes();
        Object[] args = new Object[paramTypes.length];

        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> type = paramTypes[i];
            if (type == String.class) {
                args[i] = "Тестовая строка";
            } else if (type == int.class) {
                args[i] = 42;
            } else if (type == double.class) {
                args[i] = 3.14;
            } else if (type == boolean.class) {
                args[i] = true;
            } else if (type == char.class) {
                args[i] = 'A';
            } else {
                args[i] = null;
            }
        }

        return args;
    }
}