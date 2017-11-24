package co.alectronic.aome.iot.hue;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static co.alectronic.aome.core.Constants.HUE_API_KEY;
import static co.alectronic.aome.core.Constants.HUE_API_URL;
import static co.alectronic.aome.core.Constants.configFile;


public class TestHue {

    @Test
    @Ignore
    public void getHueInfo(){
        Map<String,String> prop = PropertyIO.getProperties(configFile);
        String hueKey = prop.getOrDefault(HUE_API_KEY, "");

        System.out.println(RestClient.get(HUE_API_URL+hueKey+"/"));
    }

}
