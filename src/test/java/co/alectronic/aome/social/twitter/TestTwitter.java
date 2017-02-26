package co.alectronic.aome.social.twitter;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Test;

import java.util.HashMap;

import static co.alectronic.aome.core.Constants.*;


public class TestTwitter {

    @Test
    public void getTwitterInfo(){
        String twitterKey = PropertyIO.getProperties(configFile).getOrDefault(TWITTER_API_KEY, "");
        System.out.println(RestClient.get(TWITTER_API_URL+"/1.1/users/show.json",new HashMap<String,Object>(){{}}));
    }

}
