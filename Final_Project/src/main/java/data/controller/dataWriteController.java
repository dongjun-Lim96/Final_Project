package data.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import data.model.DataBean;
import data.model.DataDao;

@Controller
public class dataWriteController {
   private final String command="write.dt";
   private final String getPage="dataWriteForm";
   private String gotoPage="redirect:/list.dt";



   @Autowired
   DataDao ddao;
   @Autowired
   ServletContext servletContext;
   
   
   
   @RequestMapping(value = command, method=RequestMethod.GET)
   public String doAction() {

      return getPage;
   }
   @RequestMapping(value = command, method=RequestMethod.POST)
   public ModelAndView doAction(@ModelAttribute("dataBean") @Valid DataBean dataBean,
         BindingResult result, HttpServletRequest request,Model model, HttpSession session) {


      ModelAndView mav = new ModelAndView();
      // 이미지 파일을 저장할 위치(웹서버폴더)
      
      AccountsBean loginInfo = (AccountsBean) session.getAttribute("loginInfo");
      // loginInfo 변수에 세션에서 가져온 "loginInfo" 값을 AccountsBean으로 형변환하여 저장
      model.addAttribute("loginInfo", loginInfo);
      
      String uploadPath = servletContext.getRealPath("/resources");
      System.out.println("uploadPath : " + uploadPath);
      // File 클래스 생성자에 문자열을 받을 수 있느 생성자가 있당
      // 위의 단순한 문자열을 폴더 개념으로 바꾸기 위해서는 File 객체를 생성함!
      // C:\\ ~ \resources\lemon.jpg 이렇게 파일이 올라가도록 한다
      
      System.out.println("*:"+uploadPath+File.separator+dataBean.getUpload().getOriginalFilename());
		
      File destination = new File(uploadPath + File.separator + dataBean.getUpload().getOriginalFilename());
      // File destination = new File(uploadPath + "/" + product.getImage());
      // File.separator : 역슬래시 추가
      // 자동으로 만들어지는 객체는 아님,,,
      // Bean의 getUpload를 보면 MultipartFile 객체를 리턴하는 것을 볼 수 있당. 따라서 아래처럼 객체 생성
      
      System.out.println(destination);
      
      MultipartFile multi = dataBean.getUpload();
      // 아래 폴더 밑에 올릴 준비를 햇음!
      String str = "c:/tempUpload";
      File destination_local = new File(str + File.separator + multi.getOriginalFilename());

      System.out.println(destination);
      System.out.println("*1:"+destination_local);
		
		
      dataBean.setDataDate(new Timestamp(System.currentTimeMillis()));

      
      if(result.hasErrors()) {
			System.out.println("유효성 검사 실패");
			mav.setViewName(getPage);
		}else {
      
      
      int cnt = ddao.writeData(dataBean);

      if(cnt != -1) {
     
         try {
            multi.transferTo(destination); // destination : 웹서버폴더
            FileCopyUtils.copy(destination, destination_local); // 웹서버폴더의 값을 로컬로 옮김
         } catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }

         mav.setViewName(gotoPage);
      }else {
         System.out.println("삽입 실패 : " + cnt);
         mav.setViewName(getPage);
      }
		}
   return mav;
}
}
 
