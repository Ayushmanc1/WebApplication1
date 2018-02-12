/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AChauhan4
 */
import com.google.gson.JsonObject;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class LuisGetRequest {

    public String main(String Data) 
    {
        String ret = "No Data";
        HttpClient httpclient = HttpClients.createDefault();
        try
        {

            // The ID of a public sample LUIS app that recognizes intents for turning on and off lights
            String AppId = "a2623cc0-5ae8-4d84-a9ef-c46691936bc8";
            
            // Add your subscription key 
            String SubscriptionKey = "b5943e81c61f4d438b59bedfcb7a7fa4";

        URIBuilder builder = 
            new URIBuilder("https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/" + AppId + "?");

            builder.setParameter("q", Data);
            builder.setParameter("timezoneOffset", "0");
            builder.setParameter("verbose", "false");
            builder.setParameter("spellCheck", "false");
            builder.setParameter("staging", "false");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", SubscriptionKey);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                
                //System.out.println(EntityUtils.toString(entity));
                return EntityUtils.toString(entity);
                
            }
            else
            {
                return ret;
            }
        }

        catch (Exception e)
        {
            //System.out.println(e.getMessage());
            return e.toString();
        }
    }
    public String QNA (String Qus)
    {
        String Return="";
        HttpClient httpclient = HttpClients.createDefault();
        try
        {

            // The ID of a public sample LUIS app that recognizes intents for turning on and off lights
            String AppId = "f4d41b8b-b9cc-4dd0-a714-3c4b02d33445/generateAnswer";
            
            // Add your subscription key 
            String SubscriptionKey = "e34b677c70604a6eabd269fccd918e67";

        URIBuilder builder = 
            new URIBuilder("https://westus.api.cognitive.microsoft.com/qnamaker/v2.0" + AppId + "?");
            //builder.setParameter("Ocp-Apim-Subscription-Key", SubscriptionKey);
            builder.setParameter("question", Qus);
            //builder.setParameter("timezoneOffset", "0");
            //builder.setParameter("verbose", "false");
            //builder.setParameter("spellCheck", "false");
            //builder.setParameter("staging", "false");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", SubscriptionKey);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            if (entity != null) 
            {
                
                //System.out.println(EntityUtils.toString(entity));
                return EntityUtils.toString(entity);
                
            }
            else
            {
                return Return;
            }
        }

        catch (Exception e)
        {
            //System.out.println(e.getMessage());
            return e.toString();
        }
    }
}
