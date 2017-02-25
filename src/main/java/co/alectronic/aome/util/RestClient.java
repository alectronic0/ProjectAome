package co.alectronic.aome.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alec on 24/02/17.
 */
public class RestClient {

    /*
    GET
     */
    //Need to be a http:// https://
    public static String get(String url){
        return get(url,new HashMap<String,Object>());
    }

    public static String get(String url, Map<String,Object> header){
        String s ="";

        try {
            Client c = Client.create();

            WebResource.Builder builder = c.resource(url).accept(MediaType.APPLICATION_JSON_TYPE);

            header.keySet().forEach(k -> builder.header(k,header.get(k)));

            String response = builder.get(String.class);
//            JSONObject jsonObject = new JSONObject(response);
//            s = jsonObject.toString(4);
            s = response;
        } catch (UniformInterfaceException e){
            s = e.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }


    /*
    PUT
     */
    public static String put(String url){
        return put(url,"{}");
    }

    public static String put(String url,Map<String,Object> header){
        return put(url,header,"{}");
    }

    public static String put(String url,String body){
        return put(url,new HashMap<String,Object>(),"{}");
    }

    public static String put(String url, Map<String,Object> header,String requestBody){
        String s ="";

        try {
            Client c = Client.create();

            WebResource.Builder builder = c.resource(url).accept(MediaType.APPLICATION_JSON_TYPE);

            header.keySet().forEach(k -> builder.header(k,header.get(k)));

            String response = builder.put(String.class,requestBody);
//            JSONObject jsonObject = new JSONObject(response);
            //error if its not a jsonobject, jsonarray is done by hue atm.

//            s = jsonObject.toString(4);
            s = response;
        } catch (UniformInterfaceException e){
            s = e.toString();
        } catch (Exception e){

            s = e.toString();
        }
        return s;
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

    public static String post(String url, Map<String,Object> header,String requestBody){
        String s ="";

        try {
            Client c = Client.create();

            WebResource.Builder builder = c.resource(url).accept(MediaType.APPLICATION_JSON_TYPE);

            header.keySet().forEach(k -> builder.header(k,header.get(k)));

            String response = builder.post(String.class,requestBody);
//            JSONObject jsonObject = new JSONObject(response);
            //error if its not a jsonobject, jsonarray is done by hue atm.

//            s = jsonObject.toString(4);
            s = response;
        } catch (UniformInterfaceException e){
            s = e.toString();
        } catch (Exception e){

            s = e.toString();
        }
        return s;
    }

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
        String s ="";

        try {
            Client c = Client.create();

            WebResource.Builder builder = c.resource(url).accept(MediaType.APPLICATION_JSON_TYPE);

            header.keySet().forEach(k -> builder.header(k,header.get(k)));

            String response = builder.delete(String.class);
//            JSONObject jsonObject = new JSONObject(response);
            //error if its not a jsonobject, jsonarray is done by hue atm.

//            s = jsonObject.toString(4);
            s = response;
        } catch (UniformInterfaceException e){
            s = e.toString();
        } catch (Exception e){

            s = e.toString();
        }
        return s;
    }
}
