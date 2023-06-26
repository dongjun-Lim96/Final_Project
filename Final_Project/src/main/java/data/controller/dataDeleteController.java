package data.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.model.DataBean;
import data.model.DataDao;

@Controller
public class dataDeleteController {

	private final String command="deleteData.dt";
	private final String getPage="redirect:/list.dt";
	private final String backPage="redirect:/detailView.dt";
	
	@Autowired
	DataDao ddao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method=RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("pageNumber") String pageNumber,
			@RequestParam("dataNumber") int dataNumber
			) {
		//System.out.println("deleteboard num,pageNumber"+num+"  "+pageNumber+"  "+password);
		ModelAndView mav = new ModelAndView();
		
		
		
		DataBean dataBean = ddao.getOneDataByNum(dataNumber);
		int cnt = ddao.deleteOneData(dataNumber);
		
		mav.setViewName(getPage);
		if(cnt != -1) {
			System.out.println("삭제성공");
			String deletePath = servletContext.getRealPath("/resources");
			// 이미지 파일 경로
			File nImage = new File(deletePath + File.separator + dataBean.getDataImage());
			// 파일삭제
			boolean flag = nImage.delete();
			if(flag) {
				System.out.println("이미지 삭제 성공");
				
			}else {
				System.out.println("이미지 삭제 실패");
				mav.setViewName(backPage);
			}
		}
		else{
			System.out.println("삭제실패");
			mav.setViewName(backPage);
		}
		return mav; 
	}
}