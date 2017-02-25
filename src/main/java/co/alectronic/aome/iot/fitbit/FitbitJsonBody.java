package co.alectronic.aome.iot.fitbit;

import co.alectronic.aome.util.RestClient;
import java.util.HashMap;

/**
 * Created by alec on 24/02/17.
 */
public class FitbitJsonBody {

    public  static HashMap<String,Object> getAuthHeader(String key){
        return RestClient.getAuthHeader("Bearer",key);
    }

}
