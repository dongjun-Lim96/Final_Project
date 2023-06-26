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
      // �̹��� ������ ������ ��ġ(����������)
      
      AccountsBean loginInfo = (AccountsBean) session.getAttribute("loginInfo");
      // loginInfo ������ ���ǿ��� ������ "loginInfo" ���� AccountsBean���� ����ȯ�Ͽ� ����
      model.addAttribute("loginInfo", loginInfo);
      
      String uploadPath = servletContext.getRealPath("/resources");
      System.out.println("uploadPath : " + uploadPath);
      // File Ŭ���� �����ڿ� ���ڿ��� ���� �� �ִ� �����ڰ� �ִ�
      // ���� �ܼ��� ���ڿ��� ���� �������� �ٲٱ� ���ؼ��� File ��ü�� ������!
      // C:\\ ~ \resources\lemon.jpg �̷��� ������ �ö󰡵��� �Ѵ�
      
      System.out.println("*:"+uploadPath+File.separator+dataBean.getUpload().getOriginalFilename());
		
      File destination = new File(uploadPath + File.separator + dataBean.getUpload().getOriginalFilename());
      // File destination = new File(uploadPath + "/" + product.getImage());
      // File.separator : �������� �߰�
      // �ڵ����� ��������� ��ü�� �ƴ�,,,
      // Bean�� getUpload�� ���� MultipartFile ��ü�� �����ϴ� ���� �� �� �ִ�. ���� �Ʒ�ó�� ��ü ����
      
      System.out.println(destination);
      
      MultipartFile multi = dataBean.getUpload();
      // �Ʒ� ���� �ؿ� �ø� �غ� ����!
      String str = "c:/tempUpload";
      File destination_local = new File(str + File.separator + multi.getOriginalFilename());

      System.out.println(destination);
      System.out.println("*1:"+destination_local);
		
		
      dataBean.setDataDate(new Timestamp(System.currentTimeMillis()));

      
      if(result.hasErrors()) {
			System.out.println("��ȿ�� �˻� ����");
			mav.setViewName(getPage);
		}else {
      
      
      int cnt = ddao.writeData(dataBean);

      if(cnt != -1) {
     
         try {
            multi.transferTo(destination); // destination : ����������
            FileCopyUtils.copy(destination, destination_local); // ������������ ���� ���÷� �ű�
         } catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }

         mav.setViewName(gotoPage);
      }else {
         System.out.println("���� ���� : " + cnt);
         mav.setViewName(getPage);
      }
		}
   return mav;
}
}
 
