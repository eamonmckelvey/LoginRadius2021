package com.demo;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loginradius.sdk.helper.JsonDeserializer;
import com.loginradius.sdk.helper.LoginRadiusRequest;
import com.loginradius.sdk.helper.LoginRadiusValidator;
import com.loginradius.sdk.models.responsemodels.AccessTokenBase;
import com.loginradius.sdk.util.AsyncHandler;
import com.loginradius.sdk.util.ErrorResponse;
import com.loginradius.sdk.util.LoginRadiusSDK;


public class NativeSocialAPI {
   private static Gson gson =new Gson();

   public NativeSocialAPI(){
      if (!LoginRadiusSDK.validate()){
         throw new LoginRadiusSDK.InitializeException();
      }
   }

   
   
   // <summary>
   // The API is used to get LoginRadius access token by sending Facebook's access token. It will be valid for the specific duration of time specified in the response.
   // </summary>
   // <param name="fbAccessToken">Facebook Access Token</param>
   // <param name="socialAppName">Name of Social provider APP</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.3	    
		
		
   public void getAccessTokenByFacebookAccessToken(String fbAccessToken, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(fbAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("fbAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("ffbAccessToken", fbAccessToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/facebook";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The API is used to get LoginRadius access token by sending Twitter's access token. It will be valid for the specific duration of time specified in the response.
   // </summary>
   // <param name="twAccessToken">Twitter Access Token</param>
   // <param name="twTokenSecret">Twitter Token Secret</param>
   // <param name="socialAppName">Name of Social provider APP</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.4	    
		
		
   public void getAccessTokenByTwitterAccessToken(String twAccessToken, String twTokenSecret,
      String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(twAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("twAccessToken"));
      }      

      if (LoginRadiusValidator.isNullOrWhiteSpace(twTokenSecret)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("twTokenSecret"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("key", LoginRadiusSDK.getApiKey());
      queryParameters.put("twAccessToken", twAccessToken);
      queryParameters.put("twTokenSecret", twTokenSecret);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/twitter";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // The API is used to get LoginRadius access token by sending Google's access token. It will be valid for the specific duration of time specified in the response.
   // </summary>
   // <param name="googleAccessToken">Google Access Token</param>
   // <param name="clientId">Google Client ID</param>
   // <param name="refreshToken">LoginRadius refresh token</param>
   // <param name="socialAppName">Name of Social provider APP</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.5	    
		
		
   public void getAccessTokenByGoogleAccessToken(String googleAccessToken, String clientId,
      String refreshToken, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(googleAccessToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("googleAccessToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("googleAccessToken", googleAccessToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      if (!LoginRadiusValidator.isNullOrWhiteSpace(clientId)) {
        queryParameters.put("clientId", clientId);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(refreshToken)) {
        queryParameters.put("refresh_token", refreshToken);
      }

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("eamonsapp", socialAppName);
      }

      String resourcePath = "api/v2/access_token/google";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   // <summary>
   // This API is used to Get LoginRadius Access Token using google jwt id token for google native mobile login/registration.
   // </summary>
   // <param name="idToken">Google JWT id_token</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.6	    
		
		
   public void getAccessTokenByGoogleJWTAccessToken(String idToken, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(idToken)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("idToken"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("id_Token", idToken);
      queryParameters.put("key", LoginRadiusSDK.getApiKey());

      String resourcePath = "api/v2/access_token/googlejwt";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
   
   
   
   // <summary>
   // The API is used to get LoginRadius access token by sending Google's AuthCode. It will be valid for the specific duration of time specified in the response.
   // </summary>
   // <param name="googleAuthcode">Google AuthCode</param>
   // <param name="socialAppName">Name of Social provider APP</param>
   // <returns>Response containing Definition of Complete Token data</returns>
   // 20.16	    
		
		
   public void getAccessTokenByGoogleAuthCode(String googleAuthcode, String socialAppName, final AsyncHandler<AccessTokenBase> handler) {      

      if (LoginRadiusValidator.isNullOrWhiteSpace(googleAuthcode)) {
        throw new IllegalArgumentException(LoginRadiusValidator.getValidationMessage("googleAuthcode"));
      }
			
      Map<String, String> queryParameters = new HashMap<String, String>();
      queryParameters.put("apiKey", LoginRadiusSDK.getApiKey());
      queryParameters.put("google_authcode", googleAuthcode);

      if (!LoginRadiusValidator.isNullOrWhiteSpace(socialAppName)) {
        queryParameters.put("socialAppName", socialAppName);
      }

      String resourcePath = "api/v2/access_token/google";
            
      LoginRadiusRequest.execute("GET", resourcePath, queryParameters, null, new AsyncHandler<String>() {
			
        @Override
        public void onSuccess(String response) {
          TypeToken<AccessTokenBase> typeToken = new TypeToken<AccessTokenBase>() {};
          AccessTokenBase successResponse = JsonDeserializer.deserializeJson(response,typeToken);
          handler.onSuccess(successResponse);
        }

        @Override
        public void onFailure(ErrorResponse errorResponse) {
          handler.onFailure(errorResponse);
        }
      });
   }
}
