package jfix.db4o.engine;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Collection;

/**
 * Created by mghasemy on 2/7/17.
 */
public class PersistenceEngineMysql implements PersistenceEngine {

    public String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/jease?useUnicode=true&characterEncoding=UTF-8";
    Connection conn = null;
    Statement stmt = null;
    final String USER = "root";
    final String PASS = "XXXX";

    public PersistenceEngineMysql(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception s) {
        }
    }

    @Override
    public void open(String database) {
        //initDirectory(database);
        //openEngine();
    }
    protected void initDirectory(String database) {


    }

    //protected void openEngine() {
    //    db = Db4oEmbedded.openFile(newConfiguration(), filename);
    //}


    @Override
    public void close() {

    }

    @Override
    public void backup() {

    }

    @Override
    public void save(Object object) {

    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public void begin() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public Collection<Object> query() {
        return null;
    }

    @Override
    public String getBlobDirectory() {
        return null;
    }
}
