package notice.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class noticeDeleteController {

	private final String command="deleteNotice.nt";
	private final String getPage="redirect:/list.nt";
	private final String backPage="redirect:/detailView.nt";
	
	@Autowired
	NoticeDao ndao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method=RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("pageNumber") String pageNumber,
			@RequestParam("noticeNumber") int noticeNumber
			) {
		//System.out.println("deleteboard num,pageNumber"+num+"  "+pageNumber+"  "+password);
		ModelAndView mav = new ModelAndView();
		
		
		
		NoticeBean noticeBean = ndao.getOneNoticeByNum(noticeNumber);
		int cnt = ndao.deleteOneNotice(noticeNumber);
		
		mav.setViewName(getPage);
		if(cnt != -1) {
			System.out.println("��������");
			String deletePath = servletContext.getRealPath("/resources");
			// �̹��� ���� ���
			File nImage = new File(deletePath + File.separator + noticeBean.getNoticeImage());
			// ���ϻ���
			boolean flag = nImage.delete();
			if(flag) {
				System.out.println("�̹��� ���� ����");
				
			}else {
				System.out.println("�̹��� ���� ����");
				mav.setViewName(backPage);
			}
		}
		else{
			System.out.println("��������");
			mav.setViewName(backPage);
		}
		return mav; 
	}
}