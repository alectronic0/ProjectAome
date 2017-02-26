package co.alectronic.aome.social.twitter;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static co.alectronic.aome.core.Constants.*;

/**
 * Created by alec on 26/02/17.
 */
public class TestTwitter {

    @Test
    public void getTwitterInfo(){

        Map prop = PropertyIO.getProperties(configFile);
        String twitterKey = prop.getOrDefault(TWITTER_API_KEY,"").toString();
        String twitterUrl = TWITTER_API_URL;

        String s = RestClient.get(twitterUrl+"/1.1/users/show.json",new HashMap<String,Object>(){{put("",)}});
        System.out.println(s);
        System.out.println(new JSONObject(s).toString(4));
    }

}
