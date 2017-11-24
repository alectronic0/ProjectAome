package co.alectronic.aome.iot.hue;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static co.alectronic.aome.core.Constants.*;
import static co.alectronic.aome.core.Constants.HUE_API_URL;

/**
 * Created by alec on 25/02/17.
 */
public class TestHueLight {

    @Test
    @Ignore
    public void changeLight(){

        Map<String,String> prop = PropertyIO.getProperties(configFile);
        String hueKey = prop.getOrDefault(HUE_API_KEY, "");

        Random rand = new Random(65535);

        int bri = 255;
        int sat = 255;

        int i = 0;
        int x = 1000;
        while(true) {
            HueJsonBody.updateLight(HUE_API_URL,hueKey,"1",true,bri,rand.nextInt(65535),sat);
            HueJsonBody.updateLight(HUE_API_URL,hueKey,"2",true,bri,rand.nextInt(65535),sat);
            HueJsonBody.updateLight(HUE_API_URL,hueKey,"3",true,bri,rand.nextInt(65535),sat);
//            HueJsonBody.updateLight(HUE_API_URL,hueKey,"4",true,bri ,rand.nextInt(65535),sat);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i+x;
        }
//
//        while(i > 0) {
//            HueJsonBody.updateLight(HUE_API_URL,hueKey,"4",true,255,i,255);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            i = i-x;
//        }
//
//        RestClient.put(HUE_API_URL + hueKey + "/lights/4/state", new HashMap<>(), HueJsonBody.lightBody(false));




    }
}
