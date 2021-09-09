package com.llts.miniproject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.llts.miniproject.bo.ProductBo;
import com.llts.miniproject.bo.ProductDetailsBo;

import com.llts.miniproject.model.Product;
import com.llts.miniproject.model.User;
@RestController
public class ProductController {
	
	@Autowired
	ProductBo md;
	
	@Autowired
	ProductDetailsBo pd;
	
	@RequestMapping("/addproduct")
	public ModelAndView m2() {
		return new ModelAndView("addproduct");
	}	
	
	@RequestMapping(value="/insertproduct", method=RequestMethod.POST)
	 public ModelAndView saveProduct(@RequestParam("file") MultipartFile file,
	    		@RequestParam("pname") String pname,
	    		@RequestParam("pid") int pid,
	    		@RequestParam("pcat") String pcat,
	    		@RequestParam("pcost") int pcost,
	    		@RequestParam("quantity") int quantity,
	    		@RequestParam("pdescribe") String pdescribe
	    		)
	    {
				md.saveProduct(file, pname, pdescribe, pcost, quantity,pid,pcat);
			 	return new ModelAndView("welcomeadmin");
			 	
	    }
		
	@RequestMapping("/products")
	public List<Product> getProducts(){
		return pd.findAll();
	}
	@RequestMapping("/viewproducts")
	public ModelAndView m8(Model model) {
		ModelAndView mv=new ModelAndView("viewproducts");
		List<Product> li=pd.findAll();	
		model.addAttribute("list", li);
		return mv;
		
	}	

	@RequestMapping("/updateproduct")
	public ModelAndView m19() {
		return new ModelAndView("updateproduct");
	}
	@RequestMapping(value="updateproduct", method=RequestMethod.POST)
	
		public ModelAndView updateProduct(@RequestParam("file") MultipartFile file,
	    		@RequestParam("pname") String pname,
	    		@RequestParam("pid") int pid,
	    		@RequestParam("pcat") String pcat,
	    		@RequestParam("pcost") int pcost,
	    		@RequestParam("quantity") int quantity,
	    		@RequestParam("pdescribe") String pdescribe
	    		)
	    {
				md.updateProduct(file, pname, pdescribe, pcost, quantity,pid,pcat);
			 	return new ModelAndView("welcomeadmin");
			 	
	    }
		
	@RequestMapping("/deleteproduct")
	public ModelAndView m21() {
		return new ModelAndView("deleteproduct");
	}
	@RequestMapping(value="deleteproduct", method=RequestMethod.POST)
	public ModelAndView m22(HttpServletRequest request, Model model) {
		int pid=Integer.parseInt(request.getParameter("pid"));
		ModelAndView mv=null;
		boolean b=md.deleteProductById(pid);
		if(b==false) {
			mv=new ModelAndView("error");
		}
		else {
			model.addAttribute("msg", "Successfully deleted... ");
			mv=new ModelAndView("welcomeadmin");
		}
		return mv;
	}
	@RequestMapping("/buyproduct")
	public ModelAndView m88(Model model) {
		ModelAndView mv=new ModelAndView("buyproduct");
		List<Product> li=pd.findAll();	
		model.addAttribute("list", li);
		return mv;
		
	}
	@RequestMapping(value = "buyproduct" , method = RequestMethod. POST)
	public  ModelAndView m22(HttpServletRequest request, HttpServletResponse response, Model model,@RequestParam(value = "checkbox", required = false) String checkboxValue) 
	{ 	

		ModelAndView mv=null;	
	  if(checkboxValue!=null )
	  {
		  int checks=Integer.parseInt(request.getParameter("checkbox"));
	    Product b=md.getProductById(checks);
	    String pname=b.getPname();
	    int pcost=b.getPcost();
		mv=new ModelAndView("makeorder");
	    	    
	  }
	  else
	  {
		 model.addAttribute("msg", "Please choose any product");
	    mv=new ModelAndView("error");
	    
	  }	
	  return mv;
	}
	@RequestMapping("/makeorder")
	public ModelAndView m11(Model model) {
		
		return new ModelAndView("makeorder");
	}
	
}
