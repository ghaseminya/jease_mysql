package db.relational;

import jease.Properties;
import jease.cmf.web.JeaseSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * Created by mghasemy on 2/7/17.
 */
public class RelationalDatabase {
    public String JDBC_DRIVER = "";
    public String DB_URL = "";
    public String USER = "";
    public String PASS = "";


    Connection conn = null;
    Statement stmt = null;

    public RelationalDatabase() {
        try {
            Properties p=(Properties)JeaseSession.get("Properties");
            JDBC_DRIVER=p.getDbjdbcdriver();
            DB_URL=p.getDburl();
            USER=p.getDbusermame();
            PASS=p.getDbpassword();
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
