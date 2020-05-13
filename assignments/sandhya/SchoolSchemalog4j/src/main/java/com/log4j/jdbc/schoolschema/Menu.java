package com.log4j.jdbc.schoolschema;

import org.apache.log4j.Logger;

public final class Menu {
    private Menu() {
        throw new IllegalStateException("Utility class");
    }

    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger("MarkDistClass");
    /** Extra javadoc(ignored). */
    public static void classMenu() {
        log.info("Enter the class name you need:");
        log.info("1: class name 6: ");
        log.info("2: class name 7: ");
        log.info("3: class name 8: ");
        log.info("4: class name 9: ");
        log.info("5: class name 10: ");
        log.info("12: To return main menu:");
    }
    /** Extra javadoc(ignored). */
    public static void menu() {
        log.info("\nThe menu options are: ");
        log.info("1: Name of the teacher in  particular class is: ");
        log.info("2: Average marks in each class:");
        log.info("3: Mark distribution for each subject ");
        log.info("4: Which teacher teaches a subject better");
        log.info("5: Topper student in each class");
        log.info("6: Topper student in each subject for each class");
        log.info("7: Which all subjects does a class teacher teach");
        log.info("8: Teacher to subject distribution");
        log.info("9: Class strength");
        log.info("11: To end the program:");
    }
    /** Extra javadoc(ignored). */
    public static void subjectMenu() {
        log.info("\nEnter the subject you need:");
        log.info("1: PHYSICS");
        log.info("2: CHEMISTRY");
        log.info("3: BIOLOGY");
        log.info("4: HISTORY");
        log.info("5: GEOGRAPHY");
        log.info("6: POLITICAL SCIENCE");
        log.info("7: ECONOMICS");
        log.info("8: ENGLISH");
        log.info("9: HINDI");
        log.info("10: MATHS");
    }
}
