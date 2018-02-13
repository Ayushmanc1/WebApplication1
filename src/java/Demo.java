
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AChauhan4
 */
public class Demo {
    
    public String QNA (String Qus)
    {
        String Return="";
        HttpClient httpclient = HttpClients.createDefault();
        try
        {

            // The ID of a public sample LUIS app that recognizes intents for turning on and off lights
            String AppId = "/knowledgebases/f4d41b8b-b9cc-4dd0-a714-3c4b02d33445/generateAnswer";
            
            // Add your subscription key 
            String SubscriptionKey = "e34b677c70604a6eabd269fccd918e67";
            
        URIBuilder builder = 
            new URIBuilder("https://westus.api.cognitive.microsoft.com/qnamaker/v2.0/knowledgebases/f4d41b8b-b9cc-4dd0-a714-3c4b02d33445");
            //builder.setParameter("Ocp-Apim-Subscription-Key", SubscriptionKey);
            builder.setParameter("question:", "how to apply leave");
            //builder.setParameter("timezoneOffset", "0");
            //builder.setParameter("verbose", "false");
            //builder.setParameter("spellCheck", "false");
            //builder.setParameter("staging", "false");

            URI uri = builder.build();
            HttpGet request = new HttpGet(uri);
            request.setHeader("Ocp-Apim-Subscription-Key", SubscriptionKey);
            request.addHeader("Content-Type", "application/json");
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
    
    public static void main(String[] Data) 
    {
        Demo dr = new  Demo();
        System.out.println(dr.QNA("How to create rr"));
        
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

            builder.setParameter("q", "there");
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
             /*String inputLine ;
 BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
 try {
       while ((inputLine = br.readLine()) != null) {
              System.out.println(inputLine);
       }
       br.close();
                
  } catch (IOException e) {
       e.printStackTrace();
  }   */
                String responseXml = EntityUtils.toString(response.getEntity());
                EntityUtils.consume(response.getEntity());
                //System.out.println(responseXml);
                String subres[] = responseXml.split(",");
                for(int i = 0;i<subres.length;i++)
                {
                   // System.out.println(subres[i]);
                    String sub[] = subres[i].split(":");
                    if(sub[0].contains("score"))
                    {
                        String s = sub[1].replace('}', ' ');
                         double d=  Double.parseDouble(s);                   
                        if(d==1 || d>0.90)
                        {
                            System.out.println("Hello");
                        }
                        else 
                        {
                            System.out.println("fail" + d);
                        }
                    }
                   // System.out.println(sub[0]);
                    //System.out.println(sub[1]);
                }
            }
            else
            {
                System.out.println(ret);
            }
        }

        catch (Exception e)
        {
            //System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    } 
}
