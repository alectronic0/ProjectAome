package co.alectronic.aome.core;

import co.alectronic.aome.iot.hue.HueJsonBody;

/**
 * Created by alec on 24/02/17.
 */
public class Constants {

    public final static String SP_M = ".";

    public final static String NEST = "nest";
    public final static String HUE = "hue";
    public final static String FITBIT = "fitbit";
    public final static String INSTAGRAM = "instagram";
    public final static String TWITTER = "twitter";
    public final static String FACEBOOK = "facebook";

    public final static String API = "api";

    public final static String KEY = "key";

    public final static String NEST_API = NEST + SP_M + API;
    public final static String HUE_API = HUE + SP_M + API;
    public final static String FITBIT_API = FITBIT + SP_M + API;
    public final static String INSTAGRAM_API = INSTAGRAM + SP_M + API;
    public final static String TWITTER_API = TWITTER + SP_M + API;
    public final static String FACEBOOK_API = FACEBOOK + SP_M + API;

    public final static String NEST_API_KEY = NEST_API + SP_M + KEY;
    public final static String NEST_API_URL = "https://developer-api.nest.com";

    public final static String HUE_API_KEY = HUE_API + SP_M + KEY;
    public final static String HUE_API_URL = "http://" + HueJsonBody.detectBridge() + "/api";


    public final static String FITBIT_API_KEY = FITBIT_API + SP_M + KEY;
    public final static String FITBIT_API_URL = "https://api.fitbit.com";


    public final static String INSTAGRAM_API_KEY = INSTAGRAM_API + SP_M + KEY;
    public final static String INSTAGRAM_API_URL = "https://api.instagram.com/v1";


    public final static String TWITTER_API_KEY = TWITTER_API + SP_M + KEY;
    public final static String TWITTER_API_URL = "https://api.twitter.com";


    public final static String FACEBOOK_API_KEY = FACEBOOK_API + SP_M + KEY;
    public final static String FACEBOOK_API_URL = "http://graph.facebook.com";



    public final static String configFile = "src/main/resources/settings.yml";




}
