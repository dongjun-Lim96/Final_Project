package accounts.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import accounts.controller.AccountsNaverLoginApi;
import course.model.CourseBean;
import courseorder.model.CourseOrderBean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

@Component
public class AccountsDao {

   private String namespace = "accounts.model";
   private final static String CLIENT_ID = "EIFqwKjsQVwd8DbmOYmJ";
   private final static String CLIENT_SECRET = "REBKNW4M4a";
   private final static String REDIRECT_URI = "http://localhost:8080/ex/loadingN.acc";
   private final static String SESSION_STATE = "oauth_state";
   /* 프로필 조회 API URL */
   private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";
   
   @Autowired
   SqlSessionTemplate sqlSessionTemplate;

   
   public AccountsBean GetAccountsById(String userId) {
      AccountsBean ab= new AccountsBean();
      ab = sqlSessionTemplate.selectOne(namespace+".GetAccountsById",userId); 
      return ab;

   }


   public AccountsBean GetUserIdByUserEmail(String input_userEmail) {
      AccountsBean ab= new AccountsBean();
      ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserEmail",input_userEmail); 
      
      return ab;
   }


   public AccountsBean GetAccountsByName(String input_userName) {
      AccountsBean ab= new AccountsBean();
      ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserName",input_userName); 
      
      return ab;
   }

   public AccountsBean GetAccountsByEmail(String input_userEmail) {
      AccountsBean ab= new AccountsBean();
      ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserEmail",input_userEmail); 
      
      return ab;
   }

   public AccountsBean GetAccountsByNameEmail(String input_userName, String input_userEmail) {
      AccountsBean ab= new AccountsBean();
      
      HashMap<String, String> M =new HashMap<String, String>(); 
      M.put("userName", input_userName);
      M.put("userEmail", input_userEmail);
      ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserNameEmail",M); 
      
      return ab;
   }


   public AccountsBean GetAccountsByIdEmail(String input_userId, String input_userEmail) {
      AccountsBean ab= new AccountsBean();
      HashMap<String, String> M =new HashMap<String, String>(); 
      M.put("userId", input_userId);
      M.put("userEmail", input_userEmail);
      ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserIdEmail",M); 
      
      return ab;
   }
   
   public boolean searchId(String userId) {
      boolean result = false; 
      int cnt = sqlSessionTemplate.selectOne(namespace+".SearchId", userId);
      if (cnt>0) {
         result = true;
      }
      
      return result;
   }
   
   public int accountsRegister(AccountsBean ab) {
      int cnt = -1;
      cnt = sqlSessionTemplate.insert(namespace+".AccountsRegister", ab);
      
      return cnt;
   }
   
   
   public List<CourseBean> getOrderById(String userId) {
      List<CourseBean> lists = new ArrayList<CourseBean>();
      lists = sqlSessionTemplate.selectList(namespace+".GetOrderById",userId); 
      return lists;
   }
   
   public int accountsUpdate(AccountsBean ab) {
      int cnt = -1;
      cnt = sqlSessionTemplate.update(namespace+".AccountsUpdate", ab);
      
      return cnt;
   }
   
   public void outUser(String userId) {
      int cnt = -1;
      cnt = sqlSessionTemplate.update(namespace+".OutUser", userId);
   }
   
   public List<CourseBean> getWishList(String userId) {
      List<CourseBean> lists = new ArrayList<CourseBean>();
      lists = sqlSessionTemplate.selectList(namespace+".GetWishList", userId); 
      return lists;
   }

   public List<CourseOrderBean> getPayList(String userId) {
	      List<CourseOrderBean> lists = new ArrayList<CourseOrderBean>();
	      lists = sqlSessionTemplate.selectList(namespace+".GetPayList", userId);
	      return lists;
	   }


	   public List<CourseBean> getCourseList(String userId) {
	      List<CourseBean> lists = new ArrayList<CourseBean>();
	      lists = sqlSessionTemplate.selectList(namespace+".GetCourseList", userId); 
	      return lists;
	   }

	   public List<CourseBean> getCourseEndList(String userId) {
	      List<CourseBean> lists = new ArrayList<CourseBean>();
	      lists = sqlSessionTemplate.selectList(namespace+".GetCourseEndList", userId); 
	      return lists;
	   }
   public String getAccessToken (String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //  URL연결은 입출력에 사용 될 수 있고, POST 혹은 PUT 요청을 하려면 setDoOutput을 true로 설정해야함.
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //   POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=60dd63bcf46b11648aa82580a9f4ef16");  //본인이 발급받은 REST API key
            sb.append("&redirect_uri=http://localhost:8080/ex/loading.acc");     // 본인이 설정해 놓은 경로
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //    결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return access_Token;
    }
    
    
   public HashMap<String, Object> getUserInfo (String access_Token) {
         System.out.println("access_Token:::::"+access_Token);
        //    요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    요청에 필요한 Header에 포함될 내용
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));

            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

           System.out.println("properties:"+properties);
           System.out.println("kakao_account:"+kakao_account);
           String email = kakao_account.getAsJsonObject().get("email").getAsString();
           String nickname = properties.getAsJsonObject().get("nickname").getAsString();
           System.out.println("access_Token"+access_Token);
           System.out.println("email"+email);
           System.out.println("nickname"+nickname);

           userInfo.put("accessToken", access_Token);
           userInfo.put("email", email);//이메일
           userInfo.put("nickname", nickname);//이름
         

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return userInfo;
    }


   public AccountsBean GetAccountsEmail(String kakao_email) {
      AccountsBean ab= new AccountsBean();
      ab = sqlSessionTemplate.selectOne(namespace+".GetAccountsEmail",kakao_email); 
      
      return ab;
   }
  
   
   public String getAuthorizationUrl(HttpSession session) {
	   
       /* 세션 유효성 검증을 위하여 난수를 생성 */
       String state = generateRandomString();
       /* 생성한 난수 값을 session에 저장 */
       setSession(session,state);        

       /* Scribe에서 제공하는 인증 URL 생성 기능을 이용하여 네아로 인증 URL 생성 */
       OAuth20Service oauthService = new ServiceBuilder()                                                   
               .apiKey(CLIENT_ID)
               .apiSecret(CLIENT_SECRET)
               .callback(REDIRECT_URI)
               .state(state) //앞서 생성한 난수값을 인증 URL생성시 사용함
               .build(AccountsNaverLoginApi.instance());
System.out.println("1111111111111");
       return oauthService.getAuthorizationUrl();
   }

   /* 네이버아이디로 Callback 처리 및  AccessToken 획득 Method */
   public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException{

       /* Callback으로 전달받은 세선검증용 난수값과 세션에 저장되어있는 값이 일치하는지 확인 */
       String sessionState = getSession(session);
       if(StringUtils.pathEquals(sessionState, state)){

           OAuth20Service oauthService = new ServiceBuilder()
                   .apiKey(CLIENT_ID)
                   .apiSecret(CLIENT_SECRET)
                   .callback(REDIRECT_URI)
                   .state(state)
                   .build(AccountsNaverLoginApi.instance());

           /* Scribe에서 제공하는 AccessToken 획득 기능으로 네아로 Access Token을 획득 */
           OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
           System.out.println("22222222222222");
           return accessToken;
       } 
       return null;  
   }

   /* 세션 유효성 검증을 위한 난수 생성기 */
   private String generateRandomString() {
	   System.out.println("3333333333");
       return UUID.randomUUID().toString();
   }

   /* http session에 데이터 저장 */
   private void setSession(HttpSession session,String state){
       session.setAttribute(SESSION_STATE, state);   
       System.out.println("4444444444");
   }

   /* http session에서 데이터 가져오기 */ 
   private String getSession(HttpSession session){
       System.out.println("555555555555555555");
       return (String) session.getAttribute(SESSION_STATE);
   }
   /* Access Token을 이용하여 네이버 사용자 프로필 API를 호출 */
   public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException{

       OAuth20Service oauthService =new ServiceBuilder()
               .apiKey(CLIENT_ID)
               .apiSecret(CLIENT_SECRET)
               .callback(REDIRECT_URI).build(AccountsNaverLoginApi .instance());

           OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
       oauthService.signRequest(oauthToken, request);
       Response response = request.send();
       System.out.println("5555555555555");
       return response.getBody();
   }

    
    
   
}