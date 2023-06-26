package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.model.DataBean;
import data.model.DataDao;

@Controller
public class dataDetailViewController {
	private final String command="detailView.dt";
	private final String getPage="dataDetailView";
	
	@Autowired
	DataDao ddao;
	
	@RequestMapping(value = command)
	public String doAtcion(Model model,@RequestParam("dataNumber") int dataNumber,
			@RequestParam("pageNumber") String pageNumber) {
		DataBean data= new DataBean();
		data = ddao.getOneDataByNum(dataNumber);
		
		System.out.println("¿©±â´Â detailvie pageNumber"+pageNumber);
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("data",data);
		return getPage;
	}
} 
