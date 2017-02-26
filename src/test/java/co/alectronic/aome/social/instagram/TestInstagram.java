package co.alectronic.aome.social.instagram;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.junit.Test;

import static co.alectronic.aome.core.Constants.*;

public class TestInstagram {
    @Test
    public void getInstagramInfo(){
        String instagramKey = PropertyIO.getProperties(configFile).getOrDefault(INSTAGRAM_API_KEY, "");
        System.out.println(RestClient.get(INSTAGRAM_API_URL+"/users/self/?access_token="+instagramKey));
    }
}
