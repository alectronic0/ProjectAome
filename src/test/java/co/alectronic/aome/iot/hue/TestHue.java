package co.alectronic.aome.iot.hue;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static co.alectronic.aome.core.Constants.HUE_API_KEY;
import static co.alectronic.aome.core.Constants.HUE_API_URL;
import static co.alectronic.aome.core.Constants.configFile;

/**
 * Created by alec on 25/02/17.
 */
public class TestHue {

    @Test
    public void getHueInfo(){
        Map prop = PropertyIO.getProperties(configFile);
        String hueKey = prop.getOrDefault(HUE_API_KEY,"").toString();
        String hueUrl = prop.getOrDefault(HUE_API_URL,"").toString();

        System.out.println(new JSONObject(RestClient.get(hueUrl+hueKey+"/")).toString(4));
    }

}
