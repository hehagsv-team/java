package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public final class ClassStrength {
    private ClassStrength() {
        throw new IllegalStateException("Utility class");
    }

    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger("ClassStrength");
    /** @return */
    public static String classStrength() {
        String sql = "select count(*)\r\n"
                + "from student s\r\n"
                + "join class c\r\n"
                + "on s.class_name=c.name\r\n"
                + "where c.name=?\r\n";
        return sql;
    }
    /**
     * this is comment of function.
     * @param sc **this is Scanner**
     * @param conn **this is Connection**
     */
    public static void classStrengthMethod(final Scanner sc,
            final  Connection conn) throws SQLException {
        while (true) {
            log.info("\nClass strength");
            Menu.classMenu();
            int ch = sc.nextInt();
            final int k = 12;
            String sql = classStrength();
            PreparedStatement stmt = conn.prepareStatement(sql);
            subClassMethod(stmt, ch);
            if (ch == k) {
                break;
            }
        }
    }

    private static void subClassMethod(final PreparedStatement stmt,
            final int ch) throws SQLException {
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
            getClassStrength(rs, f);
            break;
        case b:
            stmt.setInt(1, g);
            rs = stmt.executeQuery();
            getClassStrength(rs, g);
            break;
        case c:
            stmt.setInt(1, h);
            rs = stmt.executeQuery();
            getClassStrength(rs, h);
            break;
        case d:
            stmt.setInt(1, i);
            rs = stmt.executeQuery();
            getClassStrength(rs, i);
            break;
        case e:
            stmt.setInt(1, j);
            rs = stmt.executeQuery();
            getClassStrength(rs, j);
            break;
        default:
            break;
        }

    }

    private static void getClassStrength(final ResultSet rs,
            final int i) throws SQLException {
        while (rs.next()) {
            log.debug("The strength of the class " + i
                    + " is " + rs.getInt("count(*)") + "\n");
        }
    }
}
