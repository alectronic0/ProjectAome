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

    public static String get(String url, Map<String,Object> header){
        String s ="";

        try {
            Client c = Client.create();

            WebResource.Builder builder = c.resource(url).accept(MediaType.APPLICATION_JSON_TYPE);

            header.keySet().forEach(k -> builder.header(k,header.get(k)));

            String response = builder.get(String.class);
            JSONObject jsonObject = new JSONObject(response);

            s = jsonObject.toString(4);

        } catch (UniformInterfaceException e){
            s = e.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public static String get(String url){
        return get(url,new HashMap<String,Object>());
    }


    public static String put(String url, Map<String,Object> header,String requestBody){
        String s ="";

        try {
            Client c = Client.create();

            WebResource.Builder builder = c.resource(url).accept(MediaType.APPLICATION_JSON_TYPE);

            header.keySet().forEach(k -> builder.header(k,header.get(k)));

            String response = builder.put(String.class,requestBody);
            JSONObject jsonObject = new JSONObject(response);

            s = jsonObject.toString(4);

        } catch (UniformInterfaceException e){
            s = e.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }



}
