package co.alectronic.aome.social.facebook;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Test;

import static co.alectronic.aome.core.Constants.*;

/**
 * Created by alec on 26/02/17.
 */
public class TestFacebook {

    @Test
    public void getFacebookInfo(){
        String facebookKey = PropertyIO.getProperties(configFile).getOrDefault(FACEBOOK_API_KEY, "");
        System.out.println(facebookKey);
        System.out.println(RestClient.get("http://graph.facebook.com/me/photos",RestClient.getAuthHeader("Bearer",facebookKey)));
        System.out.println(RestClient.get("http://graph.facebook.com/me/photos",RestClient.getAuthHeader("Bearer",facebookKey)));
    }
}
