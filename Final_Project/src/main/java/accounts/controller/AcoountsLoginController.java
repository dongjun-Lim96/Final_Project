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
		
	 		//header���� �α��� Ŭ���� url���� �Ѿ��
	 		System.out.println("���̹�:" + naverAuthUrl);
	 		
	 		//���̹� 
	 		model.addAttribute("url", naverAuthUrl);
      return "accountsLoginForm";
   }
   //����
   // submitŬ��
   

   
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
      
      if(ab == null || ab.getUserOut() == 1) { // ���Ծ���
         System.out.println("�������� ���� ȸ��");
         
         try {
            out = response.getWriter();
            out.println("<script>alert('�ش� ���̵� �������� �ʽ��ϴ�.');history.go(-1);</script>");
            out.flush();
         } catch (IOException e) {
            e.printStackTrace();
         }
         
         mav.setViewName("accountsLoginForm");
         
      }else { // ������ ȸ��
         System.out.println("������ ȸ��");
         
         if(ab.getUserPw().equals(input_userPw)) {
            // �α���
            session.setAttribute("loginInfo", ab);
            
            mav.setViewName((String)session.getAttribute("destination")); 
            // "redirect:/insert.prd" : ��ǰ �߰�
            // "redirect:/detail.prd" : �ֹ��ϱ�  
            
              
            mav.setViewName("redirect:/list.cs");
            
         }else { // ������ �ߴµ� ����� ��ġ���� �ʴ´�.
            
            try {
               out = response.getWriter();
               out.println("<script>alert('����� ��ġ���� �ʽ��ϴ�.');history.go(-1);</script>");
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
       if (ab == null) { // ���Ծ���
           System.out.println("�������� ���� ȸ��");
           String strJson = "{userEmail: " + input_userEmail + ",checkGbn: N}";
           JSONObject jsonObj = new JSONObject(strJson);
           try {
               response.getWriter().append(jsonObj.toString());
           } catch (Exception e) {
               e.printStackTrace();
           }
       } else { // ������ ȸ��
           System.out.println("������ ȸ��");
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
        System.out.println("--------- īī������ ���� ---------");

        String reqUrl =
                "https://kauth.kakao.com/oauth/authorize?client_id=60dd63bcf46b11648aa82580a9f4ef16"
                        + "&redirect_uri=http://localhost:8080/ex/loading.acc"
                        + "&response_type=code";

        System.out.println(reqUrl);
        return reqUrl;
    }
    
    
 // īī�� �������� ��ȸ + DB�� ȸ�� �����ֱ�
    @RequestMapping(value = "/selectMyAccessTocken.acc")
    public String oauthKakao(
            @RequestParam(value = "code", required = false) String code
            , HttpServletRequest req) throws Exception {

        System.out.println("--------- īī�� ������ȸ ���� ---------");

        // �߱޹��� �ΰ��ڵ�(reqUrl)�� ���� ��ū �߱޹ޱ�
        System.out.println("#########" + code);   
        String access_Token = adao.getAccessToken(code);    // �ΰ��ڵ带 ���� ��ū�߱�
        System.out.println("###access_Token#### : " + access_Token);    // Ȯ�ο� ��ū ���


        // ��ū�� �̿��� ȸ�� ���� ��������
        HashMap<String, Object> userInfo = adao.getUserInfo(access_Token);
        System.out.println("------- access_Token ------- : " + access_Token);
        System.out.println("------- userInfo ------- : " + userInfo.get("email"));    // ȸ�� �̸���
        System.out.println("------- nickname ------- : " + userInfo.get("nickname"));  

       
        AccountsBean ab1 = new AccountsBean();
        String kakao_email = (String) userInfo.get("email");
        String kakao_nickname = (String) userInfo.get("nickname");
        System.out.println("kakao_email::"+kakao_email);
        System.out.println("kakao_nickname::"+kakao_nickname);
        
        AccountsBean kakao_ab = adao.GetAccountsEmail(kakao_email);
  System.out.println("kakao_ab"+kakao_ab);
        if(kakao_ab==null){
           
           System.out.println("īī�� �̸��Ϸ� ���Ե��� ���� ȸ��");
           ab1.setUserId(kakao_nickname);
           ab1.setUserEmail(kakao_email);
        //   adao.joinKakao(ab);
           
           return "loginForm.acc";
           
        }
           
        // ���� �̹� ȸ������ �� ȸ���̶��? �α����ϱ�
        HttpSession session = req.getSession(); // session ����
        
        AccountsBean ab= adao.GetUserIdByUserEmail(kakao_email);
        
       session.setAttribute("loginInfo", ab);
        System.out.println("īī���� �α��� �ϱ�~!");
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
       if (ab == null) { // ���Ծ���
           System.out.println("�������� ���� ȸ��");
           String strJson = "{userEmail: " + input_userEmail + ",checkGbn: N}";
           JSONObject jsonObj = new JSONObject(strJson);
           try {
               response.getWriter().append(jsonObj.toString());
           } catch (Exception e) {
               e.printStackTrace();
           }
       } else { // ������ ȸ��
           System.out.println("������ ȸ��");
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
 //���̹� �α��� ������ callbackȣ�� �޼ҵ�
  	@RequestMapping(value = "/loadingN.acc", method = { RequestMethod.GET, RequestMethod.POST })
  	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException, ParseException{
  		
  		System.out.println("����� callback");
  		OAuth2AccessToken oauthToken;
          oauthToken = adao.getAccessToken(session, code, state);
   
          //1. �α��� ����� ������ �о�´�.
  		apiResult = adao.getUserProfile(oauthToken);  //String������ json������
  		
  		/** apiResult json ����
  		{"resultcode":"00",
  		 "message":"success",
  		 "response":{"id":"33666449","nickname":"shinn****","age":"20-29","gender":"M","email":"sh@naver.com","name":"\uc2e0\ubc94\ud638"}}
  		**/
  		System.out.println("apiResult"+apiResult);
  		//2. String������ apiResult�� json���·� �ٲ�
  		JsonParser parser = new JsonParser();
  	    JsonElement element = parser.parse(apiResult);
  	//	Object obj = parser.parse(apiResult);
  	//	JSONObject jsonObj = (JSONObject) obj;
  		System.out.println(apiResult);
  		//3. ������ �Ľ� 
  		//Top���� �ܰ� _response �Ľ�
  		//JSONObject response_obj = (JSONObject)jsonObj.get("response");
  		//response�� nickname�� �Ľ�
  		JsonObject jsonObj = element.getAsJsonObject();
  		JsonObject responseObj = jsonObj.getAsJsonObject("response");
  		String naverNickname = responseObj.get("nickname").getAsString();
  		String naverEmail = responseObj.get("email").getAsString();

  		//String naver_nickname = (String)response_obj.get("nickname");
  		//String naver_email = (String)response_obj.get("email");
   
  		System.out.println(naverNickname);
  		System.out.println(naverEmail);
  		
  		//4.�Ľ� �г��� �������� ����
  		AccountsBean ab1= adao.GetUserIdByUserEmail(naverEmail);
  		if (ab1 == null) {
  		    // ab1�� null�� ��� register.acc�� ���𷺼�
  			System.out.println("���̹� �̸��Ϸ� �������� ���� ȸ��");  
  		    return "redirect:/loginForm.acc";
  		}
  		session.setAttribute("loginInfo",ab1); //���� ����
  	   
  		model.addAttribute("result", apiResult);
  	     
  		return "redirect:/list.cs";
  	}
} 