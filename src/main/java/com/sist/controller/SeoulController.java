package com.sist.controller;

import com.sist.dao.SeoulDAO;
import com.sist.vo.SeoulHotelVO;
import com.sist.vo.SeoulLocationVO;
import com.sist.vo.SeoulNatureVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seoul/")
public class SeoulController {

	@Autowired
	private SeoulDAO dao;

	@GetMapping("location_list.do")
	public String seoul_location_list(String page, Model model) {
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize * (curpage - 1)) + 1;
		int end = (rowSize * curpage);
		map.put("start", start);
		map.put("end", end);
		List<SeoulLocationVO> list = dao.locationListData(map);

		map = new HashMap();
		map.put("table_name", "seoul_location");
		int totalpage = dao.seoulTotalPage(map);
		final int block = 10;
		int startPage = ((curpage - 1) / block * block) + 1;
		int endPage = ((curpage - 1) / block * block) + block;
		if (endPage > totalpage) {
			endPage = totalpage;
		}

		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("BLOCK", block);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../seoul/location_list.jsp");

		return "main/main";
	}

	@GetMapping("nature_list.do")
	public String seoul_nature_list(String page, Model model) {
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize * (curpage - 1)) + 1;
		int end = (rowSize * curpage);
		map.put("start", start);
		map.put("end", end);
		List<SeoulNatureVO> list = dao.natureListData(map);

		map = new HashMap();
		map.put("table_name", "seoul_nature");
		int totalpage = dao.seoulTotalPage(map);
		final int block = 10;
		int startPage = ((curpage - 1) / block * block) + 1;
		int endPage = ((curpage - 1) / block * block) + block;
		if (endPage > totalpage) {
			endPage = totalpage;
		}

		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("BLOCK", block);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../seoul/nature_list.jsp");

		return "main/main";
	}

	@GetMapping("hotel_list.do")
	public String seoul_hotel_list(String page, Model model) {
		if (page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		Map map = new HashMap();
		int rowSize = 12;
		int start = (rowSize * (curpage - 1)) + 1;
		int end = (rowSize * curpage);
		map.put("start", start);
		map.put("end", end);
		List<SeoulHotelVO> list = dao.hotelListData(map);

		map = new HashMap();
		map.put("table_name", "seoul_hotel");
		int totalpage = dao.seoulTotalPage(map);
		final int block = 10;
		int startPage = ((curpage - 1) / block * block) + 1;
		int endPage = ((curpage - 1) / block * block) + block;
		if (endPage > totalpage) {
			endPage = totalpage;
		}

		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("BLOCK", block);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		model.addAttribute("list", list);
		model.addAttribute("main_jsp", "../seoul/hotel_list.jsp");

		return "main/main";
	}
}