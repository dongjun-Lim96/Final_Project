package accounts.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountsLogoutController {

    @RequestMapping(value = "/logout.acc", method = RequestMethod.POST)
    @ResponseBody
    public String logout(HttpSession session) {
  

    	session.removeAttribute("loginInfo");
 
        return "redirect:/list.cs";
    }
}