package co.alectronic.aome.hue;

/**
 * Created by alec on 24/02/17.
 */
public class HueJsonBody {

    public String lightBody(boolean on, int bri, int hue, int sat){
        boolean ok = true;
        String s = "";
        if(0 > bri || bri > 255){ok = false; s+= "Bri is bad " + bri + " ";}
        if(0 > hue || hue > 65535){ok = false; s+= "Hue is bad " + hue + " ";}
        if(0 > sat || sat > 255){ok = false; s+="Sat is bad " + sat + " ";}

        if(ok) {
            s = "{\"on\":" + on + ",\"bri\":" + bri + ",\"hue\":" + hue + ",\"sat\":" + sat + "}";
        }
        return s;
    }
}
