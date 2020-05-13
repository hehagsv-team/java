package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

final class StudentTopperClass {
    private StudentTopperClass() {
        throw new IllegalStateException("Utility class");
    }
    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger("StudentTopperClass");
    /** @return */
    public static String classTopper() {
        String sql = "select StudentName,marks from(\r\n"
                + "select  c.name as ClassName,s.name as StudentName,"
                + "sum(marks) as marks, dense_rank() "
                + "over( partition by c.name order by sum(marks) desc) "
                + "Topper\r\n"
                + "from marks m\r\n" + "join student s\r\n"
                + "on m.student_id=s.id\r\n" + "join class c\r\n"
                + "on s.class_name=c.name\r\n" + "where c.name=?\r\n"
                + "group by c.name,s.name)a  where topper=1\r\n"
                + "\r\n";
        return sql;
    }
    /**
     * this is comment of function.
     * @param sc **this is Scanner**
     * @param conn **this is Connection**
     */
    public static void studentTopperMethod(final Scanner sc,
            final Connection conn) throws SQLException {
        while (true) {
            log.info("\nTopper student in each class");
            Menu.classMenu();
            int ch = sc.nextInt();
            final int k = 12;
            String sql = classTopper();
            PreparedStatement stmt = conn.prepareStatement(sql);
            subStudentMethod(stmt, ch);
            if (ch == k) {
                break;
            }
        }

    }

    private static void subStudentMethod(final PreparedStatement stmt,
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
            getClassTopper(rs, f);
            break;
        case b:
            stmt.setInt(1, g);
            rs = stmt.executeQuery();
            getClassTopper(rs, g);
            break;
        case c:
            stmt.setInt(1, h);
            rs = stmt.executeQuery();
            getClassTopper(rs, h);
            break;
        case d:
            stmt.setInt(1, i);
            rs = stmt.executeQuery();
            getClassTopper(rs, i);
            break;
        case e:
            stmt.setInt(1, j);
            rs = stmt.executeQuery();
            getClassTopper(rs, j);
            break;
        default:
            break;
        }
    }

    private static void getClassTopper(final ResultSet rs,
            final int i) throws SQLException {
        log.debug("The topper in the class name " + i + " is:");
        while (rs.next()) {
            log.debug("Student name: " + rs.getString("StudentName")
                + ", Marks: " + rs.getInt("marks"));
        }
    }
}
