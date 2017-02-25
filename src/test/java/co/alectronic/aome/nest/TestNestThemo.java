package co.alectronic.aome.nest;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static co.alectronic.aome.core.Constants.NEST_API_KEY;
import static co.alectronic.aome.core.Constants.NEST_API_URL;
import static co.alectronic.aome.core.Constants.configFile;

/**
 * Created by alec on 25/02/17.
 */
public class TestNestThemo {

    @Test
    public void changeTemp(){
        Map prop = PropertyIO.getProperties(configFile);
        String nestKey = prop.getOrDefault(NEST_API_KEY,"").toString();
        String nestUrl = prop.getOrDefault(NEST_API_URL,"").toString();

//      SET TEMP
//        System.out.println(RestClient.put(nestUrl, NestJsonBody.getAuthHeader(nestKey),tempBody(prop.getOrDefault("nest.device.thermo.1","").toString(),19)));



    }
}
