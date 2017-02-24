package co.alectronic.aome.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by alec on 24/02/17.
 */
public class PropertyIO {


    public static Map<String,String> getProperties(String file){
        Map<String,String>  map = new LinkedHashMap<String, String>();
        final Properties properties = new Properties();
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(file);
            properties.load(inputStream);

            for(Object k : properties.keySet()) {
                map.put(k.toString(), properties.getProperty(k.toString(), ""));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream!= null){
                try {
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        }



        return map;
    }


    public static boolean storeProperties(String file, String key,String value){
        boolean b = false;
        OutputStream outputStream = null;
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(file));
            properties.setProperty(key,value);
            outputStream = new FileOutputStream(file);
            properties.store(outputStream,null);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                try {
                    b=true;
                    outputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return b;
    }

}
