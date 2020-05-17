package main.org.hcl.harika;


public class Employee {
    /** javadoc (ignored). */
    public String id;
    /** javadoc (ignored). */
    public String firstName;
    /** javadoc (ignored). */
    public String lastName;
    /** javadoc (ignored). */
    public String location;
    /** javadoc (ignored). */
    @Override
    public String toString() {
        return firstName + " " + lastName + "(" + id + ")" + location;

    }
}
