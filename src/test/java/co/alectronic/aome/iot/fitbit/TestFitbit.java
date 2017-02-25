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

/**
 * Created by alec on 25/02/17.
 */
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
        Map prop = PropertyIO.getProperties(configFile);
        String fitbitKey = prop.getOrDefault(FITBIT_API_KEY,"").toString();
        String fitbitUrl = prop.getOrDefault(FITBIT_API_URL,"").toString();


        String s = RestClient.get(fitbitUrl+path,FitbitJsonBody.getAuthHeader(fitbitKey));
        System.out.println(s);

        Object json = new JSONTokener(s).nextValue();
        if (json instanceof JSONObject){
            JSONObject jo = (JSONObject)json;
            s = jo.toString(4);
        }
        else if (json instanceof JSONArray){
            JSONArray jo = (JSONArray)json;
            s = jo.toString(4);
        }

        System.out.println(s);
    }






}
