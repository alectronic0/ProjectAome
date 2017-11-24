package co.alectronic.aome.iot.nest;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static co.alectronic.aome.core.Constants.NEST_API_KEY;
import static co.alectronic.aome.core.Constants.NEST_API_URL;
import static co.alectronic.aome.core.Constants.configFile;

public class TestNest {

    @Test
    @Ignore
    public void getNestInfo(){
        String nestKey = PropertyIO.getProperties(configFile).getOrDefault(NEST_API_KEY, "");
        System.out.println(RestClient.get(NEST_API_URL, NestJsonBody.getAuthHeader(nestKey)));
    }
}
