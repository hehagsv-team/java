package org.hcl.harika.ivokemethod;

public class ReflectionClass {
//    private field
    /** javadoc (ignored). */
    private String s;

//    public method with no arguments
    /** javadoc (ignored). */
    public final void method1() {
        System.out.println("The string is " + s);
    }

//    public method with int as argument
    /**
     * javadoc (ignored).
     *
     * @param n
     *
     */
    public final void method2(final int n) {
        System.out.println("The number is " + n);
    }

//    private method
    private void method3() {
        System.out.println("Private method invoked");
    }
}

