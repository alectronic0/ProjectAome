package co.alectronic.aome;

import co.alectronic.aome.hue.HueJsonBody;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static co.alectronic.aome.core.Constants.*;
import static co.alectronic.aome.nest.NestJsonBody.tempBody;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import co.alectronic.aome.nest.NestJsonBody;


public class main {

    @Test
    public void test(){

        Map prop = PropertyIO.getProperties(configFile);
        String nestKey = prop.getOrDefault(NEST_API_KEY,"").toString();
        String nestUrl = prop.getOrDefault(NEST_API_URL,"").toString();

        String hueKey = prop.getOrDefault(HUE_API_KEY,"").toString();
        String hueUrl = prop.getOrDefault(HUE_API_URL,"").toString();

//        System.out.println(RestClient.get(hueUrl+hueKey+"/lights/4"));

        System.out.println(RestClient.get("https://www.meethue.com/api/nupnp"));//detect Bridge

//        System.out.println(RestClient.get(nestUrl, NestJsonBody.getAuthHeader(nestKey)));

//      SET TEMP
//        System.out.println(RestClient.put(nestUrl, NestJsonBody.getAuthHeader(nestKey),tempBody(prop.getOrDefault("nest.device.thermo.1","").toString(),19)));
        int i = 0;
        int x = 1000;
        while(i < 65535) {
            RestClient.put(hueUrl + hueKey + "/lights/4/state", new HashMap<>(), HueJsonBody.lightBody(true, 255, i, 255));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i+x;
        }

        while(i > 0) {
            RestClient.put(hueUrl + hueKey + "/lights/4/state", new HashMap<>(), HueJsonBody.lightBody(true, 255, i, 255));
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
