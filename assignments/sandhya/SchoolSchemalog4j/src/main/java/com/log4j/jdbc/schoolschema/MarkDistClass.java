package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class MarkDistClass {
    private MarkDistClass() {
        throw new IllegalStateException("Utility class");
    }
    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger("MarkDistClass");
    /** @return */
    public static String markDistClass() {
        String sql = "select count(*),\r\n"
                + "(case \r\n" + "when marks between 50 and 59 then '50-59'\r\n"
                + "when marks between 60 and 69 then '60-69'\r\n"
                + "when marks between 70 and 79 then '70-79'\n"
                + "when marks between 80 and 89 then '80-89'\n"
                + "else 'above 90'\r\n" + "end)marks\r\n"
                + "from marks m\r\n" + "join subject s\r\n"
                + "on m.subject_id=s.id\r\n" + "where name=?"
                + "group by marks";
        return sql;
    }

    /**
     * this is comment of function.
     *
     * @param sc   **this is Scanner**
     * @param conn **this is Connection**
     */
    public static void markDistMethod(final Scanner sc,
            final Connection conn) throws SQLException {
        while (true) {
            log.info("\nMark distribution for each subject ");
            Menu.subjectMenu();
            log.info("12: To return main menu:");
            int ch = sc.nextInt();
            final int k = 12;
            String sql = markDistClass();
            PreparedStatement stmt = conn.prepareStatement(sql);
            subMarkDistMethod(ch, stmt);
            if (ch == k) {
                break;
            }
        }
    }

    private static void subMarkDistMethod(final int ch,
            final PreparedStatement stmt) throws SQLException {
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
            stmt.setString(1, "PHYSICS");
            markDistSubj(stmt);
            break;
        case b:
            stmt.setString(1, "CHEMISTRY");
            markDistSubj(stmt);
            break;
        case c:
            stmt.setString(1, "BIOLOGY");
            markDistSubj(stmt);
            break;
        case d:
            stmt.setString(1, "HISTORY");
            markDistSubj(stmt);
            break;
        case e:
            stmt.setString(1, "GEOGRAPHY");
            markDistSubj(stmt);
            break;
        case f:
            stmt.setString(1, "POLITICAL SCIENCE");
            markDistSubj(stmt);
            break;
        case g:
            stmt.setString(1, "ECONOMICS");
            markDistSubj(stmt);
            break;
        case h:
            stmt.setString(1, "ENGLISH");
            markDistSubj(stmt);
            break;
        case i:
            stmt.setString(1, "HINDI");
            markDistSubj(stmt);
            break;
        case j:
            stmt.setString(1, "MATHS");
            markDistSubj(stmt);
            break;
        default:
            break;
        }
    }

    private static void markDistSubj(final PreparedStatement stmt)
            throws SQLException {
        ResultSet rs = null;
        rs = stmt.executeQuery();
        getMarkDist(rs);

    }

    private static void getMarkDist(final ResultSet rs)
            throws SQLException {
        log.info("The mark distribution of a subject  is\n");
        while (rs.next()) {
            log.debug("Count:" + rs.getInt("count(*)")
                + " ," + "Marks-range:" + rs.getString("marks"));
        }
    }
}
