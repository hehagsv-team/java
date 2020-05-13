package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class TeacherClass {
    private TeacherClass() {
        throw new IllegalStateException("Utility class");
    }

    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger("TeacherClass");

    /** @return */
    public static String teacherClass() {
        String sql = "select t.name\r\n"
                + "from class c\r\n"
                + "join teacher t\r\n"
                + "on t.id=c.teacher_id\r\n"
                + "where c.name=?";
        return sql;
    }

    /**
     * this is comment of function.
     *
     * @param sc   **this is Scanner**
     * @param conn **this is Connection**
     */
    public static void teacherClassMethod(final Scanner sc,
            final Connection conn) throws SQLException {
        while (true) {
            log.info("\nName of the teacher in  particular class is: ");
            Menu.classMenu();
            int ch = sc.nextInt();
            final int k = 12;
            String sql = teacherClass();
            PreparedStatement stmt = conn.prepareStatement(sql);
            subTeacherClassMethod(ch, stmt);
            if (ch == k) {
                break;
            }
        }
    }

    private static void subTeacherClassMethod(final int ch,
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
            getTeacherClass(rs, f);
            break;
        case b:
            stmt.setInt(1, g);
            rs = stmt.executeQuery();
            getTeacherClass(rs, g);
            break;
        case c:
            stmt.setInt(1, h);
            rs = stmt.executeQuery();
            getTeacherClass(rs, h);
            break;
        case d:
            stmt.setInt(1, i);
            rs = stmt.executeQuery();
            getTeacherClass(rs, i);
            break;
        case e:
            stmt.setInt(1, j);
            rs = stmt.executeQuery();
            getTeacherClass(rs, j);
            break;
        default:
            break;
        }
    }

    private static void getTeacherClass(final ResultSet rs,
            final int i) throws SQLException {
        while (rs.next()) {
            log.debug("The name of the teacher in the particular class "
                    + i + " is: " + rs.getString("name") + "\n");
        }

    }
}
