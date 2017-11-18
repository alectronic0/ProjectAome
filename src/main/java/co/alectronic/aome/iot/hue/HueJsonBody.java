package co.alectronic.aome.iot.hue;

import co.alectronic.aome.util.PropertyIO;
import co.alectronic.aome.util.RestClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;

import static co.alectronic.aome.core.Constants.HUE_API_KEY;
import static co.alectronic.aome.core.Constants.configFile;

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
        Object obj = new JSONTokener(RestClient.get("https://www.meethue.com/api/nupnp")).nextValue();
        JSONObject json = null;

        try {
        if (obj instanceof JSONObject){
            json = ((JSONObject)obj);
        }
        else if (obj instanceof JSONArray){
            json = ((JSONArray)obj).getJSONObject(0);
        }else {
            s = obj.toString();
        }
        }catch (Exception e){}

        System.out.println(obj);


        if(json != null){
            s = json.get("internalipaddress").toString();
        }

        return  s;//detect Bridge
    }


    public static String createUser(String devicename){
        String s = null;
        JSONObject jo = null;

        String ip = "http://"+detectBridge()+"/api";

        Object json = new JSONTokener(RestClient.post(ip,"{\"devicetype\":\""+devicename+"\"}")).nextValue();

        if (json instanceof JSONObject){
             jo = (JSONObject)json;
        }
        else if (json instanceof JSONArray) {
            jo = ((JSONArray) json).getJSONObject(0);
        }

        if(jo.has("success")){s = jo.getJSONObject("success").get("username").toString();}
        else if(jo.has("error")){
            System.out.println(
                    "ERROR: \n" +
                    jo.getJSONObject("error").get("type").toString() + " \n" +
                    jo.getJSONObject("error").get("address").toString() + " \n" +
                    jo.getJSONObject("error").get("description").toString() + " \n"
            );
        }

        return s;
    }

    public static String deleteUser(String id){
        String ip = "http://"+detectBridge()+"/api";
        String hueKey = PropertyIO.getProperties(configFile).getOrDefault(HUE_API_KEY,"").toString();

        String s = ip+"/" + hueKey + "/config/whitelist/"+id;
        System.out.println(s);

        return RestClient.delete(s);
    }


    public static String updateLight(String hueUrl, String hueKey, String lightId, boolean on, int bri, int hue, int sat) {
        return RestClient.put(hueUrl + hueKey + "/lights/"+lightId+"/state", new HashMap<>(), HueJsonBody.lightBody(on, bri, hue, sat));
    }


    
    
    
    
}
