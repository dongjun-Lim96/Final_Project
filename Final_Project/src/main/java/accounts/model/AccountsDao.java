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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

@Component
public class AccountsDao {

   private String namespace = "accounts.model";
   
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
      
    
    
   
}