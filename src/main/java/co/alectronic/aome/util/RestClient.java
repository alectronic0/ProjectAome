package co.alectronic.aome.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import com.sun.org.apache.bcel.internal.generic.Select;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alec on 24/02/17.
 */
public class RestClient {

    public  static HashMap<String,Object> getAuthHeader(String type,String key){
        return new HashMap<String, Object>() {{put("Authorization",type+" "+ key);}};
    }

    /*
    GET
     */
    //Need to be a http:// https://
    public static String get(String url){return get(url,new HashMap<String,Object>());}
    public static String get(String url, Map<String,Object> header){return restClientCall("get",url,header);}


    /*
    PUT
     */
    public static String put(String url){
        return put(url,"{}");
    }
    public static String put(String url,Map<String,Object> header){
        return put(url,header,"{}");
    }
    public static String put(String url,String body){return put(url,new HashMap<String,Object>(),body);}
    public static String put(String url, Map<String,Object> header,String requestBody){
        return restClientCall("put",url,header,requestBody);
    }

    /*
    POST
     */
    public static String post(String url){
        return post(url,"{}");
    }
    public static String post(String url,Map<String,Object> header){
        return post(url,header,"{}");
    }
    public static String post(String url,String body){
        return post(url,new HashMap<String,Object>(),body);
    }
    public static String post(String url, Map<String,Object> header,String requestBody){return restClientCall("post",url,header,requestBody);}

    /*
    DELETE
     */
    public static String delete(String url){
        return delete(url,"{}");
    }

    public static String delete(String url,Map<String,Object> header){
        return delete(url,header,"{}");
    }

    public static String delete(String url,String body){
        return delete(url,new HashMap<String,Object>(),body);
    }

    public static String delete(String url, Map<String,Object> header,String requestBody){
        return restClientCall("delete",url,header,requestBody);
    }


    public static String restClientCall(String restType, String url, Map<String,Object> header){
        return restClientCall(restType,url,header,null);
    }

    public static String restClientCall(String restType, String url, Map<String,Object> header,String requestBody){
        String s ="";
        String response = "";

        try {
            Client c = Client.create();
            WebResource.Builder builder = c.resource(url).accept(MediaType.APPLICATION_JSON_TYPE);
            if(header !=null) {header.keySet().forEach(k -> builder.header(k, header.get(k)));}

            switch (restType){
                case "get": response = builder.get(String.class); break;
                case "put": response = requestBody == null ? builder.put(String.class) : builder.put(String.class,requestBody); break;
                case "post": response = requestBody == null ? builder.post(String.class) : builder.post(String.class,requestBody); break;
                case "delete": response = requestBody == null ? builder.delete(String.class) : builder.delete(String.class,requestBody) ; break;
                default: response = "{\"error\":\"Unknown Rest Type\"}"; break;
            }

            Object obj = new JSONTokener(response).nextValue();
            if (obj instanceof JSONObject){s = ((JSONObject)obj).toString(4);}
            else if (obj instanceof JSONArray){s = ((JSONArray)obj).toString(4);}
            else{s = obj.toString();}

        } catch (Exception e){s = e.toString();}
        return s;
    }



}
