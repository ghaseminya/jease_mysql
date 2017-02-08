package db.relational;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * Created by mghasemy on 2/7/17.
 */
public class RelationalDatabase {
    public String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/jease?useUnicode=true&characterEncoding=UTF-8";
    Connection conn = null;
    Statement stmt = null;
    final String USER = "root";
    final String PASS = "XXXX";

    public RelationalDatabase() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception s) {
        }
    }

    public <E> List<E> query(String TableN) {
        return null;
    }
    public <E> List<E> query(String TableN, String Query) {
     return null;
    }
    public <E> E query(Object TableN){
        return null;
    }
    public <E> E queryUnique(String TableN, String Query) {

        return null;
    }
    public <E> boolean isUnique(String TableN, String Query) {
        try {
            List<E> result = query(TableN,Query);
            if (result == null) {
                return true;
            }
            if (result.size() == 1 ) {
                return false;
            }
            if (result.size() > 1) {
                return false;
            }
            return true;
        } finally {

        }
    }
    public boolean isStored(String userid) {
        return false;
    }
    public void persist(String Query) {

    }
    public String getBlobDirectory() {
        return null;
    }
}
