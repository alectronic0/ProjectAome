package co.alectronic.aome;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static co.alectronic.aome.core.Constants.*;
import static co.alectronic.aome.nest.NestJsonBody.tempBody;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import co.alectronic.aome.nest.NestJsonBody;


public class main {

    // You will need to create this file
    public final static String configFile = "src/main/resources/settings.cfg";

    @Test
    public void test(){

        Map prop = PropertyIO.getProperties(configFile);
        String nestKey = prop.getOrDefault(NEST_API_KEY,"").toString();
        String nestUrl = prop.getOrDefault(NEST_API_URL,"").toString();

        String hueKey = prop.getOrDefault(HUE_API_KEY,"").toString();
        String hueUrl = prop.getOrDefault(HUE_API_URL,"").toString();

//        System.out.println(RestClient.get(hueUrl+hueKey));

        System.out.println(RestClient.get(nestUrl, NestJsonBody.getAuthHeader(nestKey)));

//      SET TEMP
//        System.out.println(RestClient.put(nestUrl, NestJsonBody.getAuthHeader(nestKey),tempBody(prop.getOrDefault("nest.device.thermo.1","").toString(),20)));
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(put(nestUrl, new HashMap<String, Object>() {{put("Authorization","Bearer "+ nestKey);}},tempBody(18)));
//

    }












}
