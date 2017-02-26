package co.alectronic.aome.iot.nest;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Test;

import static co.alectronic.aome.core.Constants.*;

public class TestNestThemo {

    @Test
    public void changeTemp(){
        String nestKey = PropertyIO.getProperties(configFile).getOrDefault(NEST_API_KEY, "");
        System.out.println(RestClient.put(NEST_API_URL, NestJsonBody.getAuthHeader(nestKey),NestJsonBody.tempBody(PropertyIO.getProperties(configFile).getOrDefault("nest.device.thermo.1", ""),19)));
    }
}
