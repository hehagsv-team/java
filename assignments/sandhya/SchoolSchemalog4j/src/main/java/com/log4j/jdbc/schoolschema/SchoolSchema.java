package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class SchoolSchema {
    private SchoolSchema() {
        throw new IllegalStateException("Utility class");
    }
    /**
    *
    * @param args
    */
    public static void main(final String[] args)
            throws SQLException, ClassNotFoundException {
        Logger log = Logger.getLogger(SchoolSchema.class);
        Connection conn = null;
        PreparedStatement stmt = null;
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Scanner sc = new Scanner(System.in);
        final int a = 3;
        final int b = 4;
        final int c = 5;
        final int d = 6;
        final int e = 7;
        final int f = 8;
        final int g = 9;
        final int h = 11;
        while (true) {
            Menu.menu();
            int ch = sc.nextInt();
            switch (ch) {
            case 1:
                TeacherClass.teacherClassMethod(sc, conn);
                break;
            case 2:
                AvgMarkClass.averageMarkClassMethod(sc, conn);
                break;
            case a:
                MarkDistClass.markDistMethod(sc, conn);
                break;
            case b:
                TeacherSubjClass.teacherSubjMethod(sc, conn);
                break;
            case c:
                StudentTopperClass.studentTopperMethod(sc, conn);
                break;
            case d:
                SubjectTopperClass.subjectTopperMethod(sc, conn);
                break;
            case e:
                ClassTeacherClass.classTeacherMethod(sc, conn);
                break;
            case f:
                TeacherSubjectDistClass.subjectDistMethod(sc, conn);
                break;
            case g:
                ClassStrength.classStrengthMethod(sc, conn);
                break;
            default:
                break;
            }
            if (ch == h) {
                log.info("program is ended");
                break;
            }
        }
        stmt.close();
        conn.close();
    }
}
