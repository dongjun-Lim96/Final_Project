package accounts.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import accounts.model.AccountsBean;
import accounts.model.AccountsDao;

@Controller
public class AcoountsLoginController {
   
    
   @Autowired
   AccountsDao adao;
	private String apiResult = null;  
	
   @RequestMapping(value="/loginForm.acc", method = RequestMethod.GET)
   public String login(Model model, HttpSession session) {
	   String naverAuthUrl = adao.getAuthorizationUrl(session);
		
	 		//header에서 로그인 클릭시 url정보 넘어옴
	 		System.out.println("네이버:" + naverAuthUrl);
	 		
	 		//네이버 
	 		model.addAttribute("url", naverAuthUrl);
      return "accountsLoginForm";
   }
   //실험
   // submit클릭
   

   
   @RequestMapping(value="/loginForm.acc", method = RequestMethod.POST)
   public ModelAndView doAction(
         @RequestParam("userId") String input_userId,
         @RequestParam("userPw") String input_userPw,
         HttpServletResponse response, HttpSession session) {

      ModelAndView mav = new ModelAndView();
      
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = null;
      
      
      AccountsBean ab = adao.GetAccountsById(input_userId); // kim 1234
      System.out.println("ab:" + ab);
      
      if(ab == null || ab.getUserOut() == 1) { // 가입안함
         System.out.println("가입하지 않은 회원");
         
         try {
            out = response.getWriter();
            out.println("<script>alert('해당 아이디가 존재하지 않습니다.');history.go(-1);</script>");
            out.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
         
         mav.setViewName("accountsLoginForm");
         
      }else { // 가입한 회원
         System.out.println("가입한 회원");
         
         if(ab.getUserPw().equals(input_userPw)) {
            // 로그인
            session.setAttribute("loginInfo", ab);
            
            mav.setViewName((String)session.getAttribute("destination")); 
            // "redirect:/insert.prd" : 상품 추가
            // "redirect:/detail.prd" : 주문하기  
            
              
            mav.setViewName("redirect:/list.cs");
            
         }else { // 가입은 했는데 비번이 일치하지 않는다.
            
            try {
               out = response.getWriter();
               out.println("<script>alert('비번이 일치하지 않습니다.');history.go(-1);</script>");
               out.flush();
            } catch (IOException e) {
               e.printStackTrace();
            }
            
            mav.setViewName("accountsLoginForm");
         }
      }
      
      return mav;
   }

   @RequestMapping(value="/accountSearchForm.acc", method = RequestMethod.GET)
   public String searchAccounts() {
      return "accountSearchForm";
   }
   
   @RequestMapping(value="/searchAccountsUserId.acc", method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public void searchAccountsUserId(@RequestParam("userName") String input_userName,
           @RequestParam("userEmail") String input_userEmail, HttpServletResponse response) {
       System.out.println("aaaa");
       AccountsBean ab = adao.GetAccountsByNameEmail(input_userName,input_userEmail);
    
       response.setContentType("text/html; charset=UTF-8");
       PrintWriter out = null;
       if (ab == null) { // 가입안함
           System.out.println("가입하지 않은 회원");
           String strJson = "{userEmail: " + input_userEmail + ",checkGbn: N}";
           JSONObject jsonObj = new JSONObject(strJson);
           try {
               response.getWriter().append(jsonObj.toString());
           } catch (Exception e) {
               e.printStackTrace();
           }
       } else { // 가입한 회원
           System.out.println("가입한 회원");
           String strJson = "{userName: " + ab.getUserName() + ",checkGbn: Y}";
            JSONObject jsonObj = new JSONObject(strJson);
            jsonObj.put("userId", ab.getUserId());
            try {
                response.getWriter().append(jsonObj.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
       }
   }
   
   @RequestMapping(value="/accountPwSearchForm.acc", method = RequestMethod.GET)
   public String searchAccountsPw() {
      return "accountPwSearchForm";
   }
   
   
    @RequestMapping(value = "/getKakaoAuthUrl.acc")
    public @ResponseBody
    String getKakaoAuthUrl(
            HttpServletRequest request) throws Exception {
        System.out.println("--------- 카카오연동 들어옴 ---------");

        String reqUrl =
                "https://kauth.kakao.com/oauth/authorize?client_id=60dd63bcf46b11648aa82580a9f4ef16"
                        + "&redirect_uri=http://localhost:8080/ex/loading.acc"
                        + "&response_type=code";

        System.out.println(reqUrl);
        return reqUrl;
    }
    
    
 // 카카오 연동정보 조회 + DB에 회원 정보넣기
    @RequestMapping(value = "/selectMyAccessTocken.acc")
    public String oauthKakao(
            @RequestParam(value = "code", required = false) String code
            , HttpServletRequest req) throws Exception {

        System.out.println("--------- 카카오 정보조회 들어옴 ---------");

        // 발급받은 인가코드(reqUrl)를 통해 토큰 발급받기
        System.out.println("#########" + code);   
        String access_Token = adao.getAccessToken(code);    // 인가코드를 통해 토큰발급
        System.out.println("###access_Token#### : " + access_Token);    // 확인용 토큰 출력


        // 토큰을 이용해 회원 정보 가져오기
        HashMap<String, Object> userInfo = adao.getUserInfo(access_Token);
        System.out.println("------- access_Token ------- : " + access_Token);
        System.out.println("------- userInfo ------- : " + userInfo.get("email"));    // 회원 이메일
        System.out.println("------- nickname ------- : " + userInfo.get("nickname"));  

       
        AccountsBean ab1 = new AccountsBean();
        String kakao_email = (String) userInfo.get("email");
        String kakao_nickname = (String) userInfo.get("nickname");
        System.out.println("kakao_email::"+kakao_email);
        System.out.println("kakao_nickname::"+kakao_nickname);
        
        AccountsBean kakao_ab = adao.GetAccountsEmail(kakao_email);
  System.out.println("kakao_ab"+kakao_ab);
        if(kakao_ab==null){
           
           System.out.println("카카오 이메일로 가입되지 않은 회원");
           ab1.setUserId(kakao_nickname);
           ab1.setUserEmail(kakao_email);
        //   adao.joinKakao(ab);
           
           return "loginForm.acc";
           
        }
           
        // 만약 이미 회원가입 된 회원이라면? 로그인하기
        HttpSession session = req.getSession(); // session 생성
        
        AccountsBean ab= adao.GetUserIdByUserEmail(kakao_email);
        
       session.setAttribute("loginInfo", ab);
        System.out.println("카카오로 로그인 하기~!");
        return "redirect:/list.cs"; //
        
    }
   







   @RequestMapping(value="/loading.acc", method = RequestMethod.GET)
   public String doAction() {
      return "accountLoadingForm";
   }
   
   
   @RequestMapping(value="/searchAccountsUserPw.acc", method = RequestMethod.POST)
   @ResponseStatus(HttpStatus.OK)
   @ResponseBody
   public void searchAccountsUserPw(@RequestParam("userId") String input_userId,
           @RequestParam("userEmail") String input_userEmail, HttpServletResponse response) {
       System.out.println("aaaa");
       AccountsBean ab = adao.GetAccountsByIdEmail(input_userId,input_userEmail);
    
       response.setContentType("text/html; charset=UTF-8");
       PrintWriter out = null;  
       if (ab == null) { // 가입안함
           System.out.println("가입하지 않은 회원");
           String strJson = "{userEmail: " + input_userEmail + ",checkGbn: N}";
           JSONObject jsonObj = new JSONObject(strJson);
           try {
               response.getWriter().append(jsonObj.toString());
           } catch (Exception e) {
               e.printStackTrace();
           }
       } else { // 가입한 회원
           System.out.println("가입한 회원");
               String strJson = "{userId: " + ab.getUserId() + ",checkGbn: Y}";
               JSONObject jsonObj = new JSONObject(strJson);
               jsonObj.put("userPw", ab.getUserPw());
               try {
                   response.getWriter().append(jsonObj.toString());
               } catch (Exception e) {
                   e.printStackTrace();
               }
       }
   }
 //네이버 로그인 성공시 callback호출 메소드
  	@RequestMapping(value = "/loadingN.acc", method = { RequestMethod.GET, RequestMethod.POST })
  	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException{
  		
  		System.out.println("여기는 callback");
  		OAuth2AccessToken oauthToken;
          oauthToken = adao.getAccessToken(session, code, state);
   
          //1. 로그인 사용자 정보를 읽어온다.
  		apiResult = adao.getUserProfile(oauthToken);  //String형식의 json데이터
  		
  		/** apiResult json 구조
  		{"resultcode":"00",
  		 "message":"success",
  		 "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
  		**/
  		System.out.println("apiResult"+apiResult);
  		//2. String형식인 apiResult를 json형태로 바꿈
  		JsonParser parser = new JsonParser();
  	    JsonElement element = parser.parse(apiResult);
  	//	Object obj = parser.parse(apiResult);
  	//	JSONObject jsonObj = (JSONObject) obj;
  		System.out.println(apiResult);
  		//3. 데이터 파싱 
  		//Top레벨 단계 _response 파싱
  		//JSONObject response_obj = (JSONObject)jsonObj.get("response");
  		//response의 nickname값 파싱
  		JsonObject jsonObj = element.getAsJsonObject();
  		JsonObject responseObj = jsonObj.getAsJsonObject("response");
  		String naverNickname = responseObj.get("nickname").getAsString();
  		String naverEmail = responseObj.get("email").getAsString();

  		//String naver_nickname = (String)response_obj.get("nickname");
  		//String naver_email = (String)response_obj.get("email");
   
  		System.out.println(naverNickname);
  		System.out.println(naverEmail);
  		
  		//4.파싱 닉네임 세션으로 저장
  		AccountsBean ab1= adao.GetUserIdByUserEmail(naverEmail);
  		if (ab1 == null) {
  		    // ab1이 null인 경우 register.acc로 리디렉션
  			System.out.println("네이버 이메일로 가입하지 않은 회원");  
  		    return "redirect:/loginForm.acc";
  		}
  		session.setAttribute("loginInfo",ab1); //세션 생성
  	   
  		model.addAttribute("result", apiResult);
  	     
  		return "redirect:/list.cs";
  	}
} 