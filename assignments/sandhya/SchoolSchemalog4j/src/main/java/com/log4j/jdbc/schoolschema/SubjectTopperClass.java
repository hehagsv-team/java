package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class SubjectTopperClass {
    private SubjectTopperClass() {
        throw new IllegalStateException("Utility class");
    }
    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger("StudentTopperClass");
    /** Extra javadoc(ignored). */
    private static String sql;
    /** @return */
    public static String subjectTopper() {
         sql = "select subjectName,name,marks from(\r\n"
                + "select  c.name as ClassName,s.name as subjectName,"
                + "t.name as name,marks, dense_rank() over( partition "
                + "by s.name order by marks desc) Topper\r\n"
                + "from marks m\r\n" + "join subject s\r\n"
                + "on m.subject_id=s.id\r\n" + "join class c\r\n"
                + "on s.class_name=c.name\r\n" + "join student t\r\n"
                + "on t.id=m.student_id\r\n"
                + "where c.name=? and s.name=?)a  where topper=1";
         return sql;
    }
    /**
     * this is comment of function.
     * @param sc **this is Scanner**
     * @param conn **this is Connection**
     */
    public static void subjectTopperMethod(final Scanner sc,
            final Connection conn)  throws SQLException {
        final int k = 12;
        while (true) {
            log.info("\nTopper student in each subject for each class");
            Menu.classMenu();
            sql = subjectTopper();
            PreparedStatement stmt = conn.prepareStatement(sql);
            int ch = subReturnMethod(sc);
            if (ch == k) {
                break;
            }
            subTopperMethod(stmt, sc);
        }

    }

    private static void subTopperMethod(
            final PreparedStatement stmt, final Scanner sc)
                    throws SQLException {
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
        final int k = 12;
        int ch = sc.nextInt();
        switch (ch) {
        case a:
            while (true) {
                subjectMethod();
                ch = subReturnMethod(sc);
                stmt.setInt(1, f);
                subjectTopper(stmt, ch);
                if (ch == k) {
                    break;
                }
            }
            break;
        case b:
            while (true) {
                subjectMethod();
                ch = subReturnMethod(sc);
                stmt.setInt(1, g);
                subjectTopper(stmt, ch);
                if (ch == k) {
                    break;
                }
            }
            break;
        case c:
            while (true) {
                subjectMethod();
                ch = subReturnMethod(sc);
                stmt.setInt(1, h);
                subjectTopper(stmt, ch);
                if (ch == k) {
                    break;
                }
            }
            break;
        case d:
            while (true) {
                subjectMethod();
                ch = subReturnMethod(sc);
                stmt.setInt(1, i);
                subjectTopper(stmt, ch);
                if (ch == k) {
                    break;
                }
            }
            break;
        case e:
            while (true) {
                subjectMethod();
                ch = subReturnMethod(sc);
                stmt.setInt(1, j);
                subjectTopper(stmt, ch);
                if (ch == k) {
                    break;
                }
            }
            break;
        default:
            break;
        }
    }

    private static void subjectMethod() {
        Menu.subjectMenu();
        log.info("12: To return main menu:");
    }
    private static int subReturnMethod(final Scanner sc) {
        int ch = sc.nextInt();
        return ch;
    }

    private static void subjectTopper(final PreparedStatement stmt,
            final int ch) throws SQLException {
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
            stmt.setString(2, "PHYSICS");
            getSubjectTopper(stmt);
            break;
        case b:
            stmt.setString(2, "CHEMISTRY");
            getSubjectTopper(stmt);
            break;
        case c:
            stmt.setString(2, "BIOLOGY");
            getSubjectTopper(stmt);
            break;
        case d:
            stmt.setString(2, "HISTORY");
            getSubjectTopper(stmt);
            break;
        case e:
            stmt.setString(2, "GEOGRAPHY");
            getSubjectTopper(stmt);
            break;
        case f:
            stmt.setString(2, "POLITICAL SCIENCE");
            getSubjectTopper(stmt);
            break;
        case g:
            stmt.setString(2, "ECONOMICS");
            getSubjectTopper(stmt);
            break;
        case h:
            stmt.setString(2, "ENGLISH");
            getSubjectTopper(stmt);
            break;
        case i:
            stmt.setString(2, "HINDI");
            getSubjectTopper(stmt);
            break;
        case j:
            stmt.setString(2, "MATHS");
            getSubjectTopper(stmt);
            break;
        default:
            break;
        }
    }

    private static void getSubjectTopper(final PreparedStatement stmt)
            throws SQLException {
        ResultSet rs = stmt.executeQuery();
        getSubjectTopperClass(rs);
    }

    private static void getSubjectTopperClass(final ResultSet rs)
            throws SQLException {
        log.info("The topper in the subject  is:");
        while (rs.next()) {
            log.debug("Subject name: " + rs.getString("subjectName")
            + ", Student name: " + rs.getString("name")
                    + ", Marks: " + rs.getInt("marks"));

        }
    }

}
