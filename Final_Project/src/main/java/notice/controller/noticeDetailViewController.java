package notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class noticeDetailViewController {
	private final String command="detailView.nt";
	private final String getPage="noticeDetailView";
	
	@Autowired
	NoticeDao ndao;
	
	@RequestMapping(value = command)
	public String doAtcion(Model model,@RequestParam("noticeNumber") int noticeNumber,
			@RequestParam("pageNumber") String pageNumber) {
		NoticeBean notice= new NoticeBean();
		notice = ndao.getOneNoticeByNum(noticeNumber);
		
		System.out.println("¿©±â´Â detailvie pageNumber"+pageNumber);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("notice",notice);
		return getPage;
	}
}
