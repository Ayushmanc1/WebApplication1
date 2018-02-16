/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AChauhan4
 */

import com.google.cloud.dialogflow.v2beta1.DetectIntentResponse;
import com.google.cloud.dialogflow.v2beta1.QueryInput;
import com.google.cloud.dialogflow.v2beta1.QueryResult;
import com.google.cloud.dialogflow.v2beta1.SessionName;
import com.google.cloud.dialogflow.v2beta1.SessionsClient;

import com.google.cloud.dialogflow.v2beta1.*;
import com.google.cloud.dialogflow.v2beta1.QueryInput.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextClient {
  
      public static String detectIntentTexts(String projectId, List<String> texts, String sessionId,
      String languageCode){
          String resultSet="",ResultSetName="";
          
          try (com.google.cloud.dialogflow.v2beta1.SessionsClient sessionsClient = com.google.cloud.dialogflow.v2beta1.SessionsClient.create()) {
      SessionName session = SessionName.of(projectId, sessionId);
      System.out.println("Session Path: " + session.toString());
      // Detect intents for each text input
      for (String text : texts) {
        Builder textInput = com.google.cloud.dialogflow.v2beta1.TextInput.newBuilder().setText(text).setLanguageCode(languageCode);
        com.google.cloud.dialogflow.v2beta1.QueryInput queryInput = com.google.cloud.dialogflow.v2beta1.QueryInput.newBuilder().setText(textInput).build();
        // Performs the detect intent request
        DetectIntentResponse response = sessionsClient.detectIntent(session, queryInput);
        // Display the query result
        QueryResult queryResult = response.getQueryResult();

        System.out.println("====================");
        resultSet= queryResult.getQueryText();
        ResultSetName=queryResult.getIntent().getDisplayName();
        System.out.format("Query Text: '%s'\n", resultSet);
        System.out.format("Detected Intent: %s (confidence: %f)\n",
            ResultSetName, queryResult.getIntentDetectionConfidence());
        System.out.format("Fulfillment Text: '%s'\n", queryResult.getFulfillmentText());
      }
          }
          catch(Exception ex)
          {
              
          }
return ResultSetName;
          }
      
  public String GetIntent(String Args)
  {
    ArrayList<String> texts = new ArrayList<>();
    String projectId = "gimis-c800e";
    String sessionId = UUID.randomUUID().toString();
    String languageCode = "en-US";
    texts.add(Args);
    String Data="";
          try {
               Data = detectIntentTexts(projectId, texts, sessionId, languageCode);
          } catch (Exception ex) {
              return ex.toString();
          }
      return Data;
  }
  
}
