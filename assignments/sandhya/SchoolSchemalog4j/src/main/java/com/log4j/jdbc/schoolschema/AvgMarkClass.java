package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class AvgMarkClass {
    private AvgMarkClass() {
        throw new IllegalStateException("Utility class");
    }

    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger(AvgMarkClass.class);
    /** @return */
    public static String averageMarks() {
        String sql = "select avg(marks) as Average\r\n"
                + "from marks m\r\n" + "join subject s\r\n"
                + "on m.subject_id=s.id\r\n"
                + "where s.class_name=?";
        return sql;
    }
    /**
     * this is comment of function.
     * @param sc **this is Scanner**
     * @param conn **this is Connection**
     */
    public static void averageMarkClassMethod(final Scanner sc,
            final Connection conn) throws SQLException {
        while (true) {
            log.info("\nAverage marks in each class:");
            Menu.classMenu();
            final int a = 12;
            int ch = sc.nextInt();
            String sql = averageMarks();
            PreparedStatement stmt = conn.prepareStatement(sql);
            subAvgMarksMethod(ch, stmt);
            if (ch == a) {
                break;
            }
        }

    }

    private static void subAvgMarksMethod(final int ch,
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
            getAverageMarks(rs, f);
            break;
        case b:
            stmt.setInt(1, g);
            rs = stmt.executeQuery();
            getAverageMarks(rs, g);
            break;
        case c:
            stmt.setInt(1, h);
            rs = stmt.executeQuery();
            getAverageMarks(rs, h);
            break;
        case d:
            stmt.setInt(1, i);
            rs = stmt.executeQuery();
            getAverageMarks(rs, i);
            break;
        case e:
            stmt.setInt(1, j);
            rs = stmt.executeQuery();
            getAverageMarks(rs, j);
            break;
        default:
            break;
        }
    }

    private static void getAverageMarks(final ResultSet rs,
            final int i) throws SQLException {
        while (rs.next()) {
            log.debug("Average marks in class " + i
                    + " is: " + rs.getInt("Average") + "\n");
        }
    }

}
