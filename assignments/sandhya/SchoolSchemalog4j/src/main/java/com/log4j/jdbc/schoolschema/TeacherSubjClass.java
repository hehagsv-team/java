package com.log4j.jdbc.schoolschema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public final class TeacherSubjClass {
    private TeacherSubjClass() {
        throw new IllegalStateException("Utility class");
    }
    /** Extra javadoc(ignored). */
    private static Logger log = Logger.getLogger("TeacherSubjClass");
    /** Extra javadoc(ignored). */
    private static String sql;

    /** @return */
    public static String teacherSubject() {
        sql = "select class,"
                + " Average,teacher "
                + "from(\r\n" + "select s.class_name"
                + " as class,avg(marks) as Average,"
                + "s.name ,t.name as teacher,dense_rank()"
                + "over( partition by s.name order by "
                + "avg(marks) desc) top\r\n" + "from marks m \r\n"
                + " join subject s \r\n" + "on m.subject_id=s.id \r\n"
                + "join teacher t\r\n"
                + "on s.teacher_id=t.id\r\n" + "where s.name=?"
                + "group by s.class_name,s.name,t.name\r\n"
                + ")a where top=1";
        return sql;
    }
    /**
    * this is comment of function.
    * @param sc **this is Scanner**
    * @param conn **this is Connection**
    */
   public static void teacherSubjMethod(final Scanner sc,
           final Connection conn) throws SQLException {
        final int a = 12;
        while (true) {
            log.info("\nWhich teacher teaches a subject better");
            Menu.subjectMenu();
            log.info("12: To return main menu:");
            int ch = sc.nextInt();
            sql = teacherSubject();
            PreparedStatement stmt = conn.prepareStatement(sql);
            getTeacherSubjMethod(ch, stmt);
            if (ch == a) {
                break;
            }
        }
    }

    private static void getTeacherSubjMethod(final int ch,
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
            subTeacherMethod(stmt);
            break;
        case b:
            stmt.setString(1, "CHEMISTRY");
            subTeacherMethod(stmt);
            break;
        case c:
            stmt.setString(1, "BIOLOGY");
            subTeacherMethod(stmt);
            break;
        case d:
            stmt.setString(1, "HISTORY");
            subTeacherMethod(stmt);
            break;
        case e:
            stmt.setString(1, "GEOGRAPHY");
            subTeacherMethod(stmt);
            break;
        case f:
            stmt.setString(1, "POLITICAL SCIENCE");
            subTeacherMethod(stmt);
            break;
        case g:
            stmt.setString(1, "ECONOMICS");
            subTeacherMethod(stmt);
            break;
        case h:
            stmt.setString(1, "ENGLISH");
            subTeacherMethod(stmt);
            break;
        case i:
            stmt.setString(1, "HINDI");
            subTeacherMethod(stmt);
            break;
        case j:
            stmt.setString(1, "MATHS");
            subTeacherMethod(stmt);
            break;
        default:
            break;
        }
    }

    private static void subTeacherMethod(final PreparedStatement stmt)
            throws SQLException {
        ResultSet rs = stmt.executeQuery();
        getTeacherSubject(rs);
    }

    private static void getTeacherSubject(final ResultSet rs)
            throws SQLException {
        log.info("The teacher who teaches the subject better is\n");
        while (rs.next()) {
            log.debug("Class:" + rs.getInt("class") + ","
                    + "Average:" + rs.getInt("Average") + ","
                    + "Teachers-name: "
                    + rs.getString("teacher"));
        }
    }

}
