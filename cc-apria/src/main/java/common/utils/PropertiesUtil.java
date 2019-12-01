package common.utils;

import java.util.Properties;

public class PropertiesUtil {
    private static final Properties pro;

    static {
        pro=new Properties();
        try {
            pro.load(PropertiesUtil.class.getResourceAsStream("/application.properties"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String get(String key) {
        return pro.getProperty(key);
    }

    public static String get(String key, String defaultVal) {
        return pro.getProperty(key, defaultVal);
    }


}
