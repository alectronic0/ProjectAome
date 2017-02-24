package co.alectronic.aome.nest;

import java.util.HashMap;

/**
 * Created by alec on 24/02/17.
 */
public class NestJsonBody {

    public static String tempBody(String thermostatID,int i){
        return "{\"devices\":{\"thermostats\":{\""+thermostatID+"\":{\"target_temperature_c\":"+i+"}}}}";

    }

    public  static HashMap<String,Object> getAuthHeader(String nestKey){
        return new HashMap<String, Object>() {{put("Authorization","Bearer "+ nestKey);}};
    }
}
