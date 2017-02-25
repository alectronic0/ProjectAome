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
public class TestNest {

    @Test
    public void getNestInfo(){
        Map prop = PropertyIO.getProperties(configFile);
        String nestKey = prop.getOrDefault(NEST_API_KEY,"").toString();
        String nestUrl = prop.getOrDefault(NEST_API_URL,"").toString();

        System.out.println(new JSONObject(RestClient.get(nestUrl, NestJsonBody.getAuthHeader(nestKey))).toString(4));

    }
}
