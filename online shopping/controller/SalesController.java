package com.llts.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.llts.miniproject.bo.SalesBo;
import com.llts.miniproject.bo.SalesBoDetails;
import com.llts.miniproject.bo.UserBo;
import com.llts.miniproject.bo.ProductBo;
import com.llts.miniproject.bo.ProductDetailsBo;
import com.llts.miniproject.model.Product;
import com.llts.miniproject.model.Sales;

@RestController
public class SalesController {
	
	@Autowired
	SalesBo sb;
	
	@Autowired
	SalesBoDetails sd;
	
	
	@RequestMapping("/viewsales")
	public ModelAndView m18(Model model) {
		ModelAndView mv=new ModelAndView("viewsales");
		List<Sales> li=sd.findAll();	
		model.addAttribute("list", li);
		return mv;
		
	}
	

}
