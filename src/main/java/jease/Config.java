package jease;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Created by ghaseminya on 5/30/18.
 */
public class Config {
    public jease.Properties load(){
        Properties prop = new Properties();
        InputStream input = null;
        jease.Properties p=null;
        try {

            String filename = "config.properties";
            input = Config.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            p=new jease.Properties();
            p.setDbjdbcdriver(prop.getProperty("dbjdbcdriver"));
            p.setDburl(prop.getProperty("dburl"));
            p.setDbusermame(prop.getProperty("dbusername"));
            p.setDbpassword(prop.getProperty("dbpassword"));
            p.setEmaildomain(prop.getProperty("emaildomain"));
            p.setEmailuser(prop.getProperty("emailusername"));
            p.setEmailpass(prop.getProperty("emailpassword"));

            p.setSitetitle(prop.getProperty("sitetitle"));
            p.setSiteminititle(prop.getProperty("siteminititle"));
            p.setSiteseokeys(prop.getProperty("siteseokeys"));
            p.setSiteseodesc(prop.getProperty("siteseodesc"));
            p.setSitelogo(prop.getProperty("sitelogo"));


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return p;
    }
}
