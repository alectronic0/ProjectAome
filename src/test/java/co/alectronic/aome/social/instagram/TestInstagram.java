package co.alectronic.aome.social.instagram;

import co.alectronic.aome.iot.nest.NestJsonBody;
import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static co.alectronic.aome.core.Constants.*;

/**
 * Created by alec on 26/02/17.
 */
public class TestInstagram {

    @Test
    public void getInstagramInfo(){

        Map prop = PropertyIO.getProperties(configFile);
        String instagramKey = prop.getOrDefault(INSTAGRAM_API_KEY,"").toString();
        String instagramUrl = INSTAGRAM_API_URL;

        String s = RestClient.get(instagramUrl+"/users/self/?access_token="+instagramKey);
        System.out.println(s);
        System.out.println(new JSONObject(s).toString(4));
    }

}
