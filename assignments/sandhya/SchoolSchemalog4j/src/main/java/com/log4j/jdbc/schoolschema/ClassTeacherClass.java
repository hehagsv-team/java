package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class ClassTeacherClass {
    private ClassTeacherClass() {
        throw new IllegalStateException("Utility class");
    }

    /** Extra javadoc(ignored). */

    private static Logger log = Logger.getLogger(ClassTeacherClass.class);
    /** @return */
    public static String classTeacherSub() {
        String sql = "select t.name,s.name as no_subject\r\n"
                + "from subject s\r\n" + "join teacher t\r\n"
                + "on s.teacher_id=t.id\r\n" + "join class c\r\n"
                + "on c.teacher_id=t.id\r\n" + "where c.name=?\r\n"
                + "group by t.name,s.name\r\n";
        return sql;
    }
    /**
     * this is comment of function.
     * @param sc **this is Scanner**
     * @param conn **this is Connection**
     */
    public static void classTeacherMethod(final Scanner sc,
            final Connection conn) throws SQLException {
        while (true) {
            log.info("\nWhich all subjects does a class teacher teach is");
            Menu.classMenu();
            int ch = sc.nextInt();
            final int k = 12;
            String sql = classTeacherSub();
            PreparedStatement stmt = conn.prepareStatement(sql);
            subClassTeacher(ch, stmt);
            if (ch == k) {
                break;
            }
        }
    }

    private static void subClassTeacher(final int ch,
            final PreparedStatement stmt) throws SQLException {
        ResultSet rs = null;
        final int a = 1;
        final int b = 2;
        final int c = 3;
        final int d = 4;
        final int e = 5;
        final int f = 6;
        final int g = 7;
        final int h = 8;
        final int i = 9;
        final int j = 10;
        switch (ch) {
        case a:
            stmt.setInt(1, f);
            rs = stmt.executeQuery();
            getClassTeacher(rs, f);
            break;
        case b:
            stmt.setInt(1, g);
            rs = stmt.executeQuery();
            getClassTeacher(rs, g);
            break;
        case c:
            stmt.setInt(1, h);
            rs = stmt.executeQuery();
            getClassTeacher(rs, h);
            break;
        case d:
            stmt.setInt(1, i);
            rs = stmt.executeQuery();
            getClassTeacher(rs, i);
            break;
        case e:
            stmt.setInt(1, j);
            rs = stmt.executeQuery();
            getClassTeacher(rs, j);
            System.out.println("null");
            break;
        default:
            break;
        }
    }

    private static void getClassTeacher(final ResultSet rs,
            final int i) throws SQLException {
        log.debug("The class teacher of the class name " + i + " is:");
        while (rs.next()) {
            log.debug("Classteacher name: " + rs.getString("name")
                + ", Subject name: " + rs.getString("no_subject"));

        }
    }
}
