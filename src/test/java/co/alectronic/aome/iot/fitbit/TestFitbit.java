package co.alectronic.aome.iot.fitbit;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.util.Map;

import static co.alectronic.aome.core.Constants.*;
import static co.alectronic.aome.core.Constants.configFile;

public class TestFitbit {

    @Test
    public void testFitbit(){
        testFitbitPath("/1/user/-/profile.json");
    }

    @Test
    public void testFitbitBadges(){
        testFitbitPath("/1/user/-/badges.json");
    }

    @Test
    public void testFitbitDevices(){
        testFitbitPath("/1/user/-/devices.json");
    }

    public void testFitbitPath(String path){
        String fitbitKey = PropertyIO.getProperties(configFile).getOrDefault(FITBIT_API_KEY, "");
        System.out.println(RestClient.get(FITBIT_API_URL+path,FitbitJsonBody.getAuthHeader(fitbitKey)));
    }






}
