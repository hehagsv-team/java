package invokemethods;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class InvokeMethod {
    private InvokeMethod() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * javadoc (ignored).
     *
     * @param args
     *
     */
    public static void main(final String[] args) throws Exception {
        // Creating object whose property is to be checked
        ReflectionClass obj = new ReflectionClass();

        Class cls = obj.getClass();
        System.out.println("The name of class is " + cls.getName());

        // creates object of desired method by providing the
        // method name and parameter class as arguments to
        // the getDeclaredMethod
        Method methodcall1 = cls.getDeclaredMethod("method2", int.class);
        final int a = 19;
        methodcall1.invoke(obj, a);

        // creates object of the desired field by providing
        // the name of field as argument to the
        // getDeclaredField method
        Field field = cls.getDeclaredField("s");

        // allows the object to access the field irrespective
        // of the access specifier used with the field
        field.setAccessible(true);

        // takes object and the new value to be assigned
        // to the field as arguments
        field.set(obj, "JAVA");

        // Creates object of desired method by providing the
        // method name as argument to the getDeclaredMethod
        Method methodcall2 = cls.getDeclaredMethod("method1");
        methodcall2.invoke(obj);

        // Creates object of the desired method by providing
        // the name of method as argument to the
        // getDeclaredMethod method
        Method methodcall3 = cls.getDeclaredMethod("method3");
        methodcall3.setAccessible(true);
        methodcall3.invoke(obj);
    }
}
