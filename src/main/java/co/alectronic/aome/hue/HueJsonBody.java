package co.alectronic.aome.hue;

import co.alectronic.aome.util.RestClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

/**
 * Created by alec on 24/02/17.
 */
public class HueJsonBody {

    public static String lightBody(boolean on, int bri, int hue, int sat){
        boolean ok = true;
        String s = "";
        if(0 > bri || bri > 255){ok = false; s+= "Bri is bad " + bri + " ";}
        if(0 > hue || hue > 65535){ok = false; s+= "Hue is bad " + hue + " ";}
        if(0 > sat || sat > 255){ok = false; s+="Sat is bad " + sat + " ";}

        if(ok) {
            s = "{\"on\":" + on + ",\"bri\":" + bri + ",\"hue\":" + hue + ",\"sat\":" + sat + "}";
        }else{
            s= "{}";
        }
        return s;
    }

    public static String lightBody(boolean on, int bri, int hue, int sat, double x, double y){
        boolean ok = true;
        String s = "";
        if(0 > bri || bri > 255){ok = false; s+= "Bri is bad " + bri + " ";}
        if(0 > hue || hue > 65535){ok = false; s+= "Hue is bad " + hue + " ";}
        if(0 > sat || sat > 255){ok = false; s+="Sat is bad " + sat + " ";}

        if(ok) {
            s = "{\"on\":" + on + ",\"bri\":" + bri + ",\"hue\":" + hue + ",\"sat\":" + sat + ",\"xy\":["+x+","+y+"]}";
        }else{
            s= "{}";
        }
        return s;
    }

    public static String lightBody(boolean on){
        return "{\"on\":"+on+"}";
    }



    public static String detectBridge(){
        String s = "";
        Object json = new JSONTokener(RestClient.get("https://www.meethue.com/api/nupnp")).nextValue();


        if (json instanceof JSONObject){
            JSONObject jo = (JSONObject)json;
            s = jo.get("internalipaddress").toString();
        }
        else if (json instanceof JSONArray){
            JSONArray jo = (JSONArray)json;
            s = jo.getJSONObject(0).get("internalipaddress").toString();
        }

        return  s;//detect Bridge

    }


    @Test
    public void getConnection(){

        System.out.println(detectBridge());


    }
}
