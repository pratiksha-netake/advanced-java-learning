package util;

import java.io.FileInputStream;
import java.util.Properties;

public class DBConfig {
    public static String URL;
    public static String USER;
    public static String PASS;

    static{
        try{
            Properties props=new Properties();
            FileInputStream fis=new FileInputStream("config.properties");
            props.load(fis);

            URL=props.getProperty("db.url");
            USER=props.getProperty("db.user");
            PASS=props.getProperty("db.password");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
