package co.alectronic.aome.iot.hue;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static co.alectronic.aome.core.Constants.*;
import static co.alectronic.aome.core.Constants.HUE_API_URL;

/**
 * Created by alec on 25/02/17.
 */
public class TestHueLight {

    @Test
    public void chnageLight(){

        Map prop = PropertyIO.getProperties(configFile);
        String hueKey = prop.getOrDefault(HUE_API_KEY,"").toString();
        String hueUrl = prop.getOrDefault(HUE_API_URL,"").toString();


        int i = 0;
        int x = 1000;
        while(i < 65535) {
            HueJsonBody.updateLight(hueUrl,hueKey,"4",true,255,i,255);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i+x;
        }

        while(i > 0) {
            HueJsonBody.updateLight(hueUrl,hueKey,"4",true,255,i,255);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i-x;
        }

        RestClient.put(hueUrl + hueKey + "/lights/4/state", new HashMap<>(), HueJsonBody.lightBody(false));




    }
}
