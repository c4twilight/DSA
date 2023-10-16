package com.example.test.controller;

//import org.apache.commons.lang3.time.StopWatch;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserProfile {

    @Value("${user_Profile_EntitlementsURL}")
    String  user_Profile_EntitlementsURL;

    @Value("${oneAPI_OAuth2_TokenURL}")
    String oneAPI_OAuth2_TokenURL;
    @Value("${starAPI_client_id_encoded}")
    String  starAPI_client_id;
    @Value("${starAPI_client_secret_encoded}")
    String  starAPI_client_secret;

    @Autowired
    RestTemplate restTemplate;

    /* public ResponseEntity<?> entitlements(@PathVariable("USERID") String userId){
        HttpEntity entity= null;
        ResponseEntity<Object> response = null;
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("userId", userId);
        try {
            entity = createHttpEntity();
            StopWatch st = new StopWatch();
            st.start();
            response = restTemplate.exchange(user_Profile_EntitlementsURL, HttpMethod.GET, entity, Object.class,pathVariables);
            System.out.println(" ==> HttpCode: " + response.getStatusCode() + " - Execution Time: " + st.getTime() +" ms");
            st.stop();
        }catch (OAuthProblemException e) {
            throw new RuntimeException(e);
        } catch (OAuthSystemException e) {
            throw new RuntimeException(e);
        }catch(HttpClientErrorException e){
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.NOT_FOUND);
            }
            else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                return new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
            }
        } catch(Exception e){
            return new ResponseEntity<>(response.getBody(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(response.getStatusCode() == HttpStatus.NO_CONTENT){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    } */
    @RequestMapping(value="/authentication-service/v1/user-profile/{USERID}/entitlements", method= RequestMethod.GET ,produces={"application/json","application/xml"})
    public ResponseEntity<?> entitlements(@PathVariable("USERID") String userId) {
        try {
            HttpEntity entity = createHttpEntity();
            ResponseEntity<Object> response = restTemplate.exchange(user_Profile_EntitlementsURL, HttpMethod.GET, entity, Object.class, userId);
            if (response.getStatusCode() == HttpStatus.NO_CONTENT) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(response.getBody());
        } catch (OAuthProblemException | OAuthSystemException e) {
            throw new RuntimeException(e);
        } catch (HttpClientErrorException e) {
            HttpStatus statusCode = e.getStatusCode();
            return new ResponseEntity<>(e.getResponseBodyAsString(), statusCode);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String getOAuthToken()  throws OAuthSystemException, OAuthProblemException {
        //logger.info("Getting OAuth Token");
        System.out.println("Getting OAuth Token");
        OAuthClientRequest request = OAuthClientRequest.tokenLocation(oneAPI_OAuth2_TokenURL)
                .setGrantType(GrantType.CLIENT_CREDENTIALS)
                .setClientId(new String(Base64.getDecoder().decode(starAPI_client_id)))
                .setClientSecret(new String(Base64.getDecoder().decode(starAPI_client_secret)))
                .buildBodyMessage();

        //create OAuth client that uses custom http client under the hood
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        OAuthJSONAccessTokenResponse tokenResp =oAuthClient.accessToken(request);
        return tokenResp.getAccessToken();
    }

    private HttpEntity createHttpEntity() throws OAuthProblemException, OAuthSystemException {
        // Call OAuth Token
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept","application/json" );
        requestHeaders.add("Content-Type","application/json" );
        requestHeaders.add("Authorization","Bearer "+getOAuthToken());
        System.out.println(requestHeaders.get("Authorization").toString());
        // HttpEntity entity = new HttpEntity(requestHeaders);
        return new HttpEntity(requestHeaders);
    }

}
