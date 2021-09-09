package com.llts.miniproject.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.llts.miniproject.bo.SalesBo;
import com.llts.miniproject.bo.SalesBoDetails;
import com.llts.miniproject.bo.ProductBo;
import com.llts.miniproject.bo.ProductDetailsBo;
import com.llts.miniproject.bo.UserBo;
import com.llts.miniproject.model.Product;
import com.llts.miniproject.model.Sales;
import com.llts.miniproject.model.User;

@RestController
public class HomeController {
	
	@Autowired
	UserBo ub;
	
	@Autowired
	ProductBo md;
	
	@Autowired
	ProductDetailsBo pd;
	
	@Autowired
	SalesBo sb;
	
	@Autowired
	SalesBoDetails sd;
	
	@RequestMapping("/")
	public ModelAndView m1() {
		return new ModelAndView("index");
	}
	@RequestMapping("/home")
	public ModelAndView m11() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/registration")
	public ModelAndView m4() {
		return new ModelAndView("registration");
	}
	@RequestMapping(value="insertuser", method=RequestMethod.POST)
	public ModelAndView m5(Model model, HttpServletRequest request) {
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		LocalDate ld=LocalDate.parse(request.getParameter("dob"));
		User u=new User(email,uname,mobile,address,ld,password,"USER");
		boolean b=ub.insertUser(u);
		if(b==false) {
			model.addAttribute("msg", "Successfully Inserted.. ");
			return new ModelAndView("welcome");
		}else {
			return new ModelAndView("error");
		}		
	}
	@RequestMapping("/login")
	public ModelAndView m6() {
		return new ModelAndView("login");
	}
	@RequestMapping("/logout")
	public ModelAndView m3() {
		return new ModelAndView("index");
	}
	@RequestMapping("/logoutuser")
	public ModelAndView m5() {
		return new ModelAndView("index");
	}
	@RequestMapping(value="checkuser")
	public ModelAndView m7(HttpServletRequest request, Model model) {
		ModelAndView mv=null;
		String role="ADMIN";
		String email=request.getParameter("email");
		String password=request.getParameter("password");			
		User u=ub.checkUserByEmail(email);
		
		if(u!=null) {	
			
			if(u.getEmail().equals(email) && password.equals(u.getPassword())) {
				
				if(u.getRole().equalsIgnoreCase(role) ) {
					mv=new ModelAndView("welcomeadmin");
				}
				else {
					model.addAttribute("uname", u.getName());
					mv=new ModelAndView("welcome");
				}
			}
			else {
					model.addAttribute("msg", "Check Credentials email or password is wrong");
					mv=new ModelAndView("login");
				}
		}
		else{
			model.addAttribute("msg", "Not registered!! Please Sign up");
			mv=new ModelAndView("login");
		}
		return mv; 
	}

	@RequestMapping("/updateuser")
	public ModelAndView m9(@RequestParam String email, Model model) {
		ModelAndView mv= new ModelAndView("updateuser");
		User u=ub.checkUserByEmail(email);
		model.addAttribute("user", u);
		return mv;
	}
	@RequestMapping(value="updateuser", method=RequestMethod.POST)
	public ModelAndView m10(HttpServletRequest request, Model model) {
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String  mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		LocalDate ld=LocalDate.parse(request.getParameter("dob"));
		User u=new User(email,uname,mobile,address,ld,password,request.getParameter("utype"));
		System.out.println(u);
		ModelAndView mv=null;
		boolean b=ub.updateUser(u);
		if(b==false) {
			mv=new ModelAndView("error");
		}
		else {
			model.addAttribute("msg", "Successfully Updated.. ");
			mv=new ModelAndView("welcome");
		}
		return mv;
	}


}
