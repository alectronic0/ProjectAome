package co.alectronic.aome.social.twitter;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Ignore;
import org.junit.Test;

import static co.alectronic.aome.core.Constants.*;


public class TestTwitter {

    @Test
    @Ignore
    public void getTwitterInfo(){
        String twitterKey = PropertyIO.getProperties(configFile).getOrDefault(TWITTER_API_KEY, "");
        System.out.println(twitterKey);
        System.out.println(RestClient.post("https://api.twitter.com/oauth2/token",RestClient.getAuthHeader("Basic",twitterKey),"grant_type=client_credentials"));
        System.out.println(RestClient.get("https://api.twitter.com/1.1/users/show.json",RestClient.getAuthHeader("Bearer",twitterKey)));
    }
}
