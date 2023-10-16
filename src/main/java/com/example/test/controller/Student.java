package com.example.test.controller;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.example.test.dto.BasePrice;
import com.example.test.dto.SsoToken;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.SameSite;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Student {
	@Autowired
	RestTemplate restTemplate;	
	
	final String URL_STRING = "https://reqres.in/api/users?page={page}";
	 //https://reqres.in/api/users?page=2
	@GetMapping(value={"/v1","v2"}, produces = {"application/json", "application/xml"})
	public String name() {
		return "how r u?";
	}
	
	@GetMapping(value ={"/v3","/v4"})
	public String names() throws OAuthProblemException, OAuthSystemException {
		return "how r uuu?"+getOAuthToken();
	}

	@GetMapping(value ="/v5")
	public String tokenname() throws Exception {
		return "how r uuu?"+getOAuthToken1();
	}
	@GetMapping("/magic")
	public ResponseEntity<?> copyResponse() {
		
		
		
		
		String url = "https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1goals=1&team2goals=1";

//		URL obj = new URL(url);
//		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//		con.setRequestMethod("GET");
//
//		int responseCode = con.getResponseCode();
//		if (responseCode == HttpURLConnection.HTTP_OK) {
//		    BufferedReader in = new BufferedReader(new InputStreamReader(
//		            con.getInputStream()));
//		    String inputLine;
//		    StringBuffer response = new StringBuffer();
//
//		    while ((inputLine = in.readLine()) != null) {
//		        response.append(inputLine);
//		    }
//		    in.close();
//
//		    Gson gson = new Gson();
//		    ResponseData responseData = gson.fromJson(response.toString(), ResponseData.class);
		
		
		
	 Map<String, Object> requestParameters = new HashMap<>();
	 //requestParameters.put("vin", "123");
	 HttpEntity requestEntity = null;
		/* requestEntity means jo header ho ya body
		 * */
	  //return restTemplate.exchange(URL_STRING, HttpMethod.GET,requestEntity,Object.class);
		/* if requestParameters Are there
		 *  then 
		 * return restTemplate.exchange(URL_STRING, HttpMethod.GET,null,Object.class, requestParameters);
		 *  
		 */
	  ResponseEntity<?> response = null;
	  try {
		  requestParameters.put("page", "3");
		  response = restTemplate.exchange(URL_STRING, HttpMethod.GET,requestEntity,Object.class,requestParameters);
		  //HashMap<String , Object> hsHashMap = new HashMap<>(response.getBody());
		 return restTemplate.exchange(URL_STRING, HttpMethod.GET,requestEntity,Object.class,requestParameters);
		
	} catch (Exception e) {
		System.out.println("what is e>>"+e);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	   
	 
	}
	
	///////////////////////////////
	@GetMapping("/dealer")
	public ResponseEntity<?> fun() {
		String url = "https://run.mocky.io/v3/cc2aeec2-019a-4a3b-ba8b-ccc1a7b28ef4";
		//return  restTemplate.exchange(url, HttpMethod.GET,null,Object.class);
    return null;
	}

	private String getOAuthToken()  throws OAuthSystemException, OAuthProblemException {
		//logger.info("Getting OAuth Token");
		System.out.println("Getting OAuth Token");
		OAuthClientRequest request;

		request = OAuthClientRequest.tokenLocation("https://sso-int.mercedes-benz.com/as/token.oauth2")
				.setGrantType(GrantType.CLIENT_CREDENTIALS)
				.setClientId("84e4c3ff-5c0b-4ad1-9bd5-40f3d779910b")
				.setClientSecret("26caf02e-a17a-4fc6-ae74-26098510ebc6")
				.buildBodyMessage();
		System.out.println(GrantType.CLIENT_CREDENTIALS);

		//create OAuth client that uses custom http client under the hood
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

		OAuthJSONAccessTokenResponse tokenResp =oAuthClient.accessToken(request);
		String token=tokenResp.getAccessToken();
		return token;
	}
	private String getOAuthToken1()  throws Exception{
		System.out.println("Getting OAuth Token");
		RestTemplate restTemplate = new RestTemplate();
//		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("security-proxy.americas.svc.corpintra.net", 3128));
//		requestFactory.setProxy(proxy);
	//	restTemplate = new RestTemplate(requestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("grant_type", "client_credentials");
		requestBody.add("client_id", "urclientid");
		requestBody.add("client_secret", "urclientsecret");

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
		String url = "https://sso-int.mercedes-benz.com/as/token.oauth2";
		ResponseEntity<SsoToken> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, SsoToken.class);
        String accessToken = response.getBody().getAccess_token();
		return accessToken;
	}
	
	public static String betterCompression(String s) {
		int n = s.length(), i = 0;
		Map<Character, Integer> hm = new TreeMap<>();
		while(i<n) {
		 char ch = s.charAt(i++);
		 StringBuilder sb = new StringBuilder();
		 while(i < n && s.charAt(i)>= '0' && s.charAt(i)<= '9') {
			 sb.append(s.charAt(i));
			 i++;
		 }
		 int count = Integer.parseInt(sb.toString());
		 if(count != 0) {
			 hm.put(ch, hm.getOrDefault(ch, 0)+1);
		 }
		}
		 StringBuilder ans = new StringBuilder();
		 
		 for(Entry<Character, Integer> map : hm.entrySet()) {
			 ans.append(""+map.getKey()+map.getValue());
		 }
		 return ans.toString();
		}

	@GetMapping(value = "/xmlcheck", produces = "application/xml")
	public ResponseEntity<?> xmlform() {
		BasePrice basePrice =new BasePrice("1.0","USD");
//		basePrice.setContent("1.0");
//		basePrice.setCurrency("USD");
		return new ResponseEntity<>(basePrice ,HttpStatus.OK);
	}

}
