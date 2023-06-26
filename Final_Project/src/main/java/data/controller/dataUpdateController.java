package data.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsDao;
import data.model.DataBean;
import data.model.DataDao;


@Controller
public class dataUpdateController {
	private final String command="updateData.dt";
	private final String getPage="dataUpdateForm";
	private final String backPage="redirect:/detailView.dt";
	private final String gotoPage="redirect:/list.dt";
	
	@Autowired
	DataDao ddao;
	AccountsDao adao;
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public String doAction(@RequestParam("pageNumber") String pageNumber,
			@RequestParam("dataNumber") int dataNumber,
			Model model) {
			DataBean data = ddao.getOneDataByNum(dataNumber);
			System.out.println(dataNumber+" , "+ pageNumber);
			model.addAttribute("data", data);
			model.addAttribute("dataNumber", dataNumber);
			model.addAttribute("pageNumber",pageNumber);
			
			return getPage;
					
		}

	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("data") @Valid DataBean data,
			BindingResult result,
			@RequestParam("pageNumber") int pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if(result.hasErrors()) {
			// 수정실패했을때도 이미지 띄우려고 작성함.
			// 또는 위에 if문처럼 작성해도 됨!
			data.setDataImage(data.getUpload2());
			mav.setViewName(getPage);
		}else {

			
		
	if(data.getDataImage().equals("")) {
		data.setDataImage(data.getUpload2());
			
			int cnt = ddao.updateData(data);
			if(cnt != -1) {
	
				MultipartFile multi = data.getUpload();  
				try {

				} catch (IllegalStateException e) {
					e.printStackTrace();
				}

			} // if cnt
			mav.setViewName(gotoPage); 
	
			

	

		}else {
			//웹서버경로
			String uploadPath = servletContext.getRealPath("/resources");
			//업로드파일경로
			File destination = new File(uploadPath + "//" + data.getUpload().getOriginalFilename());
			//삭제파일경로
			File delFile = new File(uploadPath + File.separator + data.getUpload2());
			
			//수정작업
			int cnt = ddao.updateData(data);
			
			if(cnt != -1) {
				// DB 작업 완료 후 원래이미지 지우고, 새로운 이미지를 올려야한다.
				//파일객체 주입
				MultipartFile multi = data.getUpload();  
				try {
					//파일업로드 작업
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 업로드 후 원래 파일 삭제
				delFile.delete();
			} // if cnt
			mav.setViewName(gotoPage);
		}
		
	}
		return mav;
	}
}