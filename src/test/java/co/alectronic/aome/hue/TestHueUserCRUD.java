package co.alectronic.aome.hue;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONObject;
import org.junit.Test;

import static co.alectronic.aome.core.Constants.HUE_API_KEY;
import static co.alectronic.aome.core.Constants.configFile;
import static co.alectronic.aome.hue.HueJsonBody.*;

/**
 * Created by alec on 25/02/17.
 */
public class TestHueUserCRUD {


    @Test
    public static void createDeleteTest(){
        String ip = "http://"+HueJsonBody.detectBridge()+"/api";
        String hueKey = PropertyIO.getProperties(configFile).getOrDefault(HUE_API_KEY,"").toString();

        String username = HueJsonBody.createUser("aome#Test");

        if(username != null){
            System.out.println(HueJsonBody.deleteUser(username));
        }else {
            System.out.println("no user to delete");
        }
        System.out.println(new JSONObject(RestClient.get(ip+"/" + hueKey + "/config")).getJSONObject("whitelist").toString(4));
    }


}
