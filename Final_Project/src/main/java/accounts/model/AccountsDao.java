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
   /* ������ ��ȸ API URL */
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

            //  URL������ ����¿� ��� �� �� �ְ�, POST Ȥ�� PUT ��û�� �Ϸ��� setDoOutput�� true�� �����ؾ���.
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //   POST ��û�� �ʿ�� �䱸�ϴ� �Ķ���� ��Ʈ���� ���� ����
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=60dd63bcf46b11648aa82580a9f4ef16");  //������ �߱޹��� REST API key
            sb.append("&redirect_uri=http://localhost:8080/ex/loading.acc");     // ������ ������ ���� ���
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //    ��� �ڵ尡 200�̶�� ����
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    ��û�� ���� ���� JSONŸ���� Response �޼��� �о����
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //    Gson ���̺귯���� ���Ե� Ŭ������ JSON�Ľ� ��ü ����
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
        //    ��û�ϴ� Ŭ���̾�Ʈ���� ���� ������ �ٸ� �� �ֱ⿡ HashMapŸ������ ����
        HashMap<String, Object> userInfo = new HashMap<String, Object>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            //    ��û�� �ʿ��� Header�� ���Ե� ����
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
           userInfo.put("email", email);//�̸���
           userInfo.put("nickname", nickname);//�̸�
         

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
	   
       /* ���� ��ȿ�� ������ ���Ͽ� ������ ���� */
       String state = generateRandomString();
       /* ������ ���� ���� session�� ���� */
       setSession(session,state);        

       /* Scribe���� �����ϴ� ���� URL ���� ����� �̿��Ͽ� �׾Ʒ� ���� URL ���� */
       OAuth20Service oauthService = new ServiceBuilder()                                                   
               .apiKey(CLIENT_ID)
               .apiSecret(CLIENT_SECRET)
               .callback(REDIRECT_URI)
               .state(state) //�ռ� ������ �������� ���� URL������ �����
               .build(AccountsNaverLoginApi.instance());
System.out.println("1111111111111");
       return oauthService.getAuthorizationUrl();
   }

   /* ���̹����̵�� Callback ó�� ��  AccessToken ȹ�� Method */
   public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException{

       /* Callback���� ���޹��� ���������� �������� ���ǿ� ����Ǿ��ִ� ���� ��ġ�ϴ��� Ȯ�� */
       String sessionState = getSession(session);
       if(StringUtils.pathEquals(sessionState, state)){

           OAuth20Service oauthService = new ServiceBuilder()
                   .apiKey(CLIENT_ID)
                   .apiSecret(CLIENT_SECRET)
                   .callback(REDIRECT_URI)
                   .state(state)
                   .build(AccountsNaverLoginApi.instance());

           /* Scribe���� �����ϴ� AccessToken ȹ�� ������� �׾Ʒ� Access Token�� ȹ�� */
           OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
           System.out.println("22222222222222");
           return accessToken;
       } 
       return null;  
   }

   /* ���� ��ȿ�� ������ ���� ���� ������ */
   private String generateRandomString() {
	   System.out.println("3333333333");
       return UUID.randomUUID().toString();
   }

   /* http session�� ������ ���� */
   private void setSession(HttpSession session,String state){
       session.setAttribute(SESSION_STATE, state);   
       System.out.println("4444444444");
   }

   /* http session���� ������ �������� */ 
   private String getSession(HttpSession session){
       System.out.println("555555555555555555");
       return (String) session.getAttribute(SESSION_STATE);
   }
   /* Access Token�� �̿��Ͽ� ���̹� ����� ������ API�� ȣ�� */
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